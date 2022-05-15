package com.anshun.mtasweb.service.impl;

import com.anshun.mtasweb.dao.BaseDao;
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

    @Resource
    private BaseDao baseDao;

    @Override
    public List<ServerInfoEntity> getServerInfo() {
        List<ServerInfoEntity> serverInfoList = serverInfoDao.queryList(null);
        return serverInfoList;
    }
}
