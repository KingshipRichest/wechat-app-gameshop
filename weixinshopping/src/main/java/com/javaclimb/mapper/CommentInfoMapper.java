package com.javaclimb.mapper;

import com.javaclimb.entity.CommentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CommentInfoMapper extends Mapper<CommentInfo> {

    // 根据内容模糊查询评价列表
    List<CommentInfo> findByContent(@Param("name") String name);

    // 根据商品id获取评论列表
    @Select("select a.*,u.name as userName from comment_info as a left join user_info as u on a.userId=u.id where goodsId = #{goodsid}")
    List<CommentInfo> findByGoodsid(@Param("goodsid") Long goodsid);

    //评论总数
    @Select("select count(*) from comment_info")
    Integer count();
}