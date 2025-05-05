<template>
  <div id="app">
    <h1>{{title}}</h1>
    <input type="text"><br><br>
<!--    <button @click="changeTitle({title : '大标题', time : 3000})">3S后修改标题</button>-->
    <button @click="changeAsyncTitle({title : '大标题', time : 1000})">3S后修改标题</button>
    <Son1></Son1>
    <hr><hr>
    <Son2></Son2>
    <div>{{count}}</div>
  </div>
</template>

<script>
import Son1 from './components/Son1.vue'
import Son2 from './components/Son2.vue'
// 从vuex中导入mapState函数
import { mapState, mapActions } from 'vuex'

export default {
  name: 'app',
  data: function () {
    return {

    }
  },
  components: {
    Son1,
    Son2
  },
  computed: {
    ...mapState(['count', 'title'])
  },
  created () {
    console.log(this.count)
  },
  methods: {
    ...mapActions(['changeAsyncTitle']),
    changeTitle (obj) {
      this.$store.dispatch('changeAsyncTitle', obj)
    }
  }
}
</script>

<style>
#app {
  width: 600px;
  margin: 20px auto;
  border: 3px solid #ccc;
  border-radius: 3px;
  padding: 10px;
}
</style>
