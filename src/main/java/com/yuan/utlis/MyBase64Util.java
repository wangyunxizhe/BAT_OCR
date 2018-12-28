package com.yuan.utlis;

import java.io.IOException;

/**
 * Created by wangy on 2018/11/7.
 */
public class MyBase64Util {

    public static void main(String[] args) throws IOException {
        String filePath = "E:\\工作记录\\素材\\华泰5份章\\华泰5份章_01.jpg";
        byte[] imgData = FileUtil.readFileByBytes(filePath);
        String imgStr = Base64Util.encode(imgData);
        System.out.println(imgStr);
    }

}
