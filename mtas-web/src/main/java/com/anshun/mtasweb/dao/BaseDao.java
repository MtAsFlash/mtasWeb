package com.anshun.mtasweb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author mtasflash Created on 2022-05-05 17:00
 */
@Mapper
public interface BaseDao<T> {
    /**
     * 单条数据查询
     *
     * @param id 查询的主键ID
     * @return 单条数据
     */
    T queryObject(@Param("value") Object id);

    /**
     * 批量查询
     *
     * @param map 查询参数
     * @return 数据列表
     */
    List<T> queryList(Map<String, String> map);

    /**
     * 总数查询
     *
     * @return 总数
     */
    int queryTotal();

    /**
     * 保存数据
     *
     * @param t 数据实体
     */
    void save(T t);

    /**
     * 批量保存数据
     *
     * @param ts 数据库实体
     */
    void saveBatch(@Param("list") List<T> ts);

    /**
     * 更新数据
     *
     * @param t 数据库实体
     */
    void update(T t);

    /**
     * 删除数据库数据
     *
     * @param id 删除数据的主键id
     */
    void delete(@Param("value") Object id);

    /**
     * 批量删除
     *
     * @param ids 批量删除的多个数据主键ID
     */
    void deleteBatch(@Param("array") Object[] ids);
}
