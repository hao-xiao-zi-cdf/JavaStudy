<script setup>
import {onMounted, ref} from 'vue'
// ref可以用来获取页面中dom元素或获取组件
import TestCom from "@/components/test-com.vue";
// 使用ref函数创建ref对象
const inp = ref(null)
const com = ref(null)
const getFocus = () => {
  console.log(inp.value)
  inp.value.focus()
}
// onMounted(() => {
//   console.log(inp.value)
// })
const getCom = () => {
  console.log(com.value)
  console.log(com.value.value)
  com.value.Hello()
}
</script>

<template>
  <div class="parent">
<!--    在需要获取dom元素标签中添加ref属性-->
    <input type="text" ref="inp">
    <button @click="getFocus">点击按钮输入框聚焦</button>
<!--    使用ref获取组件对象，可用于获取该组件的属性和方法-->
    <test-com ref="com"></test-com>
    <button @click="getCom">点击按钮获取组件对象</button>
  </div>
</template>

<style scoped>
.parent {
  background-color: #3f8932;
  width: 400px;
  height: 400px;
}
</style>
