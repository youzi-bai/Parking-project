package com.bai.config.service;

import com.bai.config.entity.MenuInfo;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 菜单服务接口
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className MenuInfoService
 * @projectName mall_user
 * @date 2022/3/29
 */

public interface MenuInfoService {

    boolean insertMenu(MenuInfo menuInfo);

    boolean updateMenu(MenuInfo menuInfo);

    boolean removeMenu(Integer id);

    List<MenuInfo> findByAll(Map<String,Object> params);

    MenuInfo findById(int id);
}
