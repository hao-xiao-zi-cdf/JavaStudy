<template>
  <div>
<!--    b.配置导航-->
    <div class="footer_wrap">
<!--      router-link:称为导航链接，Vue-Router提供的全局组件，用于替换a标签-->
<!--      作用：可以为导航链接提供高亮样式效果，当每个导航被选中，该标签会被添加class类-->
<!--      可以通过自定义类内容为选中导航提供高亮样式-->
      <router-link to="/find">发现音乐</router-link>
      <router-link to="/my">我的音乐</router-link>
      <router-link to="/friend">朋友</router-link>
    </div>
    <div class="top">
<!--      设置组件展示位置-->
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
body {
  margin: 0;
  padding: 0;
}
.footer_wrap {
  position: relative;
  left: 0;
  top: 0;
  display: flex;
  width: 100%;
  text-align: center;
  background-color: #333;
  color: #ccc;
}
.footer_wrap a {
  flex: 1;
  text-decoration: none;
  padding: 20px 0;
  line-height: 20px;
  background-color: #333;
  color: #ccc;
  border: 1px solid black;
}

.footer_wrap a.active {
  background-color: tomato;
}

.footer_wrap a:hover {
  background-color: #555;
}
</style>