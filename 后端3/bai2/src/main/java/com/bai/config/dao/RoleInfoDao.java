package com.bai.config.dao;

import com.bai.config.entity.RoleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author
 * @version 1.0
 * 版权所有：
 * @className RoleInfoDao
 * @projectName graduation
 * @date 2022/3/28
 */

@Mapper
public interface RoleInfoDao {

   boolean insertRole(RoleInfo roleInfo);

   boolean updateRole(RoleInfo roleInfo);

   boolean removeRole(Integer roleId);

   List<RoleInfo> findAll(Map<String,Object> ps);

   RoleInfo findById(Integer roleId);
}
