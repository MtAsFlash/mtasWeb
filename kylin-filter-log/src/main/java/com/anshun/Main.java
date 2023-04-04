package com.anshun;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author mtasflash Created on ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) throws Exception {
        File rootPath = new File("D:\\filter_log\\logd\\");
        File[] list = rootPath.listFiles();
        if (list == null) {
            return;
        }
        for (File subPath : list) {
            if (subPath.isDirectory()) {
                File[] fileList = subPath.listFiles();
                if (fileList == null) {
                    continue;
                }
                LogFileProcess logFileProcess = new LogFileProcess();
                String slowOutPath = subPath.getPath() + "/" + "slow.txt";
                for (File file : fileList) {
                    if (file.getName().contains(".txt")) {
                        continue;
                    }
                    String inFilePath = file.getAbsolutePath();
                    String errorOutPath = file.getParent() + "/" + file.getName() + ".error.txt";
                    logFileProcess.startFilter(inFilePath, errorOutPath);
                }
                try (BufferedWriter slowWriter = Files.newBufferedWriter(Paths.get(slowOutPath))) {
                    logFileProcess.getSlowMap().forEach((caller, slowObject) -> {
                        String slowOutContent = caller +
                                "\t" +
                                slowObject.getMaxCost() +
                                "\t" +
                                slowObject.getSumCost() / slowObject.getCount() +
                                "\t" +
                                slowObject.getCount() +
                                "\t" +
                                slowObject.getMaxInfo();
                        try {
                            slowWriter.write(slowOutContent + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
        }
//        File file = new File("D:\\filter_log\\logd\\game\\");
//        String inFilePath = file.getAbsolutePath();
//        String slowOutPath = file.getParent() + "/" + file.getName() + ".slow.txt";
//        String errorOutPath = file.getParent() + "/" + file.getName() + ".error.txt";
//        LogFileProcess logFileProcess = new LogFileProcess();
//        logFileProcess.startFilter(inFilePath, slowOutPath, errorOutPath);
    }
}