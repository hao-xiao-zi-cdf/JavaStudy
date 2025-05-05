<template>
  <div class="box">
    <h2>Son2 子组件</h2>
    从vuex中获取的值:<label>{{count}}</label>
    <br />
    <button>值 + 5</button>
    <hr>
    {{user.userInfo.age}}
    {{user.userInfo.name}}
    {{color}}
    {{capitalName}}
    {{user.score}}
    <button @click="changeScore(33)">点击修改成绩</button>
    <button @click="setUserInfo({name : 'zhaoliu' , age : 30})">1S后修改用户信息</button>
  </div>
</template>

<script>
import { mapState, mapGetters, mapMutations, mapActions } from 'vuex'
export default {
  name: 'Son2Com',
  computed: {
    ...mapState(['count', 'title']),
    ...mapState(['user', 'set']),
    ...mapState('set', ['color']),
    ...mapGetters('user', ['capitalName'])
  },
  methods: {
    ...mapMutations('user', ['changeScore']),
    ...mapActions('user', ['setUserInfo'])
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
