const state = {
  userInfo: {
    name: 'zhangsan',
    age: 18
  },
  score: 88.88
}
const mutations = {
  changeScore (state, newVal) {
    state.score = newVal
  },
  changeUserInfo (state, obj) {
    state.userInfo = obj
  }
}
const actions = {
  setUserInfo (context, obj) {
    setTimeout(() => {
      context.commit('changeScore', obj)
    }, 1000)
  }
}
const getters = {
  capitalName (state) {
    return state.userInfo.name.toUpperCase()
  }
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
