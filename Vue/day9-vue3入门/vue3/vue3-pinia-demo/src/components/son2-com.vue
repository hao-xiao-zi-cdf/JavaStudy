<script setup>
import { useCounterStore } from "@/stores/counter.js";
const counter = useCounterStore()
</script>

<template>
  <div>
    子组件Son2-com.vue - {{ counter.count }}
    <button @click="counter.subCount()">-1</button>
  </div>
</template>

<style scoped>

</style>
