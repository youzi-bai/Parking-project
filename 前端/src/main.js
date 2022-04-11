import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import axios from 'axios'
import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-chalk/display.css';


import * as http from './requests/index'
import api from './requests/api'


Vue.config.productionTip = false
Vue.prototype.$axios = axios
Vue.prototype.$http = http
Vue.prototype.$api = api
Vue.prototype.$axios = axios

Vue.use(ElementUI)
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
