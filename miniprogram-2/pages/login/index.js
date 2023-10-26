import {request} from "../../request/index.js";
Page({

    /**
     * 页面的初始数据
     */
    data: {
        url: '',     //登录完事后要转向的地址
        isTabBar: 0  //0没有bar，1有bar
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
        let url = options.url.replace("$","?").replace("-","=");
        let isTabBar = options.isTabBar;
        this.setData({
            url: url,
            isTabBar: isTabBar
        })
    },

    /**
     * 微信接口，获取用户信息
     */
    getUserInfo: function(e){
        var userInfo = e.detail.userInfo;
        wx.setStorageSync('avatarUrl', userInfo.avatarUrl);
        var data = {
            name: userInfo.nickName,
            code: userInfo.avatarUrl,
            nickName: userInfo.nickName,
            password: "123456",
            account: 88888
        }
        request({url:"/register",data: data,method:"POST"}).then(res =>{
            if(res.code === '0'){
                wx.showToast({
                    title:'登陆成功',
                    mask: true
                })
                //获取后存储本地数据
                this.setData({
                    isLogin: 1,
                    userInfo: res.data
                });
                // 存到localStorage里
                wx.setStorageSync('user', res.data)
                if(this.data.isTabBar === "0"){
                    wx.navigateTo({
                      url: this.data.url
                    })
                }else{
                    wx.switchTab({
                      url: this.data.url
                    })
                }
            }else{
                wx.showToast({
                    title:'登陆失败',
                    mask: true
                })
            }
        })
    },
    
})