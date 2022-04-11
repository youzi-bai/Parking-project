package com.bai.config.service.impl;

import com.bai.config.dao.UserRoleDao;
import com.bai.config.entity.UserRole;
import com.bai.config.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 *
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className UserRoleServiceImpl
 * @projectName mall_user
 * @date 2022/3/28
 */

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public boolean insertUserRole(UserRole userRole) {
        return userRoleDao.insertUserRole(userRole);
    }

    @Override
    public boolean updateUserRole(UserRole userRole) {
        return userRoleDao.updateUserRole(userRole);
    }

    @Override
    public boolean removeUserRole(String roleId) {
        return userRoleDao.removeUserRole(roleId);
    }

    @Override
    public List<UserRole> findByUser(Integer userId) {
        return userRoleDao.findByUser(userId);
    }
}
