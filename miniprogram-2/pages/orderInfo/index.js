import {request} from "../../request/index.js";
import {config} from "../../request/config.js";
Page({

    /**
     * 页面的初始数据
     */
    data: {
        state:"",     // 订单状态
        dataList:[]   // 订单列表
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
        const state = options.state;
        this.setData({
            state: state
        })
        this.getOrderData(state);
    },
    getOrderData(state){
        let user = wx.getStorageSync('user');
        let url = "/orderInfo/page/front?pageNum=1&pageSize=100&userId="+user.id;
        if(state!="all"){
            url = url + "&state="+state;
        }
        request({url: url}).then(res =>{
            if(res.code === '0'){
                let list = res.data.list;
                list.forEach((item,index) =>{
                    let goodsInfo = item.goodsList[0];
                    let imgSrc = "../../imgs/default.png";
                    if(goodsInfo.fields){
                        let fields = JSON.parse(goodsInfo.fields);
                        if(fields.length){
                            imgSrc = config.baseFileUrl+fields[0];
                        }
                    }
                        item.url = imgSrc;
                        item.count = item.goodsList.length;
                        item.description = goodsInfo.description;
                    
                })
                this.setData({
                    dataList:list
                })
            }
        })
        
    },
// 付款或取消
    payGoods(e){
        let id = e.currentTarget.dataset.id;
        let state = e.currentTarget.dataset.state;
        request({url:"/orderInfo/state/"+id+"/"+state,method:"POST"}).then(res =>{
            if(res.code === "0"){
                wx.showToast({
                  title: '操作成功',
                })
                this.getOrderData(this.data.state);
            }else{
                wx.showToast({
                  title: res.msg,
                  icon:"none"
                })
            }
        })
    },
    
    // 删除订单
    deleteOrder(e){
        let id = e.currentTarget.dataset.id;
        // 弹窗提示
        wx.showModal({
            content: '您是否要删除该订单',
            success: (res) =>{
                if(res.confirm){
                    request({url:'/orderInfo/'+id,method:'DELETE'}).then(res =>{
                        if(res.code === '0'){
                            wx.showToast({
                                title: '删除成功',
                              })
                              wx.switchTab({
                                url: '/pages/orderInfo/index',
                              })
                        }else{
                            wx.showToast({
                              title: res.msg,
                              icon:'error'
                            })
                        }
                    })
                }
            }
          })
    }
})