<script setup>
import { ref, watch } from 'vue'
// watch函数用来监听一个或多个数据的变化，当监听的数据变化时，执行watch里的回调函数
const username = ref('张三')
const password = ref('223781')
const userInfo = ref({
  age: 20,
  sxe: '男'
})
const changeUserName = () => {
  username.value = '李四'
}
const changePassWord = () => {
  password.value = '123456'
}
const changeUserInfo = () => {
  userInfo.value.age++
}
watch(
  // 监听一个数据传入对象的ref对象
  // username, (newVal, oldVal) => {
  //   console.log(newVal, oldVal)
  // }
  // 监听多个数据传入ref数组对象
  [username, password, userInfo],(newVal, oldVal) => {
    console.log(newVal, oldVal)
  },{immediate: true, deep: true}
)

// 精准监听对象中的某个属性变化
watch(() => userInfo.value.age, () => {
  console.log(userInfo.value.age)
})
</script>

<template>
<div>
  {{ username }}
  <button @click="changeUserName">修改名字</button>
  <hr>
  {{ password }}
  <button @click="changePassWord">修改密码</button>
  <hr>
  {{ userInfo }}
  <button @click="changeUserInfo">修改信息</button>
</div>
</template>

<style scoped>

</style>
