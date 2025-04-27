<template>
  <div class="base-progress">
    <div class="inner" :style="{ width: w + '%' }">
      <span>{{ w }}%</span>
    </div>
  </div>
</template>

<script>
export default {
  //prop校验:子组件对父组件传递过来的prop值进行校验,检验不通过,控制台报错
  //基础写法:类型校验
  // props : {
  //   w : Number,
  // }
  //完整写法(检验类型,是否必填,默认值,自定义校验)
  props : {
    w : {
      type : Number,
      // required : true,
      default : 50,
      // 返回true校验通过,返回false校验不通过
      validator (value) {
        if(value >= 0 && value <= 100){
          return true;
        }
        console.error("传递的值超过符合范围")
        return false;
      }
    }
  }
}
</script>

<style scoped>
.base-progress {
  height: 26px;
  width: 400px;
  border-radius: 15px;
  background-color: #272425;
  border: 3px solid #272425;
  box-sizing: border-box;
  margin-bottom: 30px;
}
.inner {
  position: relative;
  background: #379bff;
  border-radius: 15px;
  height: 25px;
  box-sizing: border-box;
  left: -3px;
  top: -2px;
}
.inner span {
  position: absolute;
  right: 0;
  top: 26px;
}
</style>