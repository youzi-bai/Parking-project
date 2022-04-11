import http from '../index'

const baseURL = http.baseURL + "/permission"

export default{
    publishPer: baseURL+"/publish",
    removePer: baseURL + "/remove/{id}",
    findAllPer: baseURL + "/find/all",
    findIdPer: baseURL + "/find/{id}",
}