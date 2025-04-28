import Home from '@/views/Home'
import Search from '@/views/Search'
import NotFind from '@/views/NotFind'
import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter) // VueRouter插件初始化

// 创建了一个路由对象
const router = new VueRouter({
  routes: [
    // 路由重定向：当访问某个路径时，自动跳转到另外一个路径
    {path : '/',redirect : '/search'},
    {path: '/home', component: Home },
    {path: '/search/:words?', component: Search },
    {path : '*', component : NotFind}
  ],
  mode : 'history'
})

export default router