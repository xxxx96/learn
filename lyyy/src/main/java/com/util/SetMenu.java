package com.util;

import com.entity.menu.Button;
import com.entity.menu.ClickButton;
import com.entity.menu.SubButton;
import com.entity.menu.ViewButton;
import org.json.JSONObject;

public class SetMenu {
    public static void main(String[] args) {
        Button btn = new Button();
        btn.getButton().add(new ClickButton("一级点击","1"));
        btn.getButton().add(new ViewButton("一级点击","www.baidu.com"));
        SubButton subButton=new SubButton("一级菜单");
        btn.getButton().add(subButton);
        subButton.getSub_button().add(new ViewButton("百度","www.baidu.com"));
        JSONObject jsonObject = new JSONObject(btn);
        System.out.println(jsonObject.toString());
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=23_7LZfnlBNKiu-VkUqW-K78neHLPyYHlER6BtXloXSChciKtjAv-q5m11ZyoWDeh6OmKu7ThnjUJTXWFkCOKgvpVlSdEZkNNiXgE0oyAFHDGm98HTbimkn71QCYWD1l2R6xlCq6ZLZrQAn7HN2OAPcAJABNC";
        String res = SendRequest.doPost(url,jsonObject.toString());
        System.out.println(res);
    }
}
