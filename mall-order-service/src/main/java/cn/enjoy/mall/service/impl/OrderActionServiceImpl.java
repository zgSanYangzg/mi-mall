package cn.enjoy.mall.service.impl;

import cn.enjoy.mall.dao.OrderActionMapper;
import cn.enjoy.mall.model.Order;
import cn.enjoy.mall.model.OrderAction;
import cn.enjoy.mall.service.IOrderActionService;
import com.alibaba.fastjson.JSONObject;
import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
public class OrderActionServiceImpl implements IOrderActionService {
    @Resource
    private OrderActionMapper orderActionMapper;

    @Autowired
    private DefaultUidGenerator defaultUidGenerator;

    @Autowired
    private CachedUidGenerator cachedUidGenerator;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Order order, String action, String userId) {
        this.save(order, action, userId, null);
    }
    @Override
    public Long savePre(String orderStr, Map map , String action, String userId, String remark) {
        Order order = JSONObject.parseObject(orderStr,Order.class);
        OrderAction orderAction = new OrderAction();
        orderAction.setActionId(defaultUidGenerator.getUID());
        orderAction.setActionUser(userId);
        orderAction.setLogTime(System.currentTimeMillis());
        orderAction.setOrderId(order.getOrderId());
        orderAction.setOrderStatus(order.getOrderStatus());
        orderAction.setPayStatus(order.getPayStatus());
        orderAction.setShippingStatus(order.getShippingStatus());
        orderAction.setStatusDesc(action);
        orderAction.setActionNote(remark);
        if(map !=null&&map.get("trade_type")!=null){
            orderAction.setTradeType(map.get("trade_type").toString());
        }
        if(map !=null&&map.get("prepay_id")!=null){
            orderAction.setPrepayId(map.get("prepay_id").toString());
        }
        if(map !=null&&map.get("code_url")!=null){
            orderAction.setCodeUrl(map.get("code_url").toString());
        }
        orderActionMapper.insert(orderAction);
        return orderAction.getActionId();
    }

    @Override
    public Long savePre(String orderStr,String action, String userId, String remark) {
        Order order = JSONObject.parseObject(orderStr,Order.class);
        OrderAction orderAction = new OrderAction();
        orderAction.setActionId(defaultUidGenerator.getUID());
        orderAction.setActionUser(userId);
        orderAction.setLogTime(System.currentTimeMillis());
        orderAction.setOrderId(order.getOrderId());
        orderAction.setOrderStatus(order.getOrderStatus());
        orderAction.setPayStatus(order.getPayStatus());
        orderAction.setShippingStatus(order.getShippingStatus());
        orderAction.setStatusDesc(action);
        orderAction.setActionNote(remark);
//        orderActionMapper.insert(orderAction);
        //mycat 获取DataMate会报错，所以用jdbcTemplate直接连接数据库，这样整合seata就没有问题
        String sql = "insert into tp_order_action (action_id, order_id, action_user, trade_type, prepay_id, code_url,order_status, shipping_status, pay_status, action_note, log_time, status_desc) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1,orderAction.getActionId());
                ps.setLong(2,orderAction.getOrderId());
                ps.setString(3,orderAction.getActionUser());
                ps.setString(4,orderAction.getTradeType());
                ps.setString(5,orderAction.getPrepayId());
                ps.setString(6,orderAction.getCodeUrl());
                ps.setInt(7,orderAction.getOrderStatus());
                ps.setInt(8,orderAction.getShippingStatus());
                ps.setInt(9,orderAction.getPayStatus());
                ps.setString(10,orderAction.getActionNote());
                ps.setLong(11,orderAction.getLogTime());
                ps.setString(12,orderAction.getStatusDesc());
            }
        });
        return orderAction.getActionId();
    }


    @Override
    public Long updatePre(Long actionId,Map map ) {
        OrderAction orderAction = orderActionMapper.selectByPrimaryKey(actionId);
        if(map.get("trade_type")!=null){
            orderAction.setTradeType(map.get("trade_type").toString());
        }
        if(map.get("prepay_id")!=null){
            orderAction.setPrepayId(map.get("prepay_id").toString());
        }
        if(map.get("code_url")!=null){
            orderAction.setCodeUrl(map.get("code_url").toString());
        }
        orderActionMapper.updateByPrimaryKey(orderAction);
        return orderAction.getActionId();
    }


    @Override
    public void save(Order order, String action, String userId, String remark) {
        OrderAction orderAction = new OrderAction();
        orderAction.setActionId(defaultUidGenerator.getUID());
        orderAction.setOrderType(order.getOrderType());
        orderAction.setActionUser(userId);
        orderAction.setLogTime(System.currentTimeMillis());
        orderAction.setOrderId(order.getOrderId());
        orderAction.setOrderStatus(order.getOrderStatus());
        orderAction.setPayStatus(order.getPayStatus());
        orderAction.setShippingStatus(order.getShippingStatus());
        orderAction.setStatusDesc(action);
        orderAction.setActionNote(remark);
        orderActionMapper.insert(orderAction);
    }

    @Override
    public OrderAction queryByPrepayId(String prepayId) {
        OrderAction orderAction = new OrderAction();
        orderAction = orderActionMapper.queryByPrepayId(prepayId);
        return orderAction;
    }

    @Override
    public List<OrderAction> queryByOrderId(Long orderId) {
        return orderActionMapper.queryByOrderId(orderId);
    }

    @Override
    public OrderAction queryByActionId(Long actionId) {
        return orderActionMapper.selectByPrimaryKey(actionId);
    }
}
