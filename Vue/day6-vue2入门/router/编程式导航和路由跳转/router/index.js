import Home from '@/views/Home'
import Search from '@/views/Search'
import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter) // VueRouter插件初始化

// 创建了一个路由对象
const router = new VueRouter({
  routes: [
    { path: '/home', component: Home },
    //   配置动态路由规则
    //   根据路由名称跳转路由,适用于路径较长的情况
    { name: 'search', path: '/search/:key?', component: Search },
    { path: '/', redirect : '/home'}
  ],
  mode : 'history'
})

export default router