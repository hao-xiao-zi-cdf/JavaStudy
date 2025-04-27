import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

// 1.下载VueRouter v3.6.5
// 2.引入VueRouter
import VueRouter from "vue-router";

// 3.安装初始化VueRouter
Vue.use(VueRouter);
// 4.创建VueRouter实例

import Find from "./views/Find.vue";
import My from "./views/My.vue";
import Friend from "./views/Friend.vue";
//核心2步骤
//a.创建组件放置到views,配置路由组件映射关系
const router = new VueRouter({
  // 配置路由规则
  routes : [
    {path : '/find',component : Find},
    {path : '/my',component : My},
    {path : '/friend',component : Friend},
  ]
});

// 5.注入VueRouter，建立Vue实例和VueRouter实例关联
new Vue({
  render: h => h(App),
  router : router
}).$mount('#app')