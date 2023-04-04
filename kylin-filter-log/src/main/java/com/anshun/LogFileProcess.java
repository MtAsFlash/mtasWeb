package com.anshun;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author mtasflash Created on 2023/3/16 16:39
 */
public class LogFileProcess {
    @Getter
    @Setter
    static class SlowObject {
        private long sumCost;
        private int maxCost;
        private int count;
        /**
         * 耗时最大的那一条日志详情
         */
        private String maxInfo;

        public void put(LogEntity entity, Integer cost) {
            sumCost += cost;
            if (cost > maxCost) {
                maxCost = cost;
                maxInfo = entity.getInfo();
            }
            count++;
        }
    }

    public final Set<String> errorSet = new HashSet<>();
    /**
     * slow总值
     */
    @Getter
    private final Map<String, SlowObject> slowMap = new HashMap<>();


    public static final String slowFlag = "cost=";
    public static final String callerFlag = "caller=";

    /**
     * 开始筛日志
     *
     * @param inPath       输入的文件目录
     * @param errorOutPath 筛选的错误日志输出位置
     */
    public void startFilter(String inPath, String errorOutPath) throws IOException {
        try (Stream<String> inStream = Files.lines(Paths.get(inPath));
             BufferedWriter errorWriter = Files.newBufferedWriter(Paths.get(errorOutPath))) {
            inStream.forEachOrdered(line -> {
                filter(line, errorWriter);
            });
        }
    }

    public void filter(String line, BufferedWriter errorWriter) {
        LogEntity logEntity = LogEntity.build(line);
        if (logEntity == null) {
            return;
        }
        if (logEntity.getType().equals(LogType.ERROR.getType())) {
            filterError(logEntity, errorWriter);
        } else {
//            filterSlow(logEntity);
        }
    }

    public void filterError(LogEntity entity, BufferedWriter errorWriter) {
        String key = entity.getClassName();
        // 输出到错误日志文件
        if (errorSet.contains(key)) {
            // 如果已经存过一次,且属于不需要重复记录的非重要日志项,则跳过
            return;
        }
        try {
            errorWriter.write(entity + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        errorSet.add(key);
    }

    public void filterSlow(LogEntity entity) {
        String info = entity.getInfo();
        Pair<String, Integer> slowLog = parseSlowLog(info);
        if (slowLog == null) {
            return;
        }
        String caller = slowLog.getKey();
        Integer cost = slowLog.getValue();
        slowMap.computeIfAbsent(caller, k -> new SlowObject()).put(entity, cost);
    }

    public Pair<String, Integer> parseSlowLog(String str) {
        int indexOf = str.indexOf(slowFlag);
        if (indexOf > -1) {
            String sub1 = str.substring(indexOf + slowFlag.length());
            int costEnd = sub1.indexOf(",");
            if (costEnd < 0) {
                System.out.println("parseSlowLog error:data=" + str);
                return null;
            }
            String cost = sub1.substring(0, costEnd);
            String sub2 = sub1.substring(sub1.indexOf(callerFlag) + callerFlag.length());
            int callerEnd = sub2.indexOf(",");
            String caller = sub2.substring(0, callerEnd > -1 ? callerEnd : sub2.length());
            cost = cost.replace("ms", "");
            if (!StringUtils.isNumeric(cost)) {
                System.out.println("parseSlowLog error:data=" + str);
                return null;
            }
            return new Pair<>(caller, Integer.valueOf(cost));
        }
        return null;
    }
}
