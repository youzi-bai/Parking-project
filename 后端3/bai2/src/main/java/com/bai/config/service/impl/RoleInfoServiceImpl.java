package com.bai.config.service.impl;

import com.bai.config.dao.RoleInfoDao;
import com.bai.config.dao.RoleMenuDao;
import com.bai.config.entity.RoleInfo;
import com.bai.config.entity.RoleMenu;
import com.bai.config.service.RoleInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author
 * @version 1.0
 * 版权所有：
 * @className RoleInfoServiceImpl
 * @projectName graduation
 * @date 2022/3/28
 */

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Resource
    private RoleInfoDao roleInfoDao;

    @Resource
    private RoleMenuDao roleMenuDao;

    @Override
    @Transactional
    public boolean insertRole(RoleInfo roleInfo) {

        return roleInfoDao.insertRole(roleInfo);
    }

    /**
     * 修改角色，并且修改角色菜单对应关系
     * @param roleInfo
     * @return
     */
    @Override
    public boolean updateRole(RoleInfo roleInfo) {
        return roleInfoDao.updateRole(roleInfo);
    }

    @Override
    public boolean removeRole(Integer id) {
        return roleInfoDao.removeRole(id);
    }

    @Override
    public List<RoleInfo> findAll(Map<String,Object> ps) {
        return roleInfoDao.findAll(ps);
    }

    @Override
    public RoleInfo findById(Integer id) {
        return roleInfoDao.findById(id);
    }
}
