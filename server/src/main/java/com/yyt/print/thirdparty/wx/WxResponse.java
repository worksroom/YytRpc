package com.yyt.print.thirdparty.wx;

/**
 * Created by leo on 2017/2/7.
 */
public class WxResponse {

    private int code;// 状态码
    private String text;// 状态描述

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
