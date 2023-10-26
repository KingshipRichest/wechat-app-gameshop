package com.javaclimb.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.entity.TypeInfo;
import com.javaclimb.mapper.TypeInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/*
* 商品类别相关的service
* */
@Service
public class TypeInfoService {

    @Resource
    private TypeInfoMapper typeInfoMapper;

    /*
    * 分页查询商品类别列表
    * */
    public PageInfo<TypeInfo> findPage(Integer pageNum,Integer pageSize,String name){
        PageHelper.startPage(pageNum,pageSize);
        List<TypeInfo> list = typeInfoMapper.findByName(name);
        return PageInfo.of(list);

    }
    /*
    * 新增商品类别
    * */
    public TypeInfo add(TypeInfo typeInfo){
        typeInfoMapper.insertSelective(typeInfo);
        return typeInfo;
    }

    //修改商品类别
    public void update(TypeInfo typeInfo){
        typeInfoMapper.updateByPrimaryKeySelective(typeInfo);
    }

    // 根据id删除商品类别
    public void delete(Long id){
        typeInfoMapper.deleteByPrimaryKey(id);
    }
    /*
    * 根据id获取商品类别
    * */
    public TypeInfo findById(Long id){
        return typeInfoMapper.selectByPrimaryKey(id);
    }

}
