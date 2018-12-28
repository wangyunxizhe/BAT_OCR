package com.yuan.controller;

import com.yuan.utlis.Base64Util;
import com.yuan.utlis.FileUtil;
import com.yuan.utlis.HttpUtil;

import java.net.URLEncoder;

/**
 * Created by wangy on 2018/11/7.
 * <p>
 * 通用文字识别（高精度版）测试
 * 500次/日
 */
public class MyAccurate_basic {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 通用识别url
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";
        // 本地图片路径
        String filePath = "E:\\工作记录\\素材\\华泰5份章-images\\img18.jpg";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            String accessToken = "24.02ccc2925be77e63405fc9d2165af5da.2592000.1544164303.282335-14707581";
            String result = HttpUtil.post(otherHost, accessToken, params);
            System.out.println(result);
            System.out.println("耗时：" + (System.currentTimeMillis() - start) / 1000f + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
