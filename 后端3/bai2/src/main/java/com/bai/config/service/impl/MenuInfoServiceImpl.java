package com.bai.config.service.impl;

import com.bai.config.dao.MenuInfoDao;
import com.bai.config.entity.MenuInfo;
import com.bai.config.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 菜单服务实现类
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className MenuInfoServiceImpl
 * @projectName mall_user
 * @date 2022/3/29
 */

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;

    @Override
    public boolean insertMenu(MenuInfo menuInfo) {
        return menuInfoDao.insertMenu(menuInfo);
    }

    @Override
    public boolean updateMenu(MenuInfo menuInfo) {
        return menuInfoDao.updateMenu(menuInfo);
    }

    @Override
    public boolean removeMenu(Integer id) {
        return menuInfoDao.removeMenu(id);
    }

    @Override
    public List<MenuInfo> findByAll(Map<String,Object> params) {
        return menuInfoDao.findByAll(params);
    }

    @Override
    public MenuInfo findById(int id) {
        return menuInfoDao.findById(id);
    }
}
