<script setup>
import InputCom from "@/components/input-com.vue";
import {ref} from "vue";
const text = ref('1234')
</script>

<template>
  <input-com v-model="text"></input-com>
  <hr>
  {{ text }}
</template>

<style scoped>

</style>
