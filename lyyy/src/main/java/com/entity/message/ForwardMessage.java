package com.entity.message;

import java.util.Map;

public class ForwardMessage extends BaseMessage{


    public ForwardMessage(Map<String, String> requestMap) {
        super(requestMap);
        this.setMsgType("transfer_customer_service");
    }
}
