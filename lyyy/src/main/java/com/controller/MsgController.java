package com.controller;

import com.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RestController
public class MsgController {
    @Autowired
    private MsgService msgService;
    @RequestMapping("/msg")
        Void home(HttpServletRequest request, @RequestParam(required = false) String echostr, @RequestParam(required = false) String signature, @RequestParam(required = false) String timestamp, @RequestParam(required =false) String nonce, HttpServletResponse response) {
            System.out.println("get");
            System.out.println(echostr);
            System.out.println(signature);
            System.out.println(timestamp);
            System.out.println(nonce);
            //校验证请求
        if(msgService.check(signature,timestamp,nonce)){
            try{
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.flush();
                out.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
            return null;
        }
    @RequestMapping(value = "/msg",method = RequestMethod.POST)
    String reply(HttpServletRequest request)throws IOException{

            Map<String, String> requestMap = msgService.parseRequest(request.getInputStream());
            System.out.println(requestMap);
            String respone = msgService.getRespone(requestMap);

            return respone;

    }

}
