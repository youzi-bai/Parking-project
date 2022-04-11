import http from '../index'

const baseURL = http.baseURL + "/userInfo"

export default{
    publishUser: baseURL+"/publish",
    removeUser: baseURL + "/remove/{id}",
    findAllUser: baseURL + "/find/all",
    findIdUser: baseURL + "/find/byId",
    updateUser: baseURL + '/publish/mine'
}