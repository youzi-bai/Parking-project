package com.bai.config.dao;

import com.bai.config.entity.UserInfo;
import com.bai.config.entity.UserInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoDao {
    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer idUser);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);
    List<UserInfo> selectAllUser(Map<String,Object> params);

    UserInfo selectByPrimaryKey(Integer idUser);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo login(String nameUser,String password);

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    boolean insertUser(UserInfo userInfo);

    /***新功能（修改用户信息）**/
    @Update("UPDATE `user_info` SET `address_user` = #{addressUser}, `content` = #{content}, `email` = #{email}, `gender_user` = #{genderUser}, `ipone_user` = #{iponeUser}, " +
            "`name_user`=#{nameUser},`password` = #{password}, `phone` = #{phone}, `update_time` = #{updateTime} WHERE id = #{id}")
    boolean updateUser(UserInfo userInfo);

    /**
     * 按id查询
     * @param id
     * @return
     */
    @Select("SELECT * FROM user_info WHERE id=#{id}")
    UserInfo findById(Integer id);

    /**
     * 按用户名查
     * @param nameUser
     * @return
     */
    @Select("SELECT * FROM user_info WHERE name_user=#{nameUser}")
    UserInfo findBySame(String nameUser);

    /**
     * 修改密码
     * @param password
     * @return
     */
    @Update("UPDATE user_info SET password=#{password} WHERE id=#{id}")
    boolean updatePwd(@Param("password") String password,@Param("id") Integer id);
}