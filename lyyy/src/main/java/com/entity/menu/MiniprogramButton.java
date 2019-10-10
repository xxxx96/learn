package com.entity.menu;

public class MiniprogramButton extends AbstractButton{
private String type="miniprogram";
private String url;
private String pagepath;

    public MiniprogramButton(String name, String url, String pagepath) {
        super(name);
        this.url = url;
        this.pagepath = pagepath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public String getType() {
        return type;
    }
}
