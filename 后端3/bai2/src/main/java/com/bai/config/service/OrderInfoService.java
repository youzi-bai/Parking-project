package com.bai.config.service;

import com.bai.config.entity.OrderInfo;

import java.util.List;

public interface OrderInfoService {
    OrderInfo selectByPrimaryKey(Integer accountId);
    List<OrderInfo> selectAllUser();
    int updateByPrimaryKey(OrderInfo record);
}
