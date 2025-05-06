<script setup>
import {inject} from "vue";
// 获取顶层向下传递的数据
const data1 = inject('data1')
const data2 = inject('data2')
const func = inject('func')
</script>

<template>
  <h3>我是底层组件</h3>
  {{ data1 }}   -----   {{ data2 }}
  <button @click="func(2)">点击修改count数值</button>
</template>

<style scoped>

</style>
