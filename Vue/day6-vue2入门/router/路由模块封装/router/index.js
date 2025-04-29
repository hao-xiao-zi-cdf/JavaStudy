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
    ]
});

export default router;