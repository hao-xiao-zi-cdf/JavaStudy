<template>
  <div>
    <h1>自定义指令</h1>
    <input ref="inp" type="text" v-focus>
  </div>
</template>

<script>
export default {
  // mounted () {
  //   this.$refs.inp.focus();
  // }
  // 2.局部注册
    directives:{
      "focus" : {
        inserted(el){
          el.focus();
        }
      }
    }
}
</script>

<style>

</style>