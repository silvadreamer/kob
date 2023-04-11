import { createRouter, createWebHistory } from 'vue-router'
//引入的是组件
import PkIndexView from '../views/pk/PkIndexView.vue'
import RanklistIndexView from '../views/ranklist/RanklistIndexView.vue'
import RecordIndexView from '../views/record/RecordIndexView.vue'
import UserBotIndexView from '../views/user/bot/UserBotIndexView.vue'
import ErrorIndexView from '../views/error/ErrorIndexView.vue'



const routes = [
  {
    path : '/',
    name : 'home',
    redirect : '/pk/'
  },
  {
    path : '/pk/',
    name : 'PkIndexView',
    component: PkIndexView
  },
  {
    path : '/ranklist/',
    name : 'RanklistIndexView',
    component: RanklistIndexView
  },
  {
    path : '/user/bot/',
    name : 'UserBotIndexView',
    component: UserBotIndexView
  },
  {
    path : '/record/',
    name : 'RecordIndexView',
    component: RecordIndexView
  },
  {
    path : '/404/',
    name : 'ErrorIndexView',
    component: ErrorIndexView
  },
  {
    path : '/:catchAll(.*)',
    redirect: "/404/"
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
