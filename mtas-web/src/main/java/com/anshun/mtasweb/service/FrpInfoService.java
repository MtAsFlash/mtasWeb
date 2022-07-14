package com.anshun.mtasweb.service;

import com.anshun.mtasweb.entity.FrpInfoEntity;

import java.util.List;

/**
 * @author mtasflash Created on 2022-05-20 20:19
 */
public interface FrpInfoService {
    /**
     * 获取所有frp分配信息
     *
     * @return frp分配信息
     */
    List<FrpInfoEntity> getAllData();

    /**
     * 更新frp分配信息
     *
     * @param frpInfo frp分配信息
     */
    void updateData(FrpInfoEntity frpInfo);

    /**
     * 添加frp分配信息
     *
     * @param frpInfo frp分配信息
     */
    void addData(FrpInfoEntity frpInfo);

    /**
     * 删除frp分配信息
     *
     * @param id 主键
     */
    void deleteData(int id);
}
