package cn.enjoy.mall.dao;

import cn.enjoy.mall.model.SpecGoodsImage;

import java.util.List;

public interface SpecGoodsImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_spec_goods_image
     *
     * @mbggenerated Thu Feb 08 11:12:37 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_spec_goods_image
     *
     * @mbggenerated Thu Feb 08 11:12:37 CST 2018
     */
    int insert(SpecGoodsImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_spec_goods_image
     *
     * @mbggenerated Thu Feb 08 11:12:37 CST 2018
     */
    int insertSelective(SpecGoodsImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_spec_goods_image
     *
     * @mbggenerated Thu Feb 08 11:12:37 CST 2018
     */
    SpecGoodsImage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_spec_goods_image
     *
     * @mbggenerated Thu Feb 08 11:12:37 CST 2018
     */
    int updateByPrimaryKeySelective(SpecGoodsImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_spec_goods_image
     *
     * @mbggenerated Thu Feb 08 11:12:37 CST 2018
     */
    int updateByPrimaryKey(SpecGoodsImage record);

    List<SpecGoodsImage> selectBySpecGoodsId(Integer specGoodsId);

    int deleteByGoodsId(Integer goodsId);

    int insertBatch(List<SpecGoodsImage> list);
}