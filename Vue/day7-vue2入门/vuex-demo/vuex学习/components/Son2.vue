<template>
  <div class="box">
    <h2>Son2 子组件</h2>
    从vuex中获取的值:<label>{{count}}</label>
    <br />
    <button>值 + 5</button>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  name: 'Son2Com',
  computed: {
    ...mapState(['count', 'title'])
  }
}
</script>

<style lang="css" scoped>
.box {
  border: 3px solid #ccc;
  width: 400px;
  padding: 10px;
  margin: 20px;
}
h2 {
  margin-top: 10px;
}
</style>
