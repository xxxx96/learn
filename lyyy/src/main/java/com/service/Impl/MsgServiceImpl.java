package com.service.Impl;

import com.entity.message.*;
import com.service.MsgService;
import com.thoughtworks.xstream.XStream;
import com.util.GetToken;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MsgServiceImpl implements MsgService {

    @Override
    public boolean check( String signature, String timestamp, String nonce) {
        //1)将token,timestamp,nonce三个参数进行字典排序
        String[] strs= new String[] {GetToken.getTOKEN(),timestamp,nonce};
        Arrays.sort(strs);
        //2)将三个字段排序并拼接成一个字段用sha1加密
        String str = strs[0]+strs[1]+strs[2];
        String res = sha1(str);
        System.out.println(res);
        System.out.println(signature);
        //3)输出结果
        if(res.equals(signature)){
            System.out.println("成功");
            return true;
        }else {
            System.out.println("失败");
        }
        return false;
    }

    @Override
    public Map<String, String> parseRequest(InputStream is) {
        SAXReader reader = new SAXReader();
        HashMap map = new HashMap();
        try {
            //读取输入流，获取文档对象
            Document document = reader.read(is);
            //根据文档对象获取
            Element root = document.getRootElement();
            //获取所有根结点的子节点
            List<Element> elements = root.elements();
            for(Element e:elements){
                map.put(e.getName(),e.getStringValue());
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public String getRespone(Map<String, String> requestMap) {
        BaseMessage msg=null;
        switch (requestMap.get("MsgType")){
            case "text":
            msg=dealTextMsg(requestMap);
                break;
            case "image":
            msg=dealImageMsg(requestMap);
                break;
            case "voice":

            case "video":

            case "shortvideo":
            default:
                msg=dealOtherMsg(requestMap);
                break;
        }
        XStream stream = new XStream();
        //添加xml别名
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(LinkMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        stream.processAnnotations(TextMessage.class);
        System.out.println(msg);
        String xml = stream.toXML(msg);
        System.out.println(xml);
        return xml;
    }

    private BaseMessage dealOtherMsg(Map<String, String> requestMap) {
        TextMessage tx = new TextMessage(requestMap,"暂不支持转发该类信息");
        return tx;
    }

    private BaseMessage dealImageMsg(Map<String, String> requestMap) {
        ForwardMessage fm = new ForwardMessage(requestMap);
        fm.setFromUserName(requestMap.get("ToUserName"));
        fm.setToUserName(requestMap.get("FromUserName"));
        return fm;
    }

    private BaseMessage dealTextMsg(Map<String, String> requestMap) {
        ForwardMessage fm = new ForwardMessage(requestMap);
        fm.setFromUserName(requestMap.get("ToUserName"));
        fm.setToUserName(requestMap.get("FromUserName"));
        return fm;
    }

    private String sha1(String src) {
        StringBuilder sb =new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("sha1");
            byte[] digest=md.digest(src.getBytes());
            char[] chars={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f',};
            for(byte b:digest){
            sb.append(chars[(b>>4)&15]);
            sb.append(chars[b&15]);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
