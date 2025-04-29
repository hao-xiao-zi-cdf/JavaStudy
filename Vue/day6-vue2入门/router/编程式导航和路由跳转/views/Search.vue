<template>
  <div class="search">
<!--    获取查询参数$route.query.查询参数名称-->
<!--    获取动态路由参数$route.params.查询参数名称-->
    <p>搜索关键字: {{$route.params.key}}</p>
<!--    <p>搜索关键字: {{$route.query.word}}</p>-->
    <p>搜索结果: </p>
    <ul>
      <li>.............</li>
      <li>.............</li>
      <li>.............</li>
      <li>.............</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'MyFriend',
//   根据查询参数发送异步请求
  created(){
    // console.log(this.$route.query.key);
    // console.log(this.$route.params.key);
  }
}
</script>

<style>
.search {
  width: 400px;
  height: 240px;
  padding: 0 20px;
  margin: 0 auto;
  border: 2px solid #c4c7ce;
  border-radius: 5px;
}
</style>