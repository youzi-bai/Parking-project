package com.bai.config.controller;

import com.bai.config.entity.CommenResult;
import com.bai.config.entity.OrderInfo;

import com.bai.config.service.OrderInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {
    @Resource
    private OrderInfoService orderInfoService;

    //通过主键id查询
    @PostMapping("/selectByPrimaryKey")
    //泛型
    public CommenResult<OrderInfo> selectUserById(@RequestBody HashMap<String, Integer> hashMap){
        CommenResult<OrderInfo> commenResult = new CommenResult<>("success", true, null);
        Integer accountId = hashMap.get("accountId");
        OrderInfo orderInfo = orderInfoService.selectByPrimaryKey(accountId);
        commenResult.setData(orderInfo);
        return commenResult;
    }

    @PostMapping("/selectAllUser")
    public CommenResult<List<OrderInfo>> selectAllUser(){
        CommenResult<List<OrderInfo>> commenResult = new CommenResult<>("success", true, null);
        List<OrderInfo> orderInfos = orderInfoService.selectAllUser();
        commenResult.setData(orderInfos);
        return commenResult;
    }
    // 更新用户内容
    @PostMapping("/updateByPrimaryKey")
    public CommenResult<Integer> updateByPrimaryKey(@RequestBody OrderInfo orderInfo){
        CommenResult<Integer> commenResult = new CommenResult<>("success", true, null);
        int i = orderInfoService.updateByPrimaryKey(orderInfo);
        commenResult.setData(i);
        return commenResult;
    }
}
