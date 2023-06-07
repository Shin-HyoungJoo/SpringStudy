package com.example.demo.utils;

import java.util.UUID;

public class FileUtils {
    public static String getExt(String fileNm) {
        return fileNm.substring(fileNm.lastIndexOf(".")+1);
    }

    public static String getFileNm(String fileNm) {
        return fileNm.substring(0,fileNm.lastIndexOf("."));
    }

    public static String makeRandomFileNm(String fileNm) {
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + FileUtils.getExt(fileNm);
    }
}
