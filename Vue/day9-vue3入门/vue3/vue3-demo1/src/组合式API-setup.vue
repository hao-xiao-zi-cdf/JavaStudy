<script setup>
const msg = 'Hello Vue3'
const helloVue = () => {
  console.log(msg)
}
</script>

<template>
    <div>
      {{ msg }}
      <hr>
      <button @click="helloVue">按钮</button>
    </div>
</template>

<style scoped>

</style>

<!--<script>-->
<!--export default {-->
<!--  // setup函数执行时机在beforeCreate函数之前-->
<!--  // setup中获取不到this,undefined-->
<!--  // setup里可以编写数据和函数，但是想要在template中使用需要return-->
<!--  setup() {-->
<!--    // console.log('setup执行中...')-->
<!--    // 数据-->
<!--    const msg = 'Hello Vue3'-->
<!--    // 函数-->
<!--    const helloVue = () => {-->
<!--      console.log(msg)-->
<!--    }-->
<!--    return {-->
<!--      msg,-->
<!--      helloVue-->
<!--    }-->
<!--  },-->
<!--  beforeCreate() {-->
<!--    console.log('beforeCreate执行中...')-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<template>-->
<!--  <div>-->
<!--    {{ msg }}-->
<!--    <hr>-->
<!--    <button @click="helloVue">按钮</button>-->
<!--  </div>-->
<!--</template>-->

<!--<style scoped>-->

<!--</style>-->
