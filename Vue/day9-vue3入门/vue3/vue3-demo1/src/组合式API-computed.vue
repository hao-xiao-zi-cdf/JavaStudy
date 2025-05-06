<script setup>
import { computed, ref } from 'vue'
const list = ref([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
// computed计算属性函数可基于现有属性重新计算出新的属性
const computedList = computed(() => {
  return list.value.filter((item) => item > 3)
})
const addElement = () => {
  list.value.push(999)
}
</script>

<template>
<div>
  <div>原数组：{{ list }}</div>
  <div>新数组：{{ computedList }}</div>
  <button @click="addElement">添加元素</button>
</div>
</template>

<style scoped>

</style>
