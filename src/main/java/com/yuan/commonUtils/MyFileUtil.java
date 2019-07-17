package com.yuan.commonUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyFileUtil {

    /**
     * 将文件转成base64 字符串
     */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }

    /**
     * 将base64字符解码保存文件
     */
    public static void decoderBase64File(String base64Code, String targetPath) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

    /**
     * 将base64字符保存文本文件
     */
    public static void toFile(String base64Code, String targetPath) throws Exception {
        byte[] buffer = base64Code.getBytes();
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

    public static void main(String[] args) {
        try {
            String base64Code = encodeBase64File("E:\\工作记录\\素材\\test.jpg");
            System.out.println(base64Code);
            decoderBase64File(base64Code, "E:\\工作记录\\素材\\test_1.jpg");
            toFile(base64Code, "E:\\工作记录\\素材\\test.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
