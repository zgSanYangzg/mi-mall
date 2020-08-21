package cn.enjoy.kill.service.impl;

import cn.enjoy.core.exception.BusinessException;
import cn.enjoy.kill.dao.OrderGoodsMapper;
import cn.enjoy.kill.dao.OrderMapper;
import cn.enjoy.kill.dao.UserAddressMapper;
import cn.enjoy.mall.constant.MallConstant;
import cn.enjoy.mall.constant.OrderStatus;
import cn.enjoy.mall.constant.PayStatus;
import cn.enjoy.mall.constant.ShippingStatus;
import cn.enjoy.mall.model.Order;
import cn.enjoy.mall.model.OrderGoods;
import cn.enjoy.mall.model.SpecGoodsPrice;
import cn.enjoy.mall.model.UserAddress;
import cn.enjoy.mall.mongo.GoodsDao;
import cn.enjoy.mall.service.IKillOrderActionService;
import cn.enjoy.mall.service.IKillOrderService;
import cn.enjoy.mall.vo.GoodsVo;
import cn.enjoy.mall.vo.KillGoodsSpecPriceDetailVo;
import cn.enjoy.mall.vo.KillOrderVo;
import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0|0|0 待支付
 * 0|0|1 已付款待配货
 * 1|0|1 已配货待出库
 * 1|1|1 待收货
 * 2|1|1 已完成
 * 4|1|1 已完成
 */
