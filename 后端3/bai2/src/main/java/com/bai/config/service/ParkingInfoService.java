package com.bai.config.service;

import com.bai.config.entity.ParkingInfo;

import java.util.List;

public interface ParkingInfoService {
    ParkingInfo selectByPrimaryKey(Integer parkingId);

    List<ParkingInfo> selectAllUser();
    int updateByPrimaryKey(ParkingInfo record);
}
