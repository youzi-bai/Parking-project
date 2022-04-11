package com.bai.config.dao;

import com.bai.config.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoDaoTest {
    @Autowired(required = true)
    private UserInfoDao userInfoDao;

    //测试添加数据
    @Test
    public void selectByPrimaryKey(){
        Integer id_user=1;
        UserInfo result = userInfoDao.selectByPrimaryKey((id_user));
        System.out.println(result);
    }
}
