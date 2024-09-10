package com.scmoanno.scmoanno.utils;

public class FileUtils {

    public static boolean isH5File(String fileName) {
        // 将文件名转换为小写以进行不区分大小写的比较
        String lowerCaseFileName = fileName.toLowerCase();
        // 检查文件名是否以.h5结尾
        return lowerCaseFileName.endsWith(".h5");
    }

    public static boolean isH5adFile(String fileName) {
        // 将文件名转换为小写以进行不区分大小写的比较
        String lowerCaseFileName = fileName.toLowerCase();
        // 检查文件名是否以.h5结尾
        return lowerCaseFileName.endsWith(".h5ad");
    }

    public static boolean isCsvFile(String fileName) {
        // 将文件名转换为小写以进行不区分大小写的比较
        String lowerCaseFileName = fileName.toLowerCase();
        // 检查文件名是否以.h5结尾
        return lowerCaseFileName.endsWith(".csv");
    }
    // 其他文件处理相关的工具方法...
}
