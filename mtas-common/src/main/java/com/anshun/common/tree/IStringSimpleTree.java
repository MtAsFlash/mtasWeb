package com.anshun.common.tree;

import java.util.List;

/**
 * TreeResp需要形成树结构的类可以继承该接口, 并实现对应的方法(只有id/pid为String才能使用)
 *
 * @param <NodeType> 节点的类型
 * @author mtasflash Created on 2022-08-16 23:36
 */
@SuppressWarnings("unused")
public interface IStringSimpleTree<NodeType> {
    /**
     * 获取节点的id
     *
     * @return 返回id的值
     */
    String getId();

    /**
     * 获取节点的pid
     *
     * @return 返回pid的值
     */
    String getPid();

    /**
     * 获取节点名称
     *
     * @return 节点名称
     */
    String getName();

    /**
     * 该节点的父节点名称
     *
     * @param name 父节点名称
     */
    void setParentName(String name);

    /**
     * 获取子节点
     *
     * @return 子节点列表
     */
    List<NodeType> getChildNode();

    /**
     * 为子节点赋值
     */
    void initChildNode();
}
