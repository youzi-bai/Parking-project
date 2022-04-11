package com.bai.config.service.impl;

import com.bai.config.dao.RoleMenuDao;
import com.bai.config.entity.RoleMenu;
import com.bai.config.service.RoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className RoleMenuServiceImpl
 * @projectName graduation
 * @date 2022/3/31
 */

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Resource
    private RoleMenuDao roleMenuDao;

    @Override
    public boolean insertRoleMenu(RoleMenu roleMenu) {
        return roleMenuDao.insertRoleMenu(roleMenu);
    }

    @Override
    public boolean removeRoleMenu(int id) {
        return roleMenuDao.removeRoleMenu(id);
    }

    @Override
    public List<RoleMenu> findByCondition(Map<String, Object> params) {
        return roleMenuDao.findByCondition(params);
    }

    @Override
    public boolean updateRoleMenu(RoleMenu roleMenu) {
        return roleMenuDao.updateRoleMenu(roleMenu);
    }

    @Override
    public RoleMenu findById(int id) {
        return roleMenuDao.findById(id);
    }
}
