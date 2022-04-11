package com.bai.config.dao;

import com.bai.config.entity.CarInfo;
import com.bai.config.entity.CarInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CarInfoDao {
    long countByExample(CarInfoExample example);

    int deleteByExample(CarInfoExample example);

    int deleteByPrimaryKey(String carNumber);

    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    List<CarInfo> selectByExample(CarInfoExample example);

    CarInfo selectByPrimaryKey(String carNumber);

    int updateByExampleSelective(@Param("record") CarInfo record, @Param("example") CarInfoExample example);

    int updateByExample(@Param("record") CarInfo record, @Param("example") CarInfoExample example);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);

    List<CarInfo> selectAllUser();


    /*********新功能*********/
    /**
     * 新增车辆
     * @param carInfo
     * @return
     */
    @Insert("INSERT INTO `car_info` (`car_number`, `car_state`, `create_time`, `image_url`, `type`, `user_id`, `user_name`) " +
            "VALUES (#{carNumber},#{carState},#{createTime},#{imageUrl},#{type},#{userId},#{userName})")
    boolean insertCar(CarInfo carInfo);

    /**
     * 修改车辆
     * @param carInfo
     * @return
     */
    @Update("UPDATE `car_info` SET `car_number` =#{carNumber} , `car_state` =#{carState} , `create_time` =#{createTime} , " +
            "`image_url` =#{imageUrl} , `type` =#{type} , `user_id` =#{userId} , `user_name` =#{userName}  WHERE `id`=#{id};")
    boolean updateCar(CarInfo carInfo);

    /**
     * 删除车辆
     * @param id
     * @return
     */
    @Delete("DELETE FROM car_info WHERE id=#{id}")
    boolean remove(Integer id);

    /**
     * 按id查询车辆
     * @param id
     * @return
     */
    @Select("SELECT * FROM car_info WHERE id=#{id}")
    CarInfo findById(Integer id);

    /**
     * 按条件查询车辆
     * @param number
     * @param userId
     * @return
     */
    @Select("<script>SELECT * FROM car_info WHERE 1=1" +
            "<if test=\"carNumber!=null and carNumber!=''\">and car_number like concat('%',#{carNumber},'%')</if>" +
            "<if test=\"userId!=null\">and user_id=#{userId}</if>" +
            "</script>")
    List<CarInfo> findAll(String carNumber,Integer userId);



}