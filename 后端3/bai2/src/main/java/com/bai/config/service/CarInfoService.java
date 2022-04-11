package com.bai.config.service;
import com.bai.config.entity.CarInfo;

import java.util.List;

public interface CarInfoService {

    CarInfo selectByPrimaryKey(String carNumber);

    List<CarInfo> selectAllUser();
    int updateByPrimaryKey(CarInfo record);
}
