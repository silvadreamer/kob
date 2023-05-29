import { createRouter, createWebHistory } from 'vue-router'
//引入的是组件
import PkIndexView from '../views/pk/PkIndexView.vue'
import RanklistIndexView from '../views/ranklist/RanklistIndexView.vue'
import RecordIndexView from '../views/record/RecordIndexView.vue'
import UserBotIndexView from '../views/user/bot/UserBotIndexView.vue'
import ErrorIndexView from '../views/error/ErrorIndexView.vue'
import UserAccountLoginView from '../views/user/account/UserAccountLoginView.vue'
import UserAccountRegisterView from '../views/user/account/UserAccountRegisterView.vue'
import store from '../store/index'


const routes = [
  {
    path : '/',
    name : 'home',
    redirect : '/pk/',
    meta: {
      requestAuth: true
    }
  },
  {
    path : '/pk/',
    name : 'PkIndexView',
    component: PkIndexView,
    meta: {
      requestAuth: true
    }
  },
  {
    path : '/ranklist/',
    name : 'RanklistIndexView',
    component: RanklistIndexView,
    meta: {
      requestAuth: true
    }
  },
  {
    path : '/user/bot/',
    name : 'UserBotIndexView',
    component: UserBotIndexView,
    meta: {
      requestAuth: true
    }
  },
  {
    path : '/record/',
    name : 'RecordIndexView',
    component: RecordIndexView,
    meta: {
      requestAuth: true
    }
  },
  {
    path : '/404/',
    name : 'ErrorIndexView',
    component: ErrorIndexView,
    meta: {
      requestAuth: false
    }
  },
  {
    path : '/:catchAll(.*)',
    redirect: "/404/",
  },
  {
    path:'/user/account/login/',
    name:'userAccountLogin',
    component:UserAccountLoginView,
    meta: {
      requestAuth: false
    }
  },
  {
    path:'/user/account/register/',
    name:'userAccountRegister',
    component:UserAccountRegisterView,
    meta: {
      requestAuth: false
    }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from , next) => {
  if(to.meta.requestAuth && !store.state.user.is_login)
  {
    next({name:'userAccountLogin'})
  }
  else
  {
    next()
  }
})

export default router
