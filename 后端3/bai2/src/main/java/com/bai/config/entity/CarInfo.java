package com.bai.config.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * car_info
 * @author 
 */
@ToString
@Data
@EqualsAndHashCode
@Entity
@Table(name = "car_info")
public class CarInfo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "car_number",columnDefinition = "varchar(100) comment'车牌号'")
    private String carNumber;

    @Column(name = "car_state",columnDefinition = "int(1) comment'停车状态 1停车中 2缴费已出'")
    private int carState;

    @Column(name = "type",columnDefinition = "varchar(20) comment'车辆类型'")
    private String type;

    @Column(name = "user_name",columnDefinition = "varchar(100) comment'车辆所属人姓名'")
    private String userName;

    @Column(name = "user_id",columnDefinition = "int(1) comment'车辆所属人id'")
    private int userId;

    @Column(name = "image_url",columnDefinition = "text comment'图片地址'")
    private String imageUrl;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;


    private static final long serialVersionUID = 1L;


}