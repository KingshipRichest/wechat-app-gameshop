package com.javaclimb.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.common.Common;
import com.javaclimb.entity.CartInfo;
import com.javaclimb.entity.GoodsInfo;
import com.javaclimb.entity.UserInfo;
import com.javaclimb.exception.CustomException;
import com.javaclimb.mapper.CartInfoMapper;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
* 购物车服务
* */
@Service
public class CartInfoService {

    @Resource
    private CartInfoMapper cartInfoMapper;

    @Resource
    private GoodsInfoService goodsInfoService;

    // 加入购物车
    public CartInfo add(CartInfo detailInfo){
        Long userId = detailInfo.getUserid();
        Long goodsId = detailInfo.getGoodsid();
        // 先查询购物车里有没有该商品，有就更新数量，没有就添加
        Example example = new Example(CartInfo.class);
        example.createCriteria().andEqualTo("userid",userId).andEqualTo("goodsid",goodsId);
        List<CartInfo> infos = cartInfoMapper.selectByExample(example);
        if (CollectionUtil.isEmpty(infos)){
            // 新增
            detailInfo.setCreatetime(DateUtil.formatDateTime(new Date()));
            cartInfoMapper.insertSelective(detailInfo);
        }else {
            // 更新
            CartInfo cartInfo = infos.get(0);
            cartInfo.setCount(cartInfo.getCount() + detailInfo.getCount());
            cartInfoMapper.updateByPrimaryKeySelective(cartInfo);
        }
        return detailInfo;
    }

    // 根据用户id获取购物车里的商品列表（带购物数量）
    public List<GoodsInfo> findAll(Long userId){
        List<CartInfo> cartInfoList = cartInfoMapper.findCartByUserId(userId);
        List<GoodsInfo> goodsList = new ArrayList<>();
        for (CartInfo cartInfo:cartInfoList){
            long goodsId = cartInfo.getGoodsid();
            GoodsInfo goodsInfo = goodsInfoService.findById(goodsId);
            if (goodsInfo != null){
                // 这里的count是用户加入购物车的商品的数量， 不是商品的库存
                goodsInfo.setCount(cartInfo.getCount());
                // 这里id是购物商品里的关系id
                goodsInfo.setId(cartInfo.getGoodsid());
                goodsList.add(goodsInfo);
            }
        }
        return goodsList;
    }

    // 删除某用户购物车里的某个商品

    public void deleteGoods(Long userId,Long goodsId){
        cartInfoMapper.deleteGoods(userId, goodsId);
    }

    // 清空购物车
    public void empty(Long userId) {
        cartInfoMapper.deleteByUserId(userId);
    }

    //翻页查询购物车列表
    public PageInfo<CartInfo> findPageDetails(Integer pageNum, Integer pageSize, HttpServletRequest request){
        UserInfo user = (UserInfo) request.getSession().getAttribute(Common.USER_INFO);
        if (user==null){
            throw new CustomException("1001","session已失效，请重新登录");
        }
        Integer level = user.getLevel();
        PageHelper.startPage(pageNum,pageSize);
        List<CartInfo> list;
        if (level==1){
            list = cartInfoMapper.findAll();
        }else {
            list = cartInfoMapper.findCartByUserId(user.getId());
        }
        return PageInfo.of(list);
    }

    // 根据购物车id删除购物车
    public void delete(Long id) {
        cartInfoMapper.deleteByPrimaryKey(id);
    }
}
