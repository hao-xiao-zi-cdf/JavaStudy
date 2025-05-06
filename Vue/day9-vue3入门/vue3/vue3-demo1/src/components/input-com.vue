<script setup>
const modelValue = defineModel()
</script>

<template>
  <input type="text" :value="modelValue" @input="e => modelValue = e.target.value">
</template>

<style scoped>

</style>
