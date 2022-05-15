package com.anshun.mtasweb.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author mtasflash Created on 2022-05-06 12:12
 */
@Data
public class ServerInfoEntity {
    /**
     * 主键
     */
    private int id;
    /**
     * 服务名
     */
    private String serverName;
    /**
     * 服务描述
     */
    private String serverDesc;
    /**
     * 服务ip地址
     */
    private String host;
    /**
     * 服务端口
     */
    private String port;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 修改时间
     */
    private Timestamp updateTime;

}
