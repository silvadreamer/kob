import { createRouter, createWebHistory } from 'vue-router'
//引入的是组件
import PkIndexView from '../views/pk/PkIndexView.vue'
import RanklistIndexView from '../views/ranklist/RanklistIndexView.vue'
import RecordIndexView from '../views/record/RecordIndexView.vue'
import UserBotIndexView from '../views/user/bot/UserBotIndexView.vue'
import ErrorIndexView from '../views/error/ErrorIndexView.vue'
import UserAccountLoginView from '../views/user/account/UserAccountLoginView.vue'
import UserAccountRegisterView from '../views/user/account/UserAccountRegisterView.vue'



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
  },
  {
    path:'/user/account/login/',
    name:'userAccountLogin',
    component:UserAccountLoginView
  },
  {
    path:'/user/account/register/',
    name:'userAccountRegister',
    component:UserAccountRegisterView
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
