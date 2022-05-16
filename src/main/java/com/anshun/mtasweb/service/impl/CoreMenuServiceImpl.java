package com.anshun.mtasweb.service.impl;

import com.anshun.mtasweb.dao.CoreMenuDao;
import com.anshun.mtasweb.entity.CoreMenuEntity;
import com.anshun.mtasweb.service.CoreMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mtasflash Created on 2022-05-16 20:42
 */
@Service
public class CoreMenuServiceImpl implements CoreMenuService {
    @Resource
    private CoreMenuDao coreMenuDao;

    @Override
    public List<CoreMenuEntity> getMenus() {
        return coreMenuDao.getMenus();
    }

}
