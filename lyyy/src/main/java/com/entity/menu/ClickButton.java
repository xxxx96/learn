package com.entity.menu;

public class ClickButton extends AbstractButton{
    private String type="click";
    private String key;
    public ClickButton(String name,String key) {
        super(name);
        this.key=key;
    }

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
