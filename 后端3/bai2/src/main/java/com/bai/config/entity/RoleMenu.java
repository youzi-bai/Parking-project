package com.bai.config.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述:
 *
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className RoleMenu
 * @projectName graduation
 * @date 2022/3/30
 */

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "role_menu")
public class RoleMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_id",columnDefinition = "int(1) comment'角色id'")
    private int roleId;

    @Column(name = "menu_id",columnDefinition = "int(1) comment'菜单id'")
    private int menuId;

    @Column(name = "role_name",columnDefinition = "varchar(100) comment'角色名称'")
    private String roleName;

    @Column(name = "menu_name",columnDefinition = "varchar(100) comment'菜单名称'")
    private String menuName;

    @Column(name = "per_id",columnDefinition = "varchar(100) comment'权限id'")
    private String perId;

    @Column(name = "per_name",columnDefinition = "varchar(100) comment'权限名称'")
    private String perName;

    @Column(name = "sub_time")
    private Date subTime;

    @Transient
    private MenuInfo menuInfo;

}
