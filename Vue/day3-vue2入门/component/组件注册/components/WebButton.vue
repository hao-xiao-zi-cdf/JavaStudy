<template>
  <button class="button" @click="getAlert">
    通用按钮
  </button>
</template>

<script>
  export default {
    methods : {
      getAlert () {
        window.alert("Hello Vue");
      }
    }
  }
</script>

<style>
 .button {
   width: 50px;
   height: 50px;
   border-radius: 50%;
   background-color: darkseagreen;
 }
</style>