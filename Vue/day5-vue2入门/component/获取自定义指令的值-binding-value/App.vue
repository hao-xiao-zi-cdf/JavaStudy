<template>
  <div>
    <h1 v-color="color1">指令的值1测试</h1>
    <h1 v-color="color2">指令的值2测试</h1>
  </div>
</template>

<script>
export default {
  data () {
    return {
      color1: 'red',
      color2: 'orange'
    }
  },
  directives : {
    color : {
      // inserted值指令生命周期中的钩子函数，元素被插入页面时被调用
      inserted(el){
        el.style.color = "green";
      },
      // 指令值修改的时候，该函数会被调用，binding.value用于获取修改后的值
      updated(el,binding){
        el.style.color = binding.value;
      }
    }
  }
}
</script>

<style>

</style>