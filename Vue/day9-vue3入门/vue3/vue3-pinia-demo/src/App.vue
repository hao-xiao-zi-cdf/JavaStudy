<script setup>
import Son1Com from "@/components/son1-com.vue";
import Son2Com from "@/components/son2-com.vue";
import { useCounterStore } from "@/stores/counter.js";

const counter = useCounterStore()
console.log(counter.count + " " + counter.msg)
</script>

<template>
  <h1>App.vue根组件 - {{ counter.count }} - {{ counter.msg }}</h1>
  <son1-com></son1-com>
  <son2-com></son2-com>
  {{ counter.doubleCount }}
</template>

<style scoped>

</style>
