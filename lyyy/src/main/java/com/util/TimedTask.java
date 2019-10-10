package com.util;



import com.entity.TokenResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.Date;
@Component
public class TimedTask {
    @Autowired
    private ServletContext servletContext;
    @Scheduled(fixedRate = 1000*60*60)
    public void initialDelay() {
        System.out.println("initialDelay>>>"+new Date());
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        url= url.replace("APPID",GetToken.getAPPID());
        url=url.replace("APPSECRET",GetToken.getAPPSECRET());
        System.out.println(url);
        String result = SendRequest.doGet(url);
       // System.out.println(result);
        JSONObject jsonObject= JSONObject.fromObject(result);
        TokenResult tokenResult=(TokenResult)JSONObject.toBean(jsonObject, TokenResult.class);
        System.out.println(tokenResult.getAccess_token());
        servletContext.setAttribute("token",tokenResult.getAccess_token());
    }

}
