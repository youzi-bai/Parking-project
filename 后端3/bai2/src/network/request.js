import axios from 'axios'

export function request (config){
    // axios.defaults.baseURL = '/api'
    // axios.defaults.headers.post['Content-Type'] = 'application/json';
    const instance  =  axios.create({
        baseURL: '/api',
        timeout: 5000,
    })
    instance.interceptors.request.use(config => {
        console.log("请求成功")
        return config
    },err=>{
        console.log("请求失败："+err)
    })

    instance.interceptors.response.use(config=>{
        console.log('响应成功')
        return config.data.data
    },err=>{
        console.log("错误："+err)
    })

    //发送真正的网络请求
    return instance(config)
}
