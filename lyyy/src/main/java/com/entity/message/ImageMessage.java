package com.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage{
    @XStreamAlias("MediaId")
    private String mediaId;
    @XStreamAlias("PicUrl")
    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public ImageMessage(Map<String, String> requestMap,String mediaId,String picUrl)
    {
        super(requestMap);
        this.setMsgType("image");
        this.mediaId=mediaId;
        this.picUrl=picUrl;
    }
}
