package com.util;

public class GetAccessToken {
    public static void main(String[] args) {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx039254b164898300&secret=221eda97d4150f61fba1521fef4c58be";
        url.replace("APPID","wx039254b164898300");
        url.replace("APPSECRET",GetToken.getAPPSECRET());
        System.out.println(url);
        String result = SendRequest.doGet(url);
        System.out.println(result);
    }
}
