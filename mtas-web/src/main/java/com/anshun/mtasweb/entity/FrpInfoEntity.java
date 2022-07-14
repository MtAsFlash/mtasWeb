package com.anshun.mtasweb.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author mtasflash Created on 2022-05-20 20:15
 */
@Data
public class FrpInfoEntity implements Serializable {

    private static final long serialVersionUID = -2510368912490696805L;

    /**
     * 主键
     */
    private int id;
    /**
     * frp名称
     */
    private String frpName;
    /**
     * frp开放的端口
     */
    private String frpPort;
    /**
     * 分配给的PC名称
     */
    private String pcName;
    /**
     * 详情/备注
     */
    private String frpDesc;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 修改时间
     */
    private Timestamp updateTime;
}
