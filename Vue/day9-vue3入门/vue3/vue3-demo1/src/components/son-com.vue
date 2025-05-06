<script setup>
// 由于使用的setup语法糖，不支持props配置选项进行接收,需使用defineProps接收
const props = defineProps({
  car: String,
  num: Number
})
//提交之前需要使用宏来定义有哪些申请
const emit = defineEmits(['changeNum'])
const lowerNum = (num) => {
  // 使用emit向父组件申请修改数据
  emit('changeNum', num)
}
</script>

<template>
<div class="son">我是子组件 - {{ car }}--{{ num }}</div>
<button @click="lowerNum(5)">降价5W</button>
</template>

<style scoped>
.son {
  background-color: #9d2c40;
  width: 200px;
  height:  200px;
}
</style>
