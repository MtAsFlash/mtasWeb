package com.anshun.mtasweb.service.impl;

import com.anshun.mtasweb.dao.ServerInfoDao;
import com.anshun.mtasweb.entity.ServerInfoEntity;
import com.anshun.mtasweb.service.ServerInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mtasflash Created on 2022-05-06 14:36
 */
@Service
public class ServerInfoServiceImpl implements ServerInfoService {

    @Resource
    private ServerInfoDao serverInfoDao;

    @Override
    public List<ServerInfoEntity> getServerInfo() {
        return serverInfoDao.queryList(null);
    }

    @Override
    public void addServerInfo(ServerInfoEntity serverInfo) {
        serverInfoDao.save(serverInfo);
    }

    @Override
    public void deleteServerInfo(Integer id) {
        serverInfoDao.delete(id);
    }

    @Override
    public void updateServerInfo(ServerInfoEntity serverInfo) {
        serverInfoDao.update(serverInfo);
    }
}
