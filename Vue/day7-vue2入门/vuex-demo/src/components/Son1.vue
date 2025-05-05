<template>
  <div class="box">
    <h2>Son1 子组件</h2>
    从vuex中获取的值: <label>{{count}}</label>
    <br>
    <button @click="subFive">值 - 5</button>
    <button @click="addFive">值 + 5</button>
    <hr>
    {{filterList}}
    <hr>
    {{$store.state.user.score}}
    {{$store.getters['user/capitalName']}}
    <hr>
    <button @click="changeScore1">点击修改成绩</button>
    <button @click="setUserInfo({name : 'lisi' , age : 22})">1S后修改用户信息</button>
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
    },
    changeScore1 () {
      // $score.commit('模块名/mutation方法',额外参数)
      this.$store.commit('user/changeScore', 77.2)
    },
    setUserInfo (info) {
      this.$store.dispatch('user/setUserInfo', info)
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
