import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mtasflash Created on 2022-08-19 16:02
 */
public class Test1 {
    @Data
    static class TreeEntity {
        String pId;
        String id;
        String data;
        List<TreeEntity> childNode;

        TreeEntity(String pId, String id, String data) {
            this.id = id;
            this.data = data;
            this.pId = pId;
        }
    }

    public static List<TreeEntity> fun1(List<TreeEntity> data, String id) {
        List<TreeEntity> tData = new ArrayList<>();
        for (TreeEntity datum : data) {
            if (datum.getPId().equals(id)) {
                tData.add(datum);
                datum.setChildNode(fun1(data, datum.getId()));
            }
        }
        return tData;
    }

    public static void fun2(List<TreeEntity> data) {
        Map<String, List<TreeEntity>> map = new HashMap<>();
        for (TreeEntity datum : data) {
            map.computeIfAbsent(datum.getPId(), k -> new ArrayList<>()).add(datum);
            datum.setChildNode(map.computeIfAbsent(datum.getId(), k -> new ArrayList<>()));
        }
    }

    public static void main(String[] args) {
        List<TreeEntity> data = initData();
        fun2(data);
    }


    public static List<TreeEntity> initData() {
        List<TreeEntity> data = new ArrayList<>();
        data.add(new TreeEntity("0", "1", "1"));
        data.add(new TreeEntity("1", "2", "2"));
        data.add(new TreeEntity("2", "3", "3"));
        data.add(new TreeEntity("3", "4", "4"));
        data.add(new TreeEntity("4", "5", "5"));
        data.add(new TreeEntity("5", "6", "6"));
        data.add(new TreeEntity("6", "7", "7"));
        data.add(new TreeEntity("7", "8", "8"));
        return data;
    }
}
