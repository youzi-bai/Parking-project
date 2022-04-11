import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/login/login'
import Admin from './views/admin/admin'
import Home from './views/admin/homeManage'
import userInfo from './views/admin/userInfoManage'
Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: "/",
      redirect:"/admin",
    },
    {
      path: '/admin',
      name: 'Admin',
      component: Admin
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '/userInfo',
      name: 'userInfo',
      component: userInfo
    },
    
  ]
})

//配置路由拦截
router.beforeEach((to, from, next) => {
  const isLogin = sessionStorage.userInfo ? true : false;
  if (to.path == "/login") {
    next();
  } else {
    if(isLogin){
      next()
    }else{
      next('login')
    }
  }
});

router.afterEach((to, from, next) => {
  window.scrollTo(0, 0);
});

const originalPush = Router.prototype.push;
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err);
};

export default router;