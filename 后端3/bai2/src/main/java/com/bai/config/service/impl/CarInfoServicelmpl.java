package com.bai.config.service.impl;

import com.bai.config.dao.CarInfoDao;
import com.bai.config.entity.CarInfo;
import com.bai.config.service.CarInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarInfoServicelmpl implements CarInfoService {
    @Resource
    private CarInfoDao carInfoDao;
    @Override
    public CarInfo selectByPrimaryKey(String carNumber) {
        CarInfo carInfo = carInfoDao.selectByPrimaryKey(carNumber);
        return carInfo;
    }

    @Override
    public List<CarInfo> selectAllUser() {
        return carInfoDao.selectAllUser();
    }

    @Override
    public int updateByPrimaryKey(CarInfo record) {
        int i = carInfoDao.updateByPrimaryKey(record); //数据库
        return i;
    }
}
