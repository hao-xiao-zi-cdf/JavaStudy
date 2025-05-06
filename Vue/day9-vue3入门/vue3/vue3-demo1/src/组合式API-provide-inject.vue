<script setup>
import CentreCom from "@/components/centre-com.vue";
import {provide, ref} from "vue";
const count = ref(100)
// 传递普通数据
provide('data1','Hello Vue3')
// 传递响应式数据
provide('data2',count)
// 跨层级传递可修改数值的函数
provide('func',(num) => {
  count.value -= num
})

const changeCount = () => {
  count.value++
}
</script>

<template>
  <h1>我是顶层组件</h1>
  <button @click="changeCount">修改count数值</button>
  <CentreCom></CentreCom>
</template>

<style scoped>

</style>
