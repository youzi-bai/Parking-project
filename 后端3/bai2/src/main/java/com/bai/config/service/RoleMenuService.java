package com.bai.config.service;

import com.bai.config.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className RoleMenuService
 * @projectName graduation
 * @date 2022/3/31
 */
public interface RoleMenuService {

    boolean insertRoleMenu(RoleMenu roleMenu);

    boolean removeRoleMenu(int id);

    List<RoleMenu> findByCondition( Map<String,Object> params);

    boolean updateRoleMenu(RoleMenu roleMenu);

    RoleMenu findById(int id);
}
