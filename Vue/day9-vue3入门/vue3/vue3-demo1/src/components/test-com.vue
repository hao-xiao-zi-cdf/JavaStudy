<script setup>
import { ref } from 'vue'
const value = ref(1)
const Hello = () => {
  console.log('Hello')
}
// 默认组件的内容是不向外暴露给其他组件的，如果某些属性或方法需要暴露，使用宏暴露
defineExpose({
  value,
  Hello
})
</script>

<template>
<div class="test">我是子组件</div>
</template>

<style scoped>
.test {
  background-color: #9d2c40;
  width: 305px;
  height:  200px;
}
</style>
