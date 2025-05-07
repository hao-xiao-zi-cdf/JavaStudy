//导入全局组件
import { createApp } from 'vue'
import App from './App.vue'
import WebButton from './components/WebButton.vue'


const Vue = createApp(App)

// 注册全局组件
Vue.component('WebButton', WebButton)

Vue.mount('#app')
