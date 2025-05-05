import Vue from 'vue'
import Vuex from 'vuex'
import user from '@/store/modules/user'
import set from '@/store/modules/setting'

// 安装Vuex
Vue.use(Vuex)

// 创建仓库（空仓库）
const store = new Vuex.Store({
  // state是Store仓库中用来唯一存放共享局数据的地方，所有的共享数据需要放在这里
  state: {
    title: '根组件',
    count: 100,
    list: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
  },
  // 使用mutations对象提供修改共享数据的方法
  mutations: {
    addOne (state) {
      state.count++
    },
    addFive (state) {
      state.count += 5
    },
    subFive (state) {
      state.count -= 5
    },
    changeTitle (state, title) {
      state.title = title
    }
  },
  // 在actions中编写异步方法
  actions: {
    // context可以简单认为是store,obj是我们自己的参数
    changeAsyncTitle (context, obj) {
      setTimeout(() => {
        // 调用mutations的方法进行数据修改，actions负责异步
        context.commit('changeTitle', obj.title)
      }, obj.time)
    }
  },
  getters: {
    filterList (state) {
      return state.list.filter(item =>
        item >= 5
      )
    }
  },
  modules: {
    user,
    set
  }
})

console.log(store.state.count)

// 导出store
export default store
