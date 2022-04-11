package com.bai.config.entity;

import javax.persistence.*;

/**
 * 描述:
 * 用户角色关系实体
 * @author
 * @version 1.0
 * 版权所有：
 * @className userRole
 * @projectName graduation
 * @date 2022/3/28
 */


@Entity
@Table(name="user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;//主键

    @Column(name = "role_id",columnDefinition = "int(1)")
    private int roleId;

    @Column(name = "user_id",columnDefinition = "int(1)")
    private int userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