@RestController
public class OrderServiceImpl implements IKillOrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderGoodsMapper orderGoodsMapper;
    @Resource
    private UserAddressMapper userAddressMapper;
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private IKillOrderActionService orderActionService;
    @Resource
    private SequenceGenerator sequenceGenerator;

    @Autowired
    private DefaultUidGenerator defaultUidGenerator;

    @Autowired
    private CachedUidGenerator cachedUidGenerator;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 订单详情
     *
     * @param orderId
     * @return
     */
    public Order search(@PathVariable("orderId") Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order != null) {
            List<OrderGoods> goodsList = orderGoodsMapper.selectByOrderId(orderId);
            order.setOrderGoodsList(goodsList);
        }
        return order;
    }

    @Override
    public List<Order> queryOrderByUserId(String userId) {
        Map map = new HashMap();
        map.put("userId", userId);
        return orderMapper.queryByPage(map);
    }

    @Transactional
    public Long killOrder(Long addressId, KillGoodsSpecPriceDetailVo killGoods, String userId) {
        //创建一个订单
        Order order = new Order();
//        order.setOrderType("K");
        //从SequenceGenerator中获取订单的变化
        order.setOrderId(defaultUidGenerator.getUID());
        order.setOrderSn(sequenceGenerator.getOrderNo());
        order.setAddTime(System.currentTimeMillis());
        //设置订单的状态为未确定订单
        order.setOrderStatus(OrderStatus.UNCONFIRMED.getCode());
        //未支付
        order.setPayStatus(PayStatus.UNPAID.getCode());
        //未发货
        order.setShippingStatus(ShippingStatus.UNSHIPPED.getCode());
        //获取发货地址
        UserAddress userAddress = userAddressMapper.selectByPrimaryKey(addressId);
        BeanUtils.copyProperties(userAddress, order);
        order.setUserId(userId);

        //新增订单
        orderMapper.insert(order);
        Long orderId = order.getOrderId();
        BigDecimal totalAmount = new BigDecimal(0);
        //从mongodb的购物车中获取所购物品
        List<OrderGoods> orderGoodsList = new ArrayList<>();
        GoodsVo goodsVo = goodsDao.findOneBySpecGoodsId(killGoods.getSpecGoodsId());

        //创建的订单商品
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setRecId(defaultUidGenerator.getUID());
        orderGoods.setOrderType("K");
        orderGoods.setOrderId(orderId);
        BeanUtils.copyProperties(goodsVo.getBase(), orderGoods);
        orderGoods.setPromType(true);
        orderGoods.setPromId(killGoods.getId());
        orderGoods.setGoodsNum((short) 1);
        orderGoods.setGoodsPrice(killGoods.getPrice());
        orderGoods.setSpecKey(killGoods.getKey());
        orderGoods.setSpecKeyName(killGoods.getKeyName());
        orderGoods.setSpecGoodsId(killGoods.getSpecGoodsId());
        orderGoods.setOriginalImg(killGoods.getOriginalImg());
        orderGoodsList.add(orderGoods);
        totalAmount = totalAmount.add(killGoods.getPrice());
        order.setGoodsPrice(totalAmount);
        order.setShippingPrice(new BigDecimal(0));
        order.setOrderAmount(totalAmount.add(order.getShippingPrice()));
        order.setTotalAmount(totalAmount.add(order.getShippingPrice()));

        //修改订单
        orderMapper.updateByPrimaryKeySelective(order);

        //保存订单产品信息
        orderGoodsMapper.insertBatch(orderGoodsList);
        //订单日志
//        orderActionService.save(order, "创建秒杀订单", userId);

        //清空用于分页的缓存
        redisTemplate.opsForHash().delete(userId);
        return orderId;
    }

    @Transactional
    @Override
    public Long killOrder(KillOrderVo killOrderVo) {
        return this.killOrder(killOrderVo.getAddressId(),
                killOrderVo.getKillGoodsSpecPriceDetailVo(), killOrderVo.getUserId());
    }

    @Override
    public Order selectMyOrderDetail(Long orderId, String userId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order != null) {
            if (StringUtils.isEmpty(userId) || !userId.equals(order.getUserId())) {
                return null;
            }
            List<OrderGoods> goodsList = orderGoodsMapper.selectByOrderId(orderId);
            order.setOrderGoodsList(goodsList);
        }
        return order;
    }

    @Transactional
    @Override
    public void cancel(Long orderId) {
        cancel(orderId, null, false);
    }

    private void cancel(Long orderId, String userId, boolean checkUser) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order != null) {
            if (checkUser) {
                if (StringUtils.isEmpty(userId) || !userId.equals(order.getUserId())) {
                    throw new BusinessException("订单不存在");
                }
            }
        } else {
            throw new BusinessException("订单不存在");
        }
        order.setOrderStatus(OrderStatus.CANCELED.getCode());
        List<OrderGoods> orderGoodsList = orderGoodsMapper.selectByOrderId(orderId);
        for (OrderGoods orderGoods : orderGoodsList) {
            GoodsVo goodsVo = goodsDao.findOneById(orderGoods.getGoodsId());
            if (goodsVo != null) {
                List<SpecGoodsPrice> specGoodsPriceList = goodsVo.getSpecGoodsPriceList();
                specGoodsPriceList.forEach(x -> x.setStoreCount(x.getStoreCount() + orderGoods.getGoodsNum()));
                goodsVo.setSpecGoodsPriceList(specGoodsPriceList);
                goodsDao.save(goodsVo);
            }
        }
        orderMapper.updateByPrimaryKeySelective(order);
        //订单日志
        orderActionService.save(order, checkUser == true ? "取消订单" : "自动取消订单", userId);
    }

    @Transactional
    @Override
    public void selfCancel(Long orderId, String userId) {
        cancel(orderId, userId, true);
    }

    @Transactional
    @Override
    public void autoCancelExpiredOrder() {
        List<Order> expiredOrderList = orderMapper.selectExpiredOrder(MallConstant.EXPIRED_TIME_INTERVAL);
        if (!CollectionUtils.isEmpty(expiredOrderList)) {
            for (Order order : expiredOrderList) {
                cancel(order.getOrderId());
            }
        }
    }

    /**
     * 查询各类型的订单
     *
     * @param type 0-全部订单，1-全部有效订单，2-待支付，3-待收货，4-已关闭
     * @return
     */
    @Override
    public Integer queryOrderNum(Integer type, String userId) {
        return orderMapper.selectOrderNum(type, userId);
    }

    @Transactional
    @Override
    public void confirmReceiveGoods(Long orderId, String userId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new BusinessException("订单不存在");
        } else {
            if (StringUtils.isEmpty(userId) || !userId.equals(order.getUserId())) {
                throw new BusinessException("订单不存在");
            }
        }
        order.setOrderStatus(OrderStatus.RECEIVED.getCode());
        order.setReceiveTime(System.currentTimeMillis());
        List<OrderGoods> orderGoodsList = orderGoodsMapper.selectByOrderId(orderId);
        for (OrderGoods orderGoods : orderGoodsList) {
            GoodsVo goodsVo = goodsDao.findOneById(orderGoods.getGoodsId());
            if (goodsVo != null) {
                List<SpecGoodsPrice> specGoodsPriceList = goodsVo.getSpecGoodsPriceList();
                specGoodsPriceList.forEach(x -> x.setStoreCount(x.getStoreCount() + orderGoods.getGoodsNum()));
                goodsVo.setSpecGoodsPriceList(specGoodsPriceList);
                goodsDao.save(goodsVo);
            }
        }
        orderMapper.updateByPrimaryKeySelective(order);
        //订单日志
        orderActionService.save(order, "确认收货", userId);
    }

    /**
     * 根据类型获取订单状态
     *
     * @param type
     * @return
     */
    private Integer getOrderStatusByType(Integer type) {
        Integer orderStatus = null;
        if (type == 0) {
            orderStatus = null;
        } else if (type == 1) {
            orderStatus = 99;
        } else if (type == 2) {
            orderStatus = OrderStatus.CONFIRMED.getCode();
        } else if (type == 3) {
            orderStatus = OrderStatus.CONFIRMED.getCode();
        } else if (type == 4) {
            orderStatus = OrderStatus.CANCELED.getCode();
        }
        return orderStatus;
    }

    /**
     * 根据类型获取支付状态
     *
     * @param type
     * @return
     */
    private Integer getPayStatusByType(Integer type) {
        Integer payStatus = null;
        if (type == 0) {
            payStatus = null;
        } else if (type == 1) {
            payStatus = null;
        } else if (type == 2) {
            payStatus = PayStatus.UNPAID.getCode();
        } else if (type == 3) {
            payStatus = PayStatus.PAID.getCode();
        } else if (type == 4) {
            payStatus = null;
        }
        return payStatus;
    }

    @Override
    public List<Order> queryByPage(Integer type, String keywords, String userId, Long addTime,int pageSize) {
        List<Order> pageList = orderMapper.queryByPage(type, keywords,userId, addTime == 0 ? "" : addTime,pageSize);
        return pageList;
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }
}
