package com.bai.config.dao;

import com.bai.config.entity.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className MenuInfoDao
 * @projectName mall_user
 * @date 2022/3/29
 */

@Repository
@Mapper
public interface MenuInfoDao {

    boolean insertMenu(MenuInfo menuInfo);

    boolean updateMenu(MenuInfo menuInfo);

    boolean removeMenu(Integer id);

    List<MenuInfo> findByAll(Map<String,Object> params);

    MenuInfo findById(Integer id);

    MenuInfo findById(int id);
}
