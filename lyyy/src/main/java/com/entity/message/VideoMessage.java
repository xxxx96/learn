package com.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;
@XStreamAlias("xml")
public class VideoMessage extends BaseMessage{
    @XStreamAlias("MediaId")
    private String mediaId;
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public VideoMessage(Map<String, String> requestMap,String mediaId,String thumbMediaId) {
        super(requestMap);
        this.setMsgType("video");
        this.mediaId=mediaId;
        this.thumbMediaId=thumbMediaId;
    }
}
