import http from '../index'

const baseURL = http.baseURL + "/menu"

export default{
    publishMenu: baseURL+"/publish",
    removeMenu: baseURL + "/remove/{id}",
    findAllMenu: baseURL + "/find/all",
    findIdMenu: baseURL + "/find/{id}",
}