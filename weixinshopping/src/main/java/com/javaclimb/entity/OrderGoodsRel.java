package com.javaclimb.entity;

import javax.persistence.*;

/**
 * Database Table Remarks:
 *   订单商品关系映射表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table order_goods_rel
 */
@Table(name = "order_goods_rel")
public class OrderGoodsRel {
    /**
     *   主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *   所属订单id
     *
     */
    @Column(name = "orderId")
    private Long orderid;

    /**

     *   所属商品id

     */
    @Column(name = "goodsId")
    private Long goodsid;

    /**
     * Database Column Remarks:
     *   商品数量

     */
    @Column(name = "count")
    private Integer count;

    /**
     *
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods_rel.id
     *
     * @param id the value for order_goods_rel.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods_rel.orderId
     *
     * @return the value of order_goods_rel.orderId
     *
     * @mbg.generated
     */
    public Long getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods_rel.orderId
     *
     * @param orderid the value for order_goods_rel.orderId
     *
     * @mbg.generated
     */
    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods_rel.goodsId
     *
     * @return the value of order_goods_rel.goodsId
     *
     * @mbg.generated
     */
    public Long getGoodsid() {
        return goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods_rel.goodsId
     *
     * @param goodsid the value for order_goods_rel.goodsId
     *
     * @mbg.generated
     */
    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods_rel.count
     *
     * @return the value of order_goods_rel.count
     *
     * @mbg.generated
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods_rel.count
     *
     * @param count the value for order_goods_rel.count
     *
     * @mbg.generated
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}