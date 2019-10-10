package com.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;
@XStreamAlias("xml")
public class LocationMessage extends BaseMessage {
    @XStreamAlias("Location_X")
    private String location_X;
    @XStreamAlias("Location_Y")
    private String location_Y;
    @XStreamAlias("Scale")
    private String scale;
    @XStreamAlias("Label")
    private String label;
    public LocationMessage(Map<String, String> requestMap,String location_X,String location_Y,String scale,String label) {
        super(requestMap);
        this.location_X=location_X;
        this.location_Y=location_Y;
        this.scale=scale;
        this.label=label;
    }
}
