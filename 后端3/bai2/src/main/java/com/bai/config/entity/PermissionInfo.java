package com.bai.config.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述:
 * 权限实体
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className PermissionInfo
 * @projectName mall_user
 * @date 2022/3/29
 */

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "permission_info")
public class PermissionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",columnDefinition = "varchar(100) comment'权限名称'")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "sub_time")
    private Date subTime;

    @Column(name = "create_user",columnDefinition = "varchar(100) comment'创建人'")
    private String createUser;

    @Column(name = "content",columnDefinition = "text comment'描述信息'")
    private String content;
}
