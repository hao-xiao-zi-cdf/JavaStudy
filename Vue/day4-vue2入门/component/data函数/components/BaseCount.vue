<template>
  <div>
    <button @click="count--">-</button>
    {{count}}
    <button @click="count++">+</button>
  </div>
</template>

<script>
  export default {
    // data在组件中必须以函数形式存在
    // 好处：由于组件可复用性，每个组件实例化时，都会调用data函数返回一个数据对象
    // 保证了每个组件实例有自己独立的数据对象
    data(){
      return {
        count : 1000,
      }
    }
  }
</script>

<style scoped>

</style>