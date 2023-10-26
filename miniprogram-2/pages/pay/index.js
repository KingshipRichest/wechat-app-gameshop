import {request} from "../../request/index.js";
Page({

    /**
     * 页面的初始数据
     */
    data: {
        recharge: "",     //充值金额
        price: 0          //余额
    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow() {
        let user = wx.getStorageSync('user');
        if(!user){
            wx.showToast({
              title: '请先登录',
              icon:'none'
            })
        }else{request({url:"/userInfo/"+user.id}).then(res=>{
            if(res.code==="0"){
                this.setData({
                    price:res.data.account
                })
            }
        })
    }
    },

    //绑定输入的金额值
    onPrice(e){
        this.setData({
            recharge: e.detail.value
        })
    },

    //充值
    recharge(e){
        let user = wx.getStorageSync('user')
        let data = {id:user.id,account:parseFloat(this.data.price)+parseFloat(this.data.recharge)};
        request({url:"/userInfo",data:data,method:"PUT"}).then(res=>{
            if(res.code==="0"){
                wx.showToast({
                  title: '充值成功',
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