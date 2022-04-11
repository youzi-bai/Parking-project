import http from '../index'

const baseURL = http.baseURL + "/parking"

export default{
    publishPark: baseURL+"/publish",
    removePark: baseURL + "/remove/{id}",
    findAllPark: baseURL + "/find/all",
    findIdPark: baseURL + "/find/{id}",
}