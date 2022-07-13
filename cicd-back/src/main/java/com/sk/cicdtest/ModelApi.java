package com.sk.cicdtest;

public class ModelApi {

    public String msg;
    public int code;
    public String status;

    ModelApi(){}

    ModelApi(int code, String msg, String status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }



}
