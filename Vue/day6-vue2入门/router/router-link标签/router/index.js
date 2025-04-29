import VueRouter from "vue-router";
import Find from "@/views/Find.vue";
import My from "@/views/My.vue";
import Friend from "@/views/Friend.vue";
import Vue from "vue";

Vue.use(VueRouter);

const router = new VueRouter({

    routes : [
        {path : '/find',component : Find},
        {path : '/my',component : My},
        {path : '/friend',component : Friend},
    ],
    //定制类名
    linkActiveClass: "active",//模糊匹配
    linkExactActiveClass: "exact-active"//精确匹配
});

export default router;