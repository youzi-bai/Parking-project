package com.bai.config.controller;

import com.bai.config.dao.ParkingInfoDao;
import com.bai.config.entity.CommenResult;
import com.bai.config.entity.ParkingInfo;
import com.bai.config.service.ParkingInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/parking")
public class ParkingInfoController {
    @Resource
    private ParkingInfoService parkingInfoService;

    @Resource
    private ParkingInfoDao parkingInfoDao;

    //通过主键id查询
    @PostMapping("/selectByPrimaryKey")
    //泛型
    public CommenResult<ParkingInfo> selectUserById(@RequestBody HashMap<String ,Integer> hashMap){
        CommenResult<ParkingInfo> commenResult = new CommenResult<>("success", true, null);
        Integer parkingId = hashMap.get("parkingId");
        ParkingInfo parkingInfo = parkingInfoService.selectByPrimaryKey(parkingId);
        commenResult.setData(parkingInfo);
        return commenResult;
    }

    @PostMapping("/selectAllUser")
    public CommenResult<List<ParkingInfo>> selectAllUser(){
        CommenResult<List<ParkingInfo>> commenResult = new CommenResult<>("success", true, null);
        List<ParkingInfo> users = parkingInfoService.selectAllUser();
        commenResult.setData(users);
        return commenResult;
    }
    // 更新用户内容
    @PostMapping("/updateByPrimaryKey")
    public CommenResult<Integer> updateByPrimaryKey(@RequestBody ParkingInfo parkingInfo){
        CommenResult<Integer> commenResult = new CommenResult<>("success", true, null);
        int i = parkingInfoService.updateByPrimaryKey(parkingInfo);
        commenResult.setData(i);
        return commenResult;
    }


    /********新接口*******/
    /**
     * 保存停车场
     * @param parkingInfo
     * @return
     */
    @PostMapping("/publish")
    public CommenResult publish(ParkingInfo parkingInfo){

        try{

            if (parkingInfo.getId()==null || parkingInfo.getId()==0){

                parkingInfo.setCreateTime(new Date());
                if (parkingInfo.getSumPosition()==null || parkingInfo.getSumPosition()==0){
                    parkingInfo.setSumPosition(1);
                }
                parkingInfo.setRestPosition(parkingInfo.getSumPosition());

                return parkingInfoDao.insertPark(parkingInfo) ? CommenResult.success("新增成功",null,0) : CommenResult.error("新增失败");

            }else {

                ParkingInfo src = parkingInfoDao.findById(parkingInfo.getId());

                if (src == null)
                    return CommenResult.error("当前信息不存在");

                src.setUpdateTime(new Date());

                return parkingInfoDao.updatePark(parkingInfo) ? CommenResult.success("修改成功",null,0) : CommenResult.error("修改失败");

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 删除停车场
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    public CommenResult remove(@PathVariable("id") Integer id){

        try{


            ParkingInfo parkingInfo = parkingInfoDao.findById(id);

            if (parkingInfo == null)
                return CommenResult.error("当前信息不存在");

            return parkingInfoDao.removePark(id) ? CommenResult.success("删除成功",null,0) : CommenResult.error("删除失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 查询停车场列表
     * @param name
     * @return
     */
    @PostMapping("/find/all")
    public CommenResult findAll(String name,Integer page,Integer pageSize){

        try{

            PageHelper.startPage(page,pageSize);

            List<ParkingInfo> parkingInfos = parkingInfoDao.findAll(name);

            PageInfo<ParkingInfo> res = new PageInfo<>(parkingInfos);

            return parkingInfos.size()>0 ? CommenResult.successPage("查询成功",res.getList(),res.getTotal()) : CommenResult.error("查询失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }

    /**
     * 按id查询
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public CommenResult findById(@PathVariable("id") Integer id){

        try{

            ParkingInfo parkingInfo = parkingInfoDao.findById(id);

            return parkingInfo!=null ? CommenResult.success("查询成功",parkingInfo,0) : CommenResult.error("查询失败");

        }catch (Exception e){
            e.printStackTrace();
        }

        return CommenResult.error("服务器开小差");
    }
}
