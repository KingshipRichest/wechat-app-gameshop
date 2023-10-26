package com.javaclimb.entity;

import javax.persistence.*;

/**
 * Database Table Remarks:
 *   购物车信息表

 */
@Table(name = "cart_info")
public class CartInfo {
    /**
     * Database Column Remarks:
     *   主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *   所属商品
     */
    @Column(name = "goodsId")
    private Long goodsid;

    /**
     * Database Column Remarks:
     *   数量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart_info.count
     *
     * @mbg.generated
     */
    @Column(name = "count")
    private Integer count;

    /**
     * Database Column Remarks:
     *   所属用户
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart_info.userId
     *
     * @mbg.generated
     */
    @Column(name = "userId")
    private Long userid;

    /**
     * Database Column Remarks:
     *   用户等级
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart_info.level
     *
     * @mbg.generated
     */
    @Column(name = "level")
    private Integer level;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart_info.createTime
     *
     * @mbg.generated
     */
    @Column(name = "createTime")
    private String createtime;

    // 所属用户名
    @Transient
    private String userName;

    // 商品名称
    @Transient
    private String goodsName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart_info.id
     *
     * @return the value of cart_info.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart_info.id
     *
     * @param id the value for cart_info.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart_info.goodsId
     *
     * @return the value of cart_info.goodsId
     *
     * @mbg.generated
     */
    public Long getGoodsid() {
        return goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart_info.goodsId
     *
     * @param goodsid the value for cart_info.goodsId
     *
     * @mbg.generated
     */
    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart_info.count
     *
     * @return the value of cart_info.count
     *
     * @mbg.generated
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart_info.count
     *
     * @param count the value for cart_info.count
     *
     * @mbg.generated
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart_info.userId
     *
     * @return the value of cart_info.userId
     *
     * @mbg.generated
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart_info.userId
     *
     * @param userid the value for cart_info.userId
     *
     * @mbg.generated
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart_info.level
     *
     * @return the value of cart_info.level
     *
     * @mbg.generated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart_info.level
     *
     * @param level the value for cart_info.level
     *
     * @mbg.generated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart_info.createTime
     *
     * @return the value of cart_info.createTime
     *
     * @mbg.generated
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart_info.createTime
     *
     * @param createtime the value for cart_info.createTime
     *
     * @mbg.generated
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}