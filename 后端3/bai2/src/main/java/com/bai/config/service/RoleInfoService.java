package com.bai.config.service;

import com.bai.config.entity.RoleInfo;
import com.bai.config.entity.RoleMenu;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className RoleInfoService
 * @projectName graduation
 * @date 2022/3/28
 */
public interface RoleInfoService {

    boolean insertRole(RoleInfo roleInfo);

    boolean updateRole(RoleInfo roleInfo);

    boolean removeRole(Integer id);

    List<RoleInfo> findAll(Map<String,Object> ps);

    RoleInfo findById(Integer id);
}
