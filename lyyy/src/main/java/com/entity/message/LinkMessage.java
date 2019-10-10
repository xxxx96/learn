package com.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;
@XStreamAlias("xml")
public class LinkMessage extends BaseMessage {
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Url")
    private String url;
    @XStreamAlias("Description")
    private String description;
    public LinkMessage(Map<String, String> requestMap,String title,String url,String description) {
        super(requestMap);
        this.setMsgType("location");
        this.title=title;
        this.description=description;
        this.url=url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
