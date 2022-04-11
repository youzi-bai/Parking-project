package com.bai.config.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述:
 *
 * @author 孙喆
 * @version 1.0
 * 版权所有：校园app
 * @className MenuInfo
 * @projectName mall_user
 * @date 2022/3/29
 */

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "menu_info")
public class MenuInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",columnDefinition = "varchar(50) comment'菜单名'")
    private String name;

    @Column(name = "icon",columnDefinition = "varchar(200) comment'图标'")
    private String icon;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "sub_time")
    private Date subTime;

    @Column(name = "create_user",columnDefinition = "varchar(100) comment'创建人'")
    private String createUser;

    @Column(name = "path",columnDefinition = "varchar(100) comment'路径'")
    private String path;
}
