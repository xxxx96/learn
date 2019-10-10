package com.service;

import java.io.InputStream;
import java.util.Map;

public interface MsgService {
     boolean check(String signature,String timestamp,String nonce);
     Map<String,String> parseRequest(InputStream is);
     String getRespone(Map<String,String> requestMap);

}
