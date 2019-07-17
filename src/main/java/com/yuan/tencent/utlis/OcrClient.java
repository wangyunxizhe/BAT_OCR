/*
 * Copyright (c) 2017-2018 THL A29 Limited, a Tencent company. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yuan.tencent.utlis;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.yuan.tencent.utlis.exception.TencentCloudSDKException;
import com.yuan.tencent.utlis.model.*;
import com.yuan.tencent.utlis.profile.ClientProfile;

import java.lang.reflect.Type;

public class OcrClient extends AbstractClient {
    private static String endpoint = "ocr.tencentcloudapi.com";
    private static String version = "2018-11-19";

    /**
     * 构造client
     *
     * @param credential 认证信息实例
     * @param region     产品地域
     */
    public OcrClient(Credential credential, String region) {
        this(credential, region, new ClientProfile());
    }

    /**
     * 构造client
     *
     * @param credential 认证信息实例
     * @param region     产品地域
     * @param profile    配置实例
     */
    public OcrClient(Credential credential, String region, ClientProfile profile) {
        super(OcrClient.endpoint, OcrClient.version, credential, region, profile);
    }

    /**
     * 本接口支持图像英文文字的检测和识别，返回文字框位置与文字内容。
     * 支持多场景、任意版面下的英文、字母、数字和常见字符的识别，同时覆盖英文印刷体和英文手写体识别。
     *
     * @param req EnglishOCRRequest
     * @return EnglishOCRResponse
     * @throws TencentCloudSDKException
     */
    public EnglishOCRResponse EnglishOCR(EnglishOCRRequest req) throws TencentCloudSDKException {
        JsonResponseModel<EnglishOCRResponse> rsp = null;
        try {
            Type type = new TypeToken<JsonResponseModel<EnglishOCRResponse>>() {
            }.getType();
            rsp = gson.fromJson(this.internalRequest(req, "EnglishOCR"), type);
        } catch (JsonSyntaxException e) {
            throw new TencentCloudSDKException(e.getMessage());
        }
        return rsp.response;
    }

    /**
     * 本接口支持图像整体文字的检测和识别，返回文字框位置与文字内容。相比通用印刷体识别接口，准确率和召回率更高。
     *
     * @param req GeneralAccurateOCRRequest
     * @return GeneralAccurateOCRResponse
     * @throws TencentCloudSDKException
     */
    public GeneralAccurateOCRResponse GeneralAccurateOCR(GeneralAccurateOCRRequest req)
            throws TencentCloudSDKException {
        JsonResponseModel<GeneralAccurateOCRResponse> rsp = null;
        try {
            Type type = new TypeToken<JsonResponseModel<GeneralAccurateOCRResponse>>() {
            }.getType();
            rsp = gson.fromJson(this.internalRequest(req, "GeneralAccurateOCR"), type);
        } catch (JsonSyntaxException e) {
            throw new TencentCloudSDKException(e.getMessage());
        }
        return rsp.response;
    }

    /**
     * 本接口支持多场景、任意版面下整图文字的识别。支持自动识别语言类型，同时支持自选语言种类（推荐），
     * 除中英文外，支持日语、韩语、西班牙语、法语、德语、葡萄牙语、越南语、马来语、
     * 俄语、意大利语、荷兰语、瑞典语、芬兰语、丹麦语、挪威语、匈牙利语、泰语等多种语言。
     * 应用场景包括：印刷文档识别、网络图片识别、广告图文字识别、街景店招识别、菜单识别、视频标题识别、头像文字识别等。
     *
     * @param req GeneralBasicOCRRequest
     * @return GeneralBasicOCRResponse
     * @throws TencentCloudSDKException
     */
    public GeneralBasicOCRResponse GeneralBasicOCR(GeneralBasicOCRRequest req) throws TencentCloudSDKException {
        JsonResponseModel<GeneralBasicOCRResponse> rsp = null;
        try {
            Type type = new TypeToken<JsonResponseModel<GeneralBasicOCRResponse>>() {
            }.getType();
            rsp = gson.fromJson(this.internalRequest(req, "GeneralBasicOCR"), type);
        } catch (JsonSyntaxException e) {
            throw new TencentCloudSDKException(e.getMessage());
        }
        return rsp.response;
    }

    /**
     * 本接口支持图片中整体文字的检测和识别，返回文字框位置与文字内容。
     * 相比通用印刷体识别接口，识别速度更快、支持的 QPS 更高。
     *
     * @param req GeneralFastOCRRequest
     * @return GeneralFastOCRResponse
     * @throws TencentCloudSDKException
     */
    public GeneralFastOCRResponse GeneralFastOCR(GeneralFastOCRRequest req) throws TencentCloudSDKException {
        JsonResponseModel<GeneralFastOCRResponse> rsp = null;
        try {
            Type type = new TypeToken<JsonResponseModel<GeneralFastOCRResponse>>() {
            }.getType();
            rsp = gson.fromJson(this.internalRequest(req, "GeneralFastOCR"), type);
        } catch (JsonSyntaxException e) {
            throw new TencentCloudSDKException(e.getMessage());
        }
        return rsp.response;
    }

    /**
     * 本接口支持图片内手写体文字的检测和识别，针对手写字体无规则、字迹潦草、模糊等特点进行了识别能力的增强。
     *
     * @param req GeneralHandwritingOCRRequest
     * @return GeneralHandwritingOCRResponse
     * @throws TencentCloudSDKException
     */
    public GeneralHandwritingOCRResponse GeneralHandwritingOCR(GeneralHandwritingOCRRequest req)
            throws TencentCloudSDKException {
        JsonResponseModel<GeneralHandwritingOCRResponse> rsp = null;
        try {
            Type type = new TypeToken<JsonResponseModel<GeneralHandwritingOCRResponse>>() {
            }.getType();
            rsp = gson.fromJson(this.internalRequest(req, "GeneralHandwritingOCR"), type);
        } catch (JsonSyntaxException e) {
            throw new TencentCloudSDKException(e.getMessage());
        }
        return rsp.response;
    }

}
