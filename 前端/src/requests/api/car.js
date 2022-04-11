import http from '../index'

const baseURL = http.baseURL + "/carInfo"

export default{
    publishCar: baseURL+"/publish",
    removeCar: baseURL + "/remove/{id}",
    findAllCar: baseURL + "/find/all",
    findIdCar: baseURL + "/find/{id}",
}