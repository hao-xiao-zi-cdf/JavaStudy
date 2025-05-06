<script setup>
import { ref } from 'vue'
// ref函数可接收简单或复杂类型数据，并返回响应式的对象
const count = ref(100)
const changeCount = (num) => {
  console.log(count)
  console.log(count.value)
  count.value += num
}
</script>

<template>
    <button @click="changeCount(-1)">-1</button>
    {{ count }}
    <button @click="changeCount(1)">+1</button>
</template>

<!--<script setup>-->
<!--import { reactive } from 'vue'-->
<!--// reactive函数可接收对象类型数据，并返回响应式的对象-->
<!--const obj = reactive({-->
<!--  count: 100-->
<!--})-->
<!--const changeCount = (num) => {-->
<!--  obj.count += num-->
<!--}-->
<!--</script>-->

<!--<template>-->
<!--  <button @click="changeCount(-1)">-1</button>-->
<!--  {{ obj.count }}-->
<!--  <button @click="changeCount(1)">+1</button>-->
<!--</template>-->

<!--<style scoped>-->

<!--</style>-->
