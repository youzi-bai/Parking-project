package com.bai.config.service.impl;

import com.bai.config.dao.UserInfoDao;
import com.bai.config.dao.UserRoleDao;
import com.bai.config.entity.RoleInfo;
import com.bai.config.entity.UserInfo;
import com.bai.config.entity.UserRole;
import com.bai.config.service.UserInfoService;
import com.bai.config.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public UserInfo selectByPrimaryKey(int idUser) {
        UserInfo userInfo = userInfoDao.selectByPrimaryKey(idUser);
        return userInfo;
    }



    @Override //
    public List<UserInfo> selectAllUser(Map<String,Object> params) {
        return userInfoDao.selectAllUser(params);
    }

    @Override
    @Transactional
    public boolean publishUserInfo(UserInfo userInfo) {

        userInfoDao.insertUser(userInfo);

        int userId = userInfo.getId();

        List<RoleInfo> roleInfos = userInfo.getRoleInfos();

        if (roleInfos!=null && roleInfos.size()>0){
            roleInfos.forEach(item ->{
                //创建用户角色关系
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(item.getId());
                userRoleDao.insertUserRole(userRole);
            });
        }
        return true;
    }


    /**
     * 登陆
     * @param nameUser
     * @param password
     * @return
     */
    @Override
    public UserInfo login(String nameUser, String password) {
        return userInfoDao.login(nameUser,password);
    }

    /**
     * 修改用户
     * @param userInfo
     * @return
     */
    @Override
    @Transactional
    public boolean updateUser(UserInfo userInfo) {


        //修改用户信息
        userInfoDao.updateUser(userInfo);

        //修改用户角色信息
        int userId = userInfo.getId();

        List<RoleInfo> roleInfos = userInfo.getRoleInfos();

        if (roleInfos!=null && roleInfos.size()>0){
            roleInfos.forEach(item ->{
                //根据角色信息查询对应角色关系
                List<UserRole> userRole = userRoleDao.findByUser(userId);
                if (userRole!=null && userRole.size()>0){
                    UserRole ur = userRole.get(0);
                    ur.setRoleId(item.getId());
                    userRoleDao.updateUserRole(ur);
                }else {
                    UserRole ur = new UserRole();
                    ur.setRoleId(item.getId());
                    ur.setUserId(userId);
                    userRoleDao.insertUserRole(ur);
                }
            });
        }
        return true;
    }

    @Override
    public UserInfo findBySame(String nameUser) {
        UserInfo userInfos = userInfoDao.findBySame(nameUser);

        return userInfos;
    }

    @Override
    public boolean updatePwd(String password,Integer id) {
        return userInfoDao.updatePwd(password,id);
    }


}
