package com.bai.config.service;

import com.bai.config.entity.PermissionInfo;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 权限服务接口
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className PermissionInfoService
 * @projectName mall_user
 * @date 2022/3/29
 */
public interface PermissionInfoService {

    boolean insertPer(PermissionInfo permissionInfo);

    boolean updatePer(PermissionInfo permissionInfo);

    boolean removePer(int id);

    List<PermissionInfo> findAll(Map<String,Object> params);

    PermissionInfo findById(int id);
}
