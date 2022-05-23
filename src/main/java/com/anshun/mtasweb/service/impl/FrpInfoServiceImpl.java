package com.anshun.mtasweb.service.impl;

import com.anshun.mtasweb.dao.FrpInfoDao;
import com.anshun.mtasweb.entity.FrpInfoEntity;
import com.anshun.mtasweb.service.FrpInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mtasflash Created on 2022-05-20 20:19
 */
@Service
public class FrpInfoServiceImpl implements FrpInfoService {
    @Resource
    private FrpInfoDao frpInfoDao;

    @Override
    public List<FrpInfoEntity> getAllData() {
        return frpInfoDao.queryList(null);
    }

    @Override
    public void updateData(FrpInfoEntity frpInfo) {
        frpInfoDao.update(frpInfo);
    }

    @Override
    public void addData(FrpInfoEntity frpInfo) {
        frpInfoDao.save(frpInfo);
    }

    @Override
    public void deleteData(int id) {
        frpInfoDao.delete(id);
    }
}
