package com.entity;

import org.springframework.stereotype.Component;

@Component
public class Result {
    private int code;
    private String result;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


}
