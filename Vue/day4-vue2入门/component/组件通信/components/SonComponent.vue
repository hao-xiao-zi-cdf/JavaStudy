<template>
  <div>
    <span>我是子组件</span>
<!--    4.使用值-->
    title：{{title}}
    <button @click="change">点击修改title值</button>
  </div>
</template>

<script>
  export default {
    //3.通过props来接收父组件传输的值
    props : ['title'],
    methods : {
      change(){
        // a.通过this.$emit方法向父组件发送消息通知(绑定事件，要修改的值)
        this.$emit("changeTitle",'Hello World');
      }
    }
  }
</script>

<style scoped>
</style>