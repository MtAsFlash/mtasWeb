package com.anshun.mtasweb.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CoreMenuEntity {

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 创建者id，0为超级管理员
     */
    private Integer creator;
    /**
     * 显示排序
     */
    private Integer display;
    /**
     * 父级的id，引用本表id字段
     */
    private Integer parentId;
    /**
     * 更新者id
     */
    private Integer updateUser;
    /**
     * 是否启用，0 禁用，1启用
     */
    private String flag;
    /**
     * 显示的图标
     */
    private String icon;
    /**
     * 类型，0 菜单，1 连接网址,2 隐藏连接
     */
    private String menuType;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 网址
     */
    private String url;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 权限代码
     */
    private String permission;
}
