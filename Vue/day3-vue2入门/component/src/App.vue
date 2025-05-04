<template>
  <div class="app">
<!--    快捷链接:XtxShortCut-->
    <XtxShortCut></XtxShortCut>
<!--    顶部导航:XtxHeaderNav-->
    <XtxHeaderNav></XtxHeaderNav>
<!--    轮播区域:XtxBanner-->
    <XtxBanner></XtxBanner>
<!--    新鲜好物:XtxNewGoods-->
    <XtxNewGoods></XtxNewGoods>
<!--    热门品牌:XtxHotBrand-->
    <XtxHotBrand></XtxHotBrand>
<!--    最新专题:XtxTopic-->
    <XtxTopic></XtxTopic>
<!--    版权底部:XtxFooter-->
    <XtxFooter></XtxFooter>
  </div>
</template>

<script>
//导入组件
import XtxBanner from "./components/XtxBanner.vue";
import XtxNewGoods from "./components/XtxNewGoods.vue";
import XtxHotBrand from "./components/XtxHotBrand.vue";
import XtxFooter from "./components/XtxFooter.vue";
import XtxTopic from "./components/XtxTopic.vue";
import XtxShortCut from "./components/XtxShortCut.vue";
import XtxHeaderNav from "./components/XtxHeaderNav.vue";

export default{
  //注册组件
  components:{
    XtxShortCut,
    XtxHeaderNav,
    XtxBanner,
    XtxNewGoods,
    XtxHotBrand,
    XtxTopic,
    XtxFooter,
  }
}
</script>

<style>

</style>