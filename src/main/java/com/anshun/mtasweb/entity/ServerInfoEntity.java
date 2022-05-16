package com.anshun.mtasweb.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author mtasflash Created on 2022-05-06 12:12
 */
@Data
public class ServerInfoEntity implements Serializable {

    private static final long serialVersionUID = -2985135228106128915L;
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
