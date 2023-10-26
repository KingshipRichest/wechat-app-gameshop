package com.javaclimb.mapper;

import com.javaclimb.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {
    //根据用户名查询
    List<UserInfo> findByName(@Param("name") String name);

    //用户唯一性判断
    int checkRepeat(@Param("column")String column,@Param("value")String value);

    //用户总数
    @Select("select count(*) from user_info")
    Integer count();
}