<!--结构部分-->
<template>
  <div class="App">
    <!--    头部组件-->
    <WebHead></WebHead>
    <!--    内容组件-->
    <WebBody></WebBody>
    <!--    底部组件-->
    <WebFoot></WebFoot>
  </div>
</template>

<!--行为部分-->
<script>
//导入局部组件
import WebHead from './components/WebHead.vue'
import WebBody from './components/WebBody.vue'
import WebFoot from './components/WebFoot.vue'

export default {
  //注册局部组件
  components:{
    //组件名称：组件对象
    WebHead: WebHead,
    WebBody: WebBody,
    WebFoot: WebFoot,
  }
}
</script>

<!--样式部分-->
<style>
.App {
  width: 400px;
  height: 400px;
  background-color: #965a5a;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}
</style>