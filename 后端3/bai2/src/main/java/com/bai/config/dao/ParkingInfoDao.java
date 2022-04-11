package com.bai.config.dao;

import com.bai.config.entity.ParkingInfo;
import com.bai.config.entity.ParkingInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ParkingInfoDao {
    long countByExample(ParkingInfoExample example);

    int deleteByExample(ParkingInfoExample example);

    int deleteByPrimaryKey(Integer parkingId);

    int insert(ParkingInfo record);

    int insertSelective(ParkingInfo record);

    List<ParkingInfo> selectByExample(ParkingInfoExample example);

    ParkingInfo selectByPrimaryKey(Integer parkingId);

    int updateByExampleSelective(@Param("record") ParkingInfo record, @Param("example") ParkingInfoExample example);

    int updateByExample(@Param("record") ParkingInfo record, @Param("example") ParkingInfoExample example);

    int updateByPrimaryKeySelective(ParkingInfo record);

    int updateByPrimaryKey(ParkingInfo record);

    List<ParkingInfo> selectAllUser();

    /*******新功能*******/
    @Insert("INSERT INTO `parking_info` (`create_time`, `create_user_id`, `name`, `rest_position`, `state`, `sum_position`,`content`) " +
            "VALUES (#{createTime},#{createUserId},#{name},#{restPosition},#{state},#{sumPosition},#{content});")
    boolean insertPark(ParkingInfo parkingInfo);

    @Update("UPDATE `parking_info` SET `name` = #{name}, `rest_position` = #{restPosition}, `state` = #{state}, `sum_position` = #{sumPosition}, " +
            "`update_time` = #{updateTime}, `update_user_id` = #{updateUserId},`content`=#{content} WHERE id=#{id}")
    boolean updatePark(ParkingInfo parkingInfo);

    @Delete("DELETE FROM parking_info WHERE id=#{id}")
    boolean removePark(int id);

    @Select("<script>SELECT * FROM parking_info WHERE is_remove=0  " +
            "<if test=\"name!=null and name!=''\">AND name like concat('%',#{name},'%')</if>" +
            "</script>")
    @Results({
            @Result(column = "sum_position",property = "sumPosition"),
            @Result(column = "rest_position",property = "restPosition"),
            @Result(column = "create_time",property = "createTime")
    })
    List<ParkingInfo> findAll(String name);

    @Select("SELECT * FROM parking_info WHERE id=#{id}")
    ParkingInfo findById(int id);

}