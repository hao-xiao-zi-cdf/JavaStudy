<template>
  <div class="home">
    <div class="logo-box"></div>
    <div class="search-box">
      <input v-model="word" type="text">
      <button @click="goSearch">搜索一下</button>
    </div>
    <div class="hot-link">
      热门搜索：
<!--      router-link-查询参数传参-->
<!--      设置导航链接-->
      <router-link to="/search/黑马程序员">黑马程序员</router-link>
      <router-link to="/search/前端培训">前端培训</router-link>
      <router-link to="/search/如何成为前端大牛">如何成为前端大牛</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'FindMusic',
  data() {
    return {
      word : '',
    };
  },
  methods : {
    // 编程式导航：跟router-link一样，是实现路由跳转的一种方式，
    // 1.实现方式：根据路径跳转
    goSearch(){
      // this.$router.push('/search');   基础写法
      // this.$router.push({//完整写法
      //   path : '/search',
      // })
      // console.log('hhhh');
      // this.$router.push({
      //   name : 'search'
      // })
      // 使用查询参数传参(基础写法)
      // this.$router.push(`/search?word=${this.word}`)
      // 查询参数传参（完整写法）
      // this.$router.push({
      //   path : '/search',
      //   query : {
      //     word : this.word,
      //   }
      // });
      //使用动态路由传参
      // this.$router.push(`/search/${this.word}`)
      // this.$router.push({
      //   path:`/search/${this.word}`,
      // })
      //编程式导航：根据路由名字进行跳转-RESTFul风格传参
      this.$router.push({
        name : 'search',
        params : {
          key : this.word,
        }
      })
    }
  }
}
</script>

<style>
.logo-box {
  height: 150px;
  background: url('@/assets/logo.jpeg') no-repeat center;
}
.search-box {
  display: flex;
  justify-content: center;
}
.search-box input {
  width: 400px;
  height: 30px;
  line-height: 30px;
  border: 2px solid #c4c7ce;
  border-radius: 4px 0 0 4px;
  outline: none;
}
.search-box input:focus {
  border: 2px solid #ad2a26;
}
.search-box button {
  width: 100px;
  height: 36px;
  border: none;
  background-color: #ad2a26;
  color: #fff;
  position: relative;
  left: -2px;
  border-radius: 0 4px 4px 0;
}
.hot-link {
  width: 508px;
  height: 60px;
  line-height: 60px;
  margin: 0 auto;
}
.hot-link a {
  margin: 0 5px;
}
</style>