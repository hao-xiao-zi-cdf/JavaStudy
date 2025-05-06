<script setup>
import SonCom from '@/components/son-com.vue'
import { ref } from 'vue'
const num = ref(80)
const getNum = () => {
  num.value += 10
}
const changeNum = (value) => {
  num.value -= value
}
</script>

<template>
  <div class="parent">
    我是父组件
<!--    父组件中的组件标签以添加属性的方式给子组件传值-->
    <son-com car="宝马7系" :num="num" @changeNum="changeNum"></son-com>
    <button @click="getNum">涨价10W</button>
  </div>
</template>

<style scoped>
.parent {
  background-color: #3f8932;
  width: 400px;
  height: 400px;
}
</style>
