import Vue from 'vue'
import App from './App.vue'
import MyTag from './components/MyTag.vue'
import MyTable from './components/MyTable.vue'

Vue.config.productionTip = false

Vue.component("MyTag", MyTag);
Vue.component("MyTable", MyTable);

Vue.directive("focus",{
  inserted(el,binding){
    el.value = binding.value;
    el.focus();
  }
})

new Vue({
  render: h => h(App),
}).$mount('#app')
