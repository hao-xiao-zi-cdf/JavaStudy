import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

//自定义指令：自己定义指令，可以封装DOM操作，额外拓展功能
//自定义的指令需要先进行注册才能使用，注册方式包括：全局注册和局部注册
//全局注册所有组件均可使用，局部注册只能当前组件使用

// 1.全局注册
// Vue.directive('focus',{
//   //inserted：指令会在绑定的元素被插入到页面中时调用
//   "inserted" (el){
//     console.log(el);
//     el.focus();
//   }
// })
new Vue({
  render: h => h(App),
}).$mount('#app')
