package com.anshun;

/**
 * @author mtasflash Created on ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String inFilePath = "./" + "runtime.log.2023-03-01";
        String slowOutPath = "./" + "slow" + (System.currentTimeMillis() / 1000) + ".txt";
        String errorOutPath = "./" + "error" + (System.currentTimeMillis() / 1000) + ".txt";
        LogFileProcess.startFilter(inFilePath, slowOutPath, errorOutPath);
    }
}