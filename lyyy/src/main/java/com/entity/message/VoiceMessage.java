package com.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;
@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage{
    @XStreamAlias("MediaId")
    private String mediaId;
    @XStreamAlias("Format")
    private String format;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public VoiceMessage(Map<String, String> requestMap, String mediaId, String format) {
        super(requestMap);
        this.setMsgType("voice");
        this.mediaId=mediaId;
        this.format=format;
    }
}
