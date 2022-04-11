package com.bai.config.service.impl;

import com.bai.config.dao.OrderInfoDao;
import com.bai.config.entity.OrderInfo;
import com.bai.config.service.OrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Resource
    private  OrderInfoDao orderInfoDao;
    @Override
    public OrderInfo selectByPrimaryKey(Integer accountId) {
        OrderInfo orderInfo = orderInfoDao.selectByPrimaryKey(accountId);
        return orderInfo;
    }

    @Override
    public List<OrderInfo> selectAllUser() {
        return orderInfoDao.selectAllUser();
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        int i = orderInfoDao.updateByPrimaryKey(record); //数据库
        return i;
    }
}
