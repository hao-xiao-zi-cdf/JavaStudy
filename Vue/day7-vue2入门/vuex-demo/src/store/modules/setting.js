const state = {
  color: 'blue'
}
const mutations = {
  changeColor (state, newColor) {
    state.color = newColor
  }
}
const actions = {}
const getters = {}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
