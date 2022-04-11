package com.bai.config.service;

import com.bai.config.entity.RoleInfo;
import com.bai.config.entity.UserInfo;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    UserInfo selectByPrimaryKey(int idUser);
    List<UserInfo> selectAllUser(Map<String,Object> params);
    boolean publishUserInfo(UserInfo userInfo);
    UserInfo login(String nameUser,String password);

    boolean updateUser(UserInfo userInfo);
    UserInfo findBySame(String nameUser);
    boolean updatePwd(String password,Integer id);
}
