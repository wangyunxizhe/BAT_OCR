package com.yuan.controller;

import org.apache.sanselan.ImageInfo;
import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.Sanselan;

import java.io.*;

/**
 * Created by wangy on 2018/11/15.
 */
public class ImgDpi {

    public static byte[] File2byte(File file) {
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static void main(String[] args) throws IOException, ImageReadException {
        File img = new File("E:\\工作记录\\素材\\test2.jpg");
        byte[] imgbyte = File2byte(img);
//        ImageInfo imageInfo = Sanselan.getImageInfo(img);
        ImageInfo imageInfo = Sanselan.getImageInfo(imgbyte);
        int wdpi = imageInfo.getPhysicalWidthDpi();
        System.out.println("WidthDpi=====" + wdpi);
        int hdpi = imageInfo.getPhysicalHeightDpi();
        System.out.println("HeightDpi=====" + hdpi);
    }

}
