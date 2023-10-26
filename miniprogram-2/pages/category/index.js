import {request} from "../../request/index.js";
import {config} from "../../request/config.js";
Page({
  data: {
    defaultImageUrl: '../../imgs/default.png',
    goodsInfoCarouselList: [],     // 轮播图列表
    leftMenuList: [],              // 左侧类型列表---菜单
    rightContent: [],              // 右侧的商品数据
    currentIndex: 1                // 被点击的左侧的菜单
  },
  onLoad: function(){
    this.getGoodsInfoCarouselList();
    this.getLeftMenuList();
    this.getGoodsList(1);
  },
  // 获取轮播图
  getGoodsInfoCarouselList(){
    request({url: '/goodsInfo/page/all?pageNum=1&pageSize=3'}).then(res =>{
      if(res.code === '0'){
        let goodsInfoCarouselList = res.data.list;
        if(!goodsInfoCarouselList || goodsInfoCarouselList.length === 0){
          goodsInfoCarouselList.push({"name":"名称О1","url": this.data.defaultImageUrl});
          goodsInfoCarouselList.push({"name":"名称О2","url": this.data.defaultImageUrl});
          goodsInfoCarouselList.push({"name":"名称О3","url": this.data.defaultImageUrl});
        }else{
          if(goodsInfoCarouselList.length>4){
            goodsInfoCarouselList = goodsInfoCarouselList.slice(0,4);
          }
          goodsInfoCarouselList.forEach(item =>{
            if(!item.fields||item.fields==='[]'){
              item.url = this.data.defaultImageUrl;
            }else{
              let fileArr = JSON.parse(item.fields);
              item.url = config.baseFileUrl+fileArr[0];
            }
          });
        }
        this.setData({
          goodsInfoCarouselList
        })
      }else{
        wx.showToast({
          title: res.msg,
          icon: 'none'
        })
      }
    })
  },

  // 获取左侧菜单数据
  getLeftMenuList(){
    request({url:'/typeInfo/page/all'}).then(res=>{
      if(res.code === '0'){
        this.setData({
          leftMenuList:res.data.list
        })
      }
    })
  },

  //根据类型获取商品列表
  getGoodsList(typeId){
    request({url:'/goodsInfo/findByType/'+typeId}).then(res=>{
      if(res.code === '0'){
          let list = res.data;
          list.forEach(item =>{
            if(!item.fields||item.fields==='[]'){
              item.url = this.data.defaultImageUrl;
            }else{
              let fileArr = JSON.parse(item.fields);
              item.url = config.baseFileUrl+fileArr[0];
            }
          });
          this.setData({
            rightContent:list
          })
      }
    })
  },

  // 左侧菜单的点击事件
  handleItemTap(e){
    let {id} = e.currentTarget.dataset;
    let rightContent = this.getGoodsList(id);
    this.setData({
      currentIndex: id,
      rightContent: rightContent
    })
  }
});
