package com.anshun.mtasweb.service;

import com.anshun.mtasweb.entity.ServerInfoEntity;

import java.util.List;

/**
 * @author mtasflash Created on 2022-05-06 14:40
 */
public interface ServerInfoService {
    /**
     * 获取所有的服务信息
     *
     * @return 服务信息
     */
    List<ServerInfoEntity> getAllData();

    /**
     * 添加服务器信息
     *
     * @param serverInfo 服务器信息
     */
    void addData(ServerInfoEntity serverInfo);

    /**
     * 删除服务器信息
     *
     * @param id 服务器id
     */
    void deleteData(Integer id);

    /**
     * 更新服务器信息
     *
     * @param serverInfo 服务器信息
     */
    void updateData(ServerInfoEntity serverInfo);
}
