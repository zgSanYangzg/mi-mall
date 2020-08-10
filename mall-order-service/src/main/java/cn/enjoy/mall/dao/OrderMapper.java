package cn.enjoy.mall.dao;

import cn.enjoy.mall.model.Order;
import cn.enjoy.mall.vo.OrderVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbggenerated Wed Feb 28 17:18:49 CST 2018
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbggenerated Wed Feb 28 17:18:49 CST 2018
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbggenerated Wed Feb 28 17:18:49 CST 2018
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbggenerated Wed Feb 28 17:18:49 CST 2018
     */
    Order selectByPrimaryKey(Long orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbggenerated Wed Feb 28 17:18:49 CST 2018
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbggenerated Wed Feb 28 17:18:49 CST 2018
     */
    int updateByPrimaryKey(Order record);

    List<Order> queryByPage(@Param("type") Integer type,
                            @Param("keywords") String keywords, PageBounds pageBounds,
                            @Param("userId") String userId);

    List<Order> queryByPage(Map map);

    Integer selectOrderNum(@Param("type") Integer type,
                           @Param("userId") String userId);

    List<Order> selectExpiredOrder(long exipredTimeInterval);

    OrderVo selectOrderById(Long orderId);

    Order selectOrderBySn(String orderSn);
}