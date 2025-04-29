import Vue from 'vue'
import VueRouter from "vue-router";
import Layout from '@/views/Layout.vue'
import ArticleDetail from "@/views/ArticleDetail.vue";
import Article from "@/views/Article.vue";
import Collect from "@/views/Collect.vue";
import Like from "@/views/Like.vue";
import User from "@/views/User.vue";
Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    //   配置一级路由：首页和面经详情页
    {
      path : '/',
      redirect : '/article',
      component: Layout,
      //   使用children配置二级路由
      //   配置二级路由出口，在需要嵌套的一级路由中配置二级路由显示的位置
      children: [
        {path : '/article'  , component : Article},
        {path : '/collect'  , component : Collect},
        {path : '/like'  , component : Like},
        {path : '/user'  , component : User},
      ]
    },


    {path : '/detail' , component : ArticleDetail},
  ],
  mode : 'history'
})

export default router