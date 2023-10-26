package com.javaclimb.mapper;

import com.javaclimb.entity.OrderGoodsRel;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface OrderGoodsRelMapper extends Mapper<OrderGoodsRel> {
    // 根据订单id获取商品列表
    List<OrderGoodsRel> findByOrderid(Long orderId);

    // 根据订单id删除相联关系
    void deleteByOrderId(Long orderId);

    // 统计总销量
    @Select("select sum(count) from order_goods_rel")
    Integer totalShopping();
}