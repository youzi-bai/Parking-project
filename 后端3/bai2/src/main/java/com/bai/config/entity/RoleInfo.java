package com.bai.config.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @author
 * @version 1.0
 * 版权所有：
 * @className RoleInfo
 * @projectName graduation
 * @date 2022/3/28
 */

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name="role_info")
public class RoleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//主键

    @Column(name = "role_name",columnDefinition = "varchar(20) comment'角色名称'")
    private String roleName;

    @Column(name = "sub_time")
    private Date subTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "state",columnDefinition = "int(1) not null default 0 comment'角色状态 0启用 1禁用'")
    private int state;

    @Column(name = "level",columnDefinition = "varchar(10) comment'角色级别'")
    private String level;

    @Column(name = "description",columnDefinition = "text comment'描述信息'")
    private String description;


    @Transient
    private List<RoleMenu> roleMenus;

}
