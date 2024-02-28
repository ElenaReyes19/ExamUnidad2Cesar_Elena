import Vue from "vue";
import VueRouter from "vue-router";



Vue.use(VueRouter);

import inicio from '../components/inicio.vue'
import carousel from '../components/carousel.vue'

const routes = [
    
    { path: '/', component: inicio },
    { path: '/1dd', component: carousel },
    
]

const router = new VueRouter({ routes, })
export default router;