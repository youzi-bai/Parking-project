package com.bai.config.service.impl;

import com.bai.config.dao.ParkingInfoDao;
import com.bai.config.entity.ParkingInfo;
import com.bai.config.service.ParkingInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ParkingInfoServiceImpl implements ParkingInfoService {

    @Resource
    private ParkingInfoDao parkingInfoDao;
    @Override
    public ParkingInfo selectByPrimaryKey(Integer parkingId) {
        ParkingInfo parkingInfo = parkingInfoDao.selectByPrimaryKey(parkingId);
        return parkingInfo;
    }

    @Override
    public List<ParkingInfo> selectAllUser() {
        return parkingInfoDao.selectAllUser();
    }

    @Override
    public int updateByPrimaryKey(ParkingInfo record) {
        int i = parkingInfoDao.updateByPrimaryKey(record); //数据库
        return i;
    }
}
