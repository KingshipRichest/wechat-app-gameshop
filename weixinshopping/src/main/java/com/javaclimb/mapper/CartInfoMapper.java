package com.javaclimb.mapper;

import com.javaclimb.entity.CartInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CartInfoMapper extends Mapper<CartInfo> {
    // 根据用户id获取购物车列表
    List<CartInfo> findCartByUserId(Long userId);

    // 删除某用户购物车里的某个商品
    @Delete("delete from cart_info where userId=#{userId} and goodsId=#{goodsId}")
    int deleteGoods(@Param("userId")Long userId,@Param("goodsId")Long goodsId);

    // 根据用户清空他的购物车
    @Delete("delete from cart_info where userId=#{userId}")
    int deleteByUserId(@Param("userId")Long userId);

    // 查询所有人的购物车列表
    List<CartInfo> findAll();
}