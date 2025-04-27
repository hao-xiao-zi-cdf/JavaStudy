<template>
  <div id="app">
    我是父组件
<!--    2.通过给组件标签的属性，动态传输数据-->
<!--    b.父组件监听消息通知-->
    <SonComponent :title="myTitle" @changeTitle="handleChangeTitle"></SonComponent>
  </div>
</template>
<script>
//组件通信：即组件与组件之间的数据传递
//组件关系类型和通信解决方案：父子类型（父传子props,子传父$emit），非父子类型
import SonComponent from "./components/SonComponent.vue";

export default {
  components: {
    SonComponent,
  },
  data(){
    return {
      // 1.准备要通信的数据
      myTitle : "Hello Vue"
    }
  },
  methods : {
    handleChangeTitle(newTitle){
      this.myTitle = newTitle;
    }
  }
}

</script>

<style scoped>
div {
  border: 1px solid lightgreen;
  margin : 30px;
  background-color: #e6e6e6;
}
</style>