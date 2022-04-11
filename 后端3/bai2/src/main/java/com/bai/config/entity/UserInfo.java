package com.bai.config.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * user_info
 * @author 
 */
@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {
    /**
     * 用户工号
     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_user")
//    private Integer idUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 用户姓名
     */
    @Column(name = "name_user",columnDefinition = "varchar(100) comment'账号用户名'")
    private String nameUser;

    /**
     * 用户手机号
     */
    @Column(name = "ipone_user",columnDefinition = "varchar(100) comment'手机'")
    private String iponeUser;

    /**
     * 用户地址
     */
    @Column(name = "address_user",columnDefinition = "text comment'地址'")
    private String addressUser;


    /**
     * 用户性别
     */
    @Column(name = "gender_user",columnDefinition = "varchar(10) comment'性别'")
    private String genderUser;

    /**
     * 用户状态（0：已离职；1：任职中；2：用户）
     */
    @Column(name = "state_user",columnDefinition = "int(1) not null default 1 comment'用户状态'")
    private Integer stateUser;

    /**
     * 用户密码
     */
    @Column(name = "password",columnDefinition = "varchar(100) comment'密码'")
    private String password;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人id
     */
    private Integer createUserId;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 更改人id
     */
    private Integer updateUserId;

    @Column(name = "content",columnDefinition = "text comment'个人简介'")
    private String content;

    @Column(name = "phone",columnDefinition = "varchar(50) comment'电话'")
    private String phone;

    @Column(name = "email",columnDefinition = "varchar(50) comment'邮箱'")
    private String email;

    private static final long serialVersionUID = 1L;

    @Transient
    private List<RoleInfo> roleInfos;

    @Transient
    private RoleInfo top;

    @Transient
    private List<Map<String,Object>> menus;
}