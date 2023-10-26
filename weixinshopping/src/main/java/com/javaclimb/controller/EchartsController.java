package com.javaclimb.controller;

import cn.hutool.json.JSONObject;
import com.javaclimb.common.Result;
import com.javaclimb.service.CommentInfoService;
import com.javaclimb.service.OrderInfoService;
import com.javaclimb.service.UserInfoService;
import com.javaclimb.vo.EchartsData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/*
* 后台统计
* */
@RestController
@RequestMapping("/echarts")
public class EchartsController {
    @Resource
    private UserInfoService userInfoService;

    @Resource
    private CommentInfoService commentInfoService;

    @Resource
    private OrderInfoService orderInfoService;

    /*
    * 统计各种总数
    * */
    @GetMapping("getTotal")
    public Result<Map<String,Object>> getTotal(){
        Map<String,Object> map = new HashMap<>();
        // 获取用户总数
        map.put("totalUser",userInfoService.count());
        // 获取评论总数
        map.put("totalComment",commentInfoService.count());
        // 获取总交易额
        map.put("totalPrice",orderInfoService.totalPrice());
        // 获取总销量
        map.put("totalShopping",orderInfoService.totalShopping());
        return Result.success(map);
    }

    // 分类总销售额
    @GetMapping("/get/price")
    public Result<List<EchartsData>> getPriceEchartsData(){
        List<EchartsData> list = new ArrayList<>();
        List<Map<String,Object>> typePriceList = orderInfoService.getTypePrice();
        Map<String,Double> typeMap = new HashMap<>();
        for(Map<String,Object> map : typePriceList){
            typeMap.put((String) map.get("name"),(Double) map.get("price"));
        }

        getPieData("分类总销售额",list,typeMap);
        getBarData("分类总销售额",list,typeMap);
        return Result.success(list);
    }

    // 分类总销量
    @GetMapping("/get/shopping")
    public Result<List<EchartsData>> getShoppingEchartsData(){
        List<EchartsData> list = new ArrayList<>();
        List<Map<String,Object>> typeCountList = orderInfoService.getTypeCount();
        Map<String,Double> typeMap = new HashMap<>();
        for(Map<String,Object> map : typeCountList){
            typeMap.put((String) map.get("name"),((Integer)map.get("count")).doubleValue());
        }

        getPieData("分类总销量",list,typeMap);
        getBarData("分类总销量",list,typeMap);
        return Result.success(list);
    }

    // 封装饼图
    private void getPieData(String name,List pieList,Map<String,Double> dataMap){
        EchartsData pieData = new EchartsData();
        Map<String,String> titleMap = new HashMap<>();
        titleMap.put("text",name);
        pieData.setTitle(titleMap);

        Map<String,Object> tooltipMap = new HashMap<>();
        tooltipMap.put("show",true);
        pieData.setTooltip(tooltipMap);

        Map<String,String> legendMap = new HashMap<>();
        legendMap.put("orient","vertical");
        pieData.setLegend(legendMap);

        EchartsData.Series series = new EchartsData.Series();
        series.setName(name);
        series.setType("pie");
        series.setRadius("50%");
        List<Object> objects = new ArrayList<>();
        for (String key:dataMap.keySet()){
            objects.add(new JSONObject().putOpt("name",key).putOpt("value",dataMap.get(key)));
        }
        series.setData(objects);

        pieData.setSeries(Collections.singletonList(series));
        pieList.add(pieData);
    }

    // 封装柱状图
    private void getBarData(String name,List pieList,Map<String,Double> dataMap){
        EchartsData barData = new EchartsData();
        Map<String,String> titleMap = new HashMap<>();
        titleMap.put("text",name);
        barData.setTitle(titleMap);

        Map<String,Object> tooltipMap = new HashMap<>();
        tooltipMap.put("show",true);
        barData.setTooltip(tooltipMap);

        EchartsData.Series series = new EchartsData.Series();
        series.setName(name);
        series.setType("bar");
        List<Object> objects = new ArrayList<>();
        List<Object> xAxisObjs = new ArrayList<>();
        for (String key:dataMap.keySet()){
            objects.add(dataMap.get(key));
            xAxisObjs.add(key);

        }
        series.setData(objects);
        Map<String,Object> xAxisMap = new HashMap<>();
        xAxisMap.put("data",xAxisObjs);
        barData.setxAxis(xAxisMap);
        barData.setyAxis(new HashMap());

        barData.setSeries(Collections.singletonList(series));
        pieList.add(barData);
    }


}
