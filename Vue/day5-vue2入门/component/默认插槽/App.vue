<template>
  <div>
<!--    场景：组件复用时，想要自定义组件内部内容-->
<!--    插槽：对组件挖一个槽口，在这个槽口里面支持自定义内容-->
    <MyDialog>
<!--      2.在组件标签内编写需要自定义的内容-->
<!--      你确认要删除吗-->
    </MyDialog>

    <MyDialog>
      你确认要退出系统吗
    </MyDialog>
  </div>
</template>

<script>
import MyDialog from './components/MyDialog.vue'
export default {
  data () {
    return {

    }
  },
  components: {
    MyDialog
  }
}
</script>

<style>
body {
  background-color: #b3b3b3;
}
</style>