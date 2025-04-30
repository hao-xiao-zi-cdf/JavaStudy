<template>
  <div class="box">
    <h2>Son1 子组件</h2>
    从vuex中获取的值: <label>{{count}}</label>
    <br>
    <button @click="subFive">值 - 5</button>
    <button @click="addFive">值 + 5</button>
    <br>
    {{filterList}}
  </div>
</template>

<script>
import { mapState, mapGetters } from 'vuex'
export default {
  name: 'Son1Com',
  computed: {
    ...mapState(['count', 'title', 'list']),
    ...mapGetters(['filterList'])
  },
  methods: {
    addFive () {
      this.$store.commit('addFive')
    },
    subFive () {
      this.$store.commit('subFive')
    }
  }
}
</script>

<style lang="css" scoped>
.box{
  border: 3px solid #ccc;
  width: 400px;
  padding: 10px;
  margin: 20px;
}
h2 {
  margin-top: 10px;
}
</style>
