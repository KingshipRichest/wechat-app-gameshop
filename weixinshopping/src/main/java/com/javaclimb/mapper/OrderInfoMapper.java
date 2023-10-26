package com.javaclimb.mapper;

import com.javaclimb.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderInfoMapper extends Mapper<OrderInfo> {

    // 根据订单id查询一条订单数据
    @Select("select * from order_info where orderId = #{orderId}")
    List<OrderInfo> findByOrderId(@Param("orderId") String orderId);

    // 根据查询终端用户id和状态查询订单列表
    List<OrderInfo> findByEndUserId(@Param("userId")Long userId,@Param("state")String state);

    // 根据主键查询
    @Select("select * from order_info where id = #{id}")
    OrderInfo findById(@Param("id") Long id);

    // 跟新订单状态
    @Update("update order_info set state=#{state} where id = #{id}")
    void updateState(@Param("id") Long id,@Param("state") String state);

    // 删除订单
    void deleteById(Long id);

    // 总交易额
    @Select("select sum(totalPrice) from order_info where state = '完成'")
    Double totalPrice();

    // 分类总销售额
    @Select("select sum(a.count*b.price) as `price`,c.`name` from order_goods_rel as a\n" +
            "left join goods_info as b on a.goodsId=b.id\n" +
            "left join type_info as c on c.id=b.typeId\n" +
            "GROUP BY b.typeId")
    List<Map<String,Object>> getTypePrice();

    // 分类总销量
    @Select("select a.count as `count`,c.`name` from order_goods_rel as a\n" +
            "left join goods_info as b on a.goodsId=b.id\n" +
            "left join type_info as c on c.id=b.typeId\n" +
            "GROUP BY b.typeId")
    List<Map<String,Object>> getTypeCount();
}