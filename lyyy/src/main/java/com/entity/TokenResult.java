package com.entity;

public class TokenResult {
    private String access_token;
    private Integer expire_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpire_in() {
        return expire_in;
    }

    public void setExpire_in(Integer expire_in) {
        this.expire_in = expire_in;
    }
}
