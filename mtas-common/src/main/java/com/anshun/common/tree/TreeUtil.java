package com.anshun.common.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mtasflash Created on 2022-08-16 23:36
 */
@SuppressWarnings("unused")
public class TreeUtil {

    /**
     * 根据data数据构建一棵树结构
     */
    public static <T extends IStringSimpleTree<T>> Map<String, T> createTree(List<T> data) {
        Map<String, T> map = new HashMap<>(16);
        //初始化
        for (T datum : data) {
            datum.initChildNode();
            map.put(datum.getId(), datum);
        }
        //构建树
        for (T datum : data) {
            T pNode = map.get(datum.getPid());
            if (pNode != null) {
                if (!pNode.getChildNode().contains(datum)) {
                    //TODO:需要优化
                    //避免多次调用重复添加
                    pNode.getChildNode().add(datum);
                }
                datum.setParentName(pNode.getName());
            }
        }
        return map;
    }

    /**
     * 获取指定节点下的所有子节点
     */
    public static <T extends IStringSimpleTree<T>> T getChildTree(List<T> data, String uid) {
        Map<String, T> treeMap = createTree(data);
        return treeMap.get(uid);
    }

    /**
     * 只获取根节点
     */
    public static <T extends IStringSimpleTree<T>> Map<String, T> getRootTree(List<T> data) {
        Map<String, T> treeMap = createTree(data);
        List<String> isNotRootIds = new ArrayList<>();
        for (T datum : data) {
            if (treeMap.containsKey(datum.getPid())) {
                isNotRootIds.add(datum.getId());
            }
        }
        for (String isNotRootId : isNotRootIds) {
            treeMap.remove(isNotRootId);
        }
        return treeMap;
    }
}
