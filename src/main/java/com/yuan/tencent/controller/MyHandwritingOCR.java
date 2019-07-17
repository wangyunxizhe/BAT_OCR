package com.yuan.tencent.controller;

import com.yuan.commonUtils.MyFileUtil;
import com.yuan.tencent.utlis.Credential;
import com.yuan.tencent.utlis.OcrClient;
import com.yuan.tencent.utlis.model.Coord;
import com.yuan.tencent.utlis.model.GeneralHandwritingOCRRequest;
import com.yuan.tencent.utlis.model.GeneralHandwritingOCRResponse;
import com.yuan.tencent.utlis.model.TextGeneralHandwriting;

/**
 * 腾讯手写识别
 */
public class MyHandwritingOCR {

    public static void main(String[] args) throws Exception {
        Credential credential = new Credential("AKIDLWl8OOhoSv8AycwPmqfGb3LitpCJq9pW",
                "iDW9WhdJo33mYeYLxLTjqj7IEyQlumQp");
        OcrClient ocrClient = new OcrClient(credential, "ap-shanghai");
        String base64 = MyFileUtil.encodeBase64File("E:\\工作记录\\素材\\OCR素材\\手写数字\\小写3.jpg");
        GeneralHandwritingOCRRequest ocrRequest = new GeneralHandwritingOCRRequest();
        ocrRequest.setImageBase64(base64);
        GeneralHandwritingOCRResponse ocrResponse = ocrClient.GeneralHandwritingOCR(ocrRequest);
        TextGeneralHandwriting[] tghs = ocrResponse.getTextDetections();
        for (int i = 0; i < tghs.length; i++) {
            String rs = "识别内容" + (i + 1) + "--->" + tghs[i].getDetectedText()
                    + " 可信度" + (i + 1) + "--->" + tghs[i].getConfidence() + " 文本行坐标" + (i + 1) + "--->";
            String position = "";
            Coord[] coords = tghs[i].getPolygon();
            for (int j = 0; j < coords.length; j++) {
                position += " X--->" + coords[j].getX() + " Y--->" + coords[j].getY();
            }
            rs = rs + position + " 扩展字段" + (i + 1) + "--->" + tghs[i].getAdvancedInfo();
            System.out.println(rs);
        }
    }

}
