import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        
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
