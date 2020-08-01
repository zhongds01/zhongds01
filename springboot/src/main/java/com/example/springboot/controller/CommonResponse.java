package com.example.springboot.controller;

import java.util.Map;

/**
 * Description: 请求响应体封装类
 * Author: zhongds
 * Date : 2020/8/1 14:41
 */
public class CommonResponse {

    private static final String RESPONSE_OK = "0";

    private static final String RESPONSE_ERROR = "1";

    /**
     * 返回码
     * 0：成功
     * 1：异常
     */
    private String code;

    /**
     * 描述信息
     */
    private String desc;

    /**
     * 返回数据
     */
    private Map<String, String> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public CommonResponse(String code, String desc, Map<String, String> data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public CommonResponse() {
    }

    public CommonResponse(String code) {
        this.code = code;
    }

}
