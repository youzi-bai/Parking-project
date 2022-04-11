package com.bai.config.dao;

import com.bai.config.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 描述:
 * 用户角色关系mapper
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className UserRoleDao
 * @projectName graduation
 * @date 2022/3/28
 */

@Mapper
public interface UserRoleDao {

    boolean insertUserRole(UserRole userRole);

    boolean updateUserRole(UserRole userRole);

    boolean removeUserRole(String roleId);

    List<UserRole> findByUser(Integer userId);
}
