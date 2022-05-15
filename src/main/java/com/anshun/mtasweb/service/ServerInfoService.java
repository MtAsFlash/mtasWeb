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
    List<ServerInfoEntity> getServerInfo();

    void addServerInfo(ServerInfoEntity serverInfo);

    void deleteServerInfo(Integer id);

    void updateServerInfo(ServerInfoEntity bean);
}
