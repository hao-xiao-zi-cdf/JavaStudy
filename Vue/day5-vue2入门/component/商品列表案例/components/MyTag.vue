<template>
  <div class="my-tag">
    <input
      v-focus=tag
      ref="inp"
      v-if="flag"
      class="input"
      type="text"
      @blur="flag=false"
      @keyup.enter="handEnter"
    />
    <div v-else class="text" @dblclick="handleClick">
      {{tag}}
    </div>
  </div>
</template>

<script>
export default {
  props: {
    tag : String,
  },
  data (){
    return {
      flag : false,
    }
  },
  methods : {
    handleClick (){
      this.flag = true;
      // this.$nextTick(() => {
      //   this.$refs.inp.focus();
      // })
    },
    handEnter (e){
      this.$emit("hand-enter",e.target.value);
    }
  }
}
</script>

<style scoped>
.my-tag {
  cursor: pointer;
  .input {
    appearance: none;
    outline: none;
    border: 1px solid #ccc;
    width: 100px;
    height: 40px;
    box-sizing: border-box;
    padding: 10px;
    color: #666;
    &::placeholder {
      color: #666;
    }
  }
}
</style>