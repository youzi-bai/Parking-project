package com.bai.config.service;

import com.bai.config.entity.UserRole;

import java.util.List;

/**
 * 描述:
 * 用户角色关系
 * @author
 * @version 1.0
 * 版权所有：
 * @className UserRoleService
 * @projectName mall_user
 * @date 2022/3/28
 */

public interface UserRoleService {

    boolean insertUserRole(UserRole userRole);

    boolean updateUserRole(UserRole userRole);

    boolean removeUserRole(String roleId);

    List<UserRole> findByUser(Integer userId);
}
