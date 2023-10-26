import {request} from "../../request/index.js";
Page({

    /**
     * 页面的初始数据
     */
    data: {
        goodsId:0,
        content: ""     //评价内容
    },

    /**
     * 加载
     */
    onLoad:function(options) {
        this.setData({
            goodsId: options.goodsId
        })
    },

    //输入评价内容
    onComment(e){
        this.setData({
            content: e.detail.value
        })
    },

    //提交评价
    comment(e){
        let user = wx.getStorageSync('user')
        let data = {userid:user.id,content:this.data.content, goodsid:this.data.goodsId,level:3};
        request({url:"/commentInfo",data:data,method:"POST"}).then(res=>{
            if(res.code === "0"){
                wx.showToast({
                  title: '评价成功',
                })
                wx.switchTab({
                  url: '/pages/user/index',
                })
            }else{
                wx.showToast({
                  title: res.msg,
                  icon:'none'
                })
            }
        })
    }
})