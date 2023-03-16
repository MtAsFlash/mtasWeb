package com.anshun;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mtasflash Created on 2023/3/16 18:02
 */
@Getter
@Setter
public class LogEntity {
    private String dateTime;
    private String type;
    private String threadName;
    private String className;
    private String info;

    private LogEntity() {
    }

    public static LogEntity build(String line) {
        LogEntity logEntity = new LogEntity();
        String[] split = line.split("\\|");
        if (split.length >= 5) {
            logEntity.dateTime = split[0];
            logEntity.type = split[1];
            logEntity.threadName = split[2];
            logEntity.className = split[3];
            logEntity.info = split[4];
            return logEntity;
        } else {
            System.out.println("parse failed,data=" + line);
            return null;
        }
    }

    @Override
    public String toString() {
        return this.dateTime +
                "\t" +
                this.type +
                "\t" +
                this.threadName +
                "\t" +
                this.className +
                "\t" +
                this.info;
    }
}
