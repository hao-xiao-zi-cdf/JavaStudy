<script setup>
import { useCounterStore } from "@/stores/counter.js";
const counter = useCounterStore()
</script>

<template>
<div>
  子组件Son1-com.vue - {{ counter.count }}
  <button @click="counter.addCount">+1</button>
</div>
</template>

<style scoped>

</style>
