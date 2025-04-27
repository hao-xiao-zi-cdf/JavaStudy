<template>
  <div>
<!--    由于组件与组件之间数据不能直接通信，父组件不能直接拿到子组件的数据-->
<!--    可以使用作用域插槽获取子组件数据-->
<!--    作用域插槽：定义slot插槽的同时，可以给进行传值，将来会被封装成对象传给组件使用-->
    <MyTable :list="list">
<!--      3.需要在template标签中获取,使用#插槽名称=“接收对象”-->
      <template #default="obj">
        <button @click="del(obj.row.id)">删除</button>
      </template>
    </MyTable>
    <MyTable :list="list2">
      <template #default="obj">
        <button @click="selete(obj.row)">查看</button>
      </template>
    </MyTable>
  </div>
</template>

<script>
import MyTable from './components/MyTable.vue'
export default {
  data () {
    return {
      list: [
        { id: 1, name: '张小花', age: 18 },
        { id: 2, name: '孙大明', age: 19 },
        { id: 3, name: '刘德忠', age: 17 },
      ],
      list2: [
        { id: 1, name: '赵小云', age: 18 },
        { id: 2, name: '刘蓓蓓', age: 19 },
        { id: 3, name: '姜肖泰', age: 17 },
      ]
    }
  },
  components: {
    MyTable
  },
  methods : {
    selete (row) {
      alert(row.id + " " + row.name);
    },
    del(id) {
      this.list = this.list.filter(item => item.id !== id);
    }
  }
}
</script>
