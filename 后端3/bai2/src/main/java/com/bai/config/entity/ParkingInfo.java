package com.bai.config.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * parking_info
 * @author 
 */
@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "parking_info")
public class ParkingInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//主键

    /**
     * 停车位总数
     */
    @Column(name = "sum_position",columnDefinition = "int(1) comment'停车位总数'")
    private Integer sumPosition;

    /**
     * 剩余停车位的数量
     */
    @Column(name = "rest_position",columnDefinition = "int(1) comment'剩余停车位数'")
    private Integer restPosition;

    /**
     * 停车场状态（1：有空位;2:已满）
     */
    @Column(name = "state",columnDefinition = "int(1) not null default 1 comment'停车场状态'")
    private int state;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id",columnDefinition = "int(1) comment'创建人id'")
    private int createUserId;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 修改人id
     */
    @Column(name = "update_user_id",columnDefinition = "int(1) comment'修改人id'")
    private int updateUserId;

    /**
     * 车位名称
     */
    @Column(name = "name",columnDefinition = "varchar(200) comment'停车场管理'")
    private String name;

    /**
     * 车位描述
     */
    @Column(name = "content",columnDefinition = "text comment'车位描述'")
    private String content;

    @Column(name = "is_remove",columnDefinition = "int(1) not null default 0")
    private Integer isRemove;

    private static final long serialVersionUID = 1L;
}