package com.bai.config.controller;

import com.bai.config.dao.CarInfoDao;
import com.bai.config.entity.CommenResult;
import com.bai.config.entity.CarInfo;
import com.bai.config.service.CarInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/carInfo")
public class CarInfoController {
    @Resource
    private CarInfoService carInfoService;

    @Resource
    private CarInfoDao carInfoDao;

    //通过主键id查询
    @PostMapping("/selectByPrimaryKey")
    //泛型
    public CommenResult<CarInfo> selectUserById(@RequestBody HashMap<String ,Integer> hashMap){
        CommenResult<CarInfo> commenResult = new CommenResult<>("success", true, null);
        String carNumber = String.valueOf(hashMap.get("carNumber"));
        CarInfo carInfo = carInfoService.selectByPrimaryKey(carNumber);
        commenResult.setData(carInfo);
        return commenResult;
    }

    @PostMapping("/selectAllUser")
    public CommenResult<List<CarInfo>> selectAllUser(){
        CommenResult<List<CarInfo>> commenResult = new CommenResult<>("success", true, null);
        List<CarInfo> users = carInfoService.selectAllUser();
        commenResult.setData(users);
        return commenResult;
    }
    // 更新用户内容
    @PostMapping("/updateByPrimaryKey")
    public CommenResult<Integer> updateByPrimaryKey(@RequestBody CarInfo carInfo){
        CommenResult<Integer> commenResult = new CommenResult<>("success", true, null);
        int i = carInfoService.updateByPrimaryKey(carInfo);
        commenResult.setData(i);
        return commenResult;
    }


    /*******新功能*******/
    /**
     * 保存车辆
     * @param carInfo
     * @return
     */
    @PostMapping("/publish")
    public CommenResult publish(CarInfo carInfo){

        try{

            if (carInfo.getId()==null){

                carInfo.setCreateTime(new Date());

                return carInfoDao.insertCar(carInfo) ? CommenResult.success("新增成功",null,0) : CommenResult.error("新增失败");

            }else {

                CarInfo src = carInfoDao.findById(carInfo.getId());

                if (src == null)
                    return CommenResult.error("当前车辆信息不存在");

                return carInfoDao.updateCar(carInfo) ? CommenResult.success("修改成功",null,0) : CommenResult.error("修改失败");

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 删除车辆
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    public CommenResult remove(@PathVariable("id") Integer id){

        try{

            CarInfo src = carInfoDao.findById(id);

            if (src == null)
                return CommenResult.error("当前车辆信息不存在");

            return carInfoDao.remove(id) ? CommenResult.success("删除成功",null,0) : CommenResult.error("删除失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 按id查询车辆
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public CommenResult findById(@PathVariable("id") Integer id){

        try{

            CarInfo src = carInfoDao.findById(id);

            if (src == null)
                return CommenResult.error("当前车辆信息不存在");

            return CommenResult.success("查询成功",src,0);

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");

    }

    @PostMapping("/find/all")
    public CommenResult findAll(String carNumber,Integer userId){

        try{

            List<CarInfo> carInfos = carInfoDao.findAll(carNumber,userId);

            return carInfos.size()>0 ? CommenResult.success("查询成功",carInfos,carInfos.size()) : CommenResult.error("查询失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }
}
