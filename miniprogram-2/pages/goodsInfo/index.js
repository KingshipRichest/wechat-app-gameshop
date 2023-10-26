import {request} from "../../request/index.js";
import {config} from "../../request/config.js";
Page({

    /**
     * 页面的初始数据
     */
    data: {
        goodsId: 0,       //商品主键id
        obj: {},          //当前商品
        swiperList: [],   //当前商品的图片数组
        commentList:[]    //评价列表

    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        const id = options.id;
        this.setData({
            goodsId: id
        })
        // 获取当前商品
        this.getDetail(id);
        this.getComment(id);
    },
    // 获取当前商品
    getDetail(id){
        request({url:'/goodsInfo/'+id}).then(res =>{
            if(res.code === '0'){
                let obj = res.data;
                let swiperList = [];
                if(obj.fields){
                    let list = JSON.parse(obj.fields);
                    list.forEach(item => {
                        let imgObj = {};
                        imgObj.fields = item;
                        imgObj.imgSrc = config.baseFileUrl+item;
                        swiperList.push(imgObj);
                    })
                }
                if(swiperList.length === 0){
                    swiperList.push({imgSrc:"../../imgs/default.png"});
                    swiperList.push({imgSrc:"../../imgs/default.png"});
                }
                this.setData({
                    obj,
                    swiperList
                })
                
            }else{
                wx.showToast({
                  title: res.msg,
                  icon: 'none'
                })
            }
        })
    },
    
// 获取评论列表
    getComment(goodsid){
        request({url:"/commentInfo/all/"+goodsid}).then(res =>{
            if(res.code === "0"){
                this.setData({
                    commentList: res.data
                })
            }else{
                wx.showToast({
                  title: res.msg,
                  icon:'error'
                })
            }
        })
    },

    //放入购物车
    handleCartAdd(){
        let user = wx.getStorageSync('user');
        if(!user){
            wx.navigateTo({
              url: '/pages/login/index?isTabBar=0&url=/pages/goodsInfo/index$id-'+this.data.goodsId
            })
            return;
        }
        let data = {userid: user.id,level: user.level,goodsid: this.data.goodsId,count: 1};
        request({url:"/cartInfo",data:data,method:"POST"}).then(res => {
            if(res.code==="0"){
                wx.showToast({
                  title: '加入购物车成功',
                })
            }else{
                wx.showToast({
                  title: res.msg,
                  icon: "error"
                })
            }
        })
    }
})