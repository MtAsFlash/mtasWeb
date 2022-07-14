package com.anshun.mtasweb.service;

import com.anshun.mtasweb.entity.CoreMenuEntity;

import java.util.List;

/**
 * @author mtasflash Created on 2022-05-16 20:40
 */
public interface CoreMenuService {
    /**
     * 获取菜单信息
     *
     * @return 网页菜单信息
     */
    List<CoreMenuEntity> getMenus();
}
