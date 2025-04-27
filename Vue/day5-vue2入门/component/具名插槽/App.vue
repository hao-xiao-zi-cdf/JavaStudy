<template>
  <div>
    <MyDialog>
<!--      使用具名插槽后，组件标签内插入的内容需要包裹在template标签内部-->
      <template v-slot:head>
        我是头部大标题
      </template>
      <template v-slot:body>
        我是内容
      </template>
      <template #button>
        <button>取消</button>
        <button>确认</button>
      </template>
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