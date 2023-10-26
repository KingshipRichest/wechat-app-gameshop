package com.javaclimb.service;


import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.entity.GoodsInfo;
import com.javaclimb.mapper.GoodsInfoMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
* 商品相关的service
* */
@Service
public class GoodsInfoService {

    @Resource
    private GoodsInfoMapper goodsInfoMapper;

    /*
    * 分页查询商品列表
    * */
    public PageInfo<GoodsInfo> findPage(Integer pageNum,Integer pageSize,String name){
        PageHelper.startPage(pageNum,pageSize);
        List<GoodsInfo> list = goodsInfoMapper.findByName(name,null);
        return PageInfo.of(list);

    }
    /*
    * 新增商品
    * */
    public GoodsInfo add(GoodsInfo goodsInfo){
        convertFileListToFields(goodsInfo);
        goodsInfoMapper.insertSelective(goodsInfo);
        return goodsInfo;
    }

    //修改商品
    public void update(GoodsInfo goodsInfo){
        convertFileListToFields(goodsInfo);
        goodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);
    }

    //页面传来的上传文件列表转换成以逗号隔开的id列表
    private void convertFileListToFields(GoodsInfo goodsInfo){
        List<Long> fileList = goodsInfo.getFileList();
        if (!CollectionUtil.isEmpty(fileList)){
            goodsInfo.setFields(fileList.toString());
        }
    }

    // 根据id删除商品
    public void delete(Long id){
        goodsInfoMapper.deleteByPrimaryKey(id);
    }
    /*
    * 根据id获取商品
    * */
    public GoodsInfo findById(Long id){
        List<GoodsInfo> list = goodsInfoMapper.findByName(null,id);
        if(list==null||list.size()==0){
            return null;
        }
        return list.get(0);
    }

    // 查询推荐商品
    public PageInfo<GoodsInfo> findRecommendGoods(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsInfo> list = goodsInfoMapper.findRecommendGoods();
        return PageInfo.of(list);
    }

    // 查询热卖商品
    public PageInfo<GoodsInfo> findHotSalesGoods(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsInfo> list = goodsInfoMapper.findHotSalesGoods();
        return PageInfo.of(list);
    }

    // 根据类型查询商品列表
    public List<GoodsInfo> findByType(Integer typeId){
        return goodsInfoMapper.findByType(typeId);
    }


}
