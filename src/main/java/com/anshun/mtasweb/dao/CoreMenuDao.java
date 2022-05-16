package com.anshun.mtasweb.dao;

import com.anshun.mtasweb.entity.CoreMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mtasflash Created on 2022-05-16 20:36
 */
@Mapper
public interface CoreMenuDao extends BaseDao<CoreMenuEntity> {
    /**
     * 获取菜单信息
     *
     * @return 菜单信息
     */
    List<CoreMenuEntity> getMenus();
}
