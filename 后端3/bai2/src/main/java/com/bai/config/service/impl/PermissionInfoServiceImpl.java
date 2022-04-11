package com.bai.config.service.impl;

import com.bai.config.dao.PermissionInfoDao;
import com.bai.config.entity.PermissionInfo;
import com.bai.config.service.PermissionInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 权限服务实现类
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className PermissionInfoServiceImpl
 * @projectName mall_user
 * @date 2022/3/29
 */

@Service
public class PermissionInfoServiceImpl implements PermissionInfoService {

    @Resource
    private PermissionInfoDao permissionInfoDao;

    @Override
    public boolean insertPer(PermissionInfo permissionInfo) {
        return permissionInfoDao.insertPer(permissionInfo);
    }

    @Override
    public boolean updatePer(PermissionInfo permissionInfo) {
        return permissionInfoDao.updatePer(permissionInfo);
    }

    @Override
    public boolean removePer(int id) {
        return permissionInfoDao.removePer(id);
    }

    @Override
    public List<PermissionInfo> findAll(Map<String,Object> params) {
        return permissionInfoDao.findAll(params);
    }

    @Override
    public PermissionInfo findById(int id) {
        return permissionInfoDao.findById(id);
    }
}
