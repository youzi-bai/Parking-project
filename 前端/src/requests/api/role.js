import http from '../index'

const baseURL = http.baseURL + "/role"

export default{
    publishRole: baseURL+"/publish",
    configMenu: baseURL + "/config/menu",
    removeRole: baseURL + "/remove/{id}",
    findAllRole: baseURL + "/find/all",
    findIdRole: baseURL + "/find/{id}",
}