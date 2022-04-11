package com.bai.config.dao;

import com.bai.config.entity.PermissionInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 权限dao
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className PermissionInfoDao
 * @projectName mall_user
 * @date 2022/3/29
 */

@Mapper
public interface PermissionInfoDao {

    boolean insertPer(PermissionInfo permissionInfo);

    boolean updatePer(PermissionInfo permissionInfo);

    boolean removePer(int id);

    List<PermissionInfo> findAll(Map<String,Object> params);

    PermissionInfo findById(int id);
}
