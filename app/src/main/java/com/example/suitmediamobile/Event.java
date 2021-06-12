package com.example.suitmediamobile;

public class Event {
    public String cEventName, cEventTime;
    public Integer cEventImages;

    public Event(){

    }

    public Event(String cEventName, String cEventTime, Integer cEventImages) {
        this.cEventName = cEventName;
        this.cEventTime = cEventTime;
        this.cEventImages = cEventImages;
    }

    public String getcEventName() {
        return cEventName;
    }

    public Integer getcEventImages() {
        return cEventImages;
    }

    public void setcEventImages(Integer cEventImages) {
        this.cEventImages = cEventImages;
    }

    public void setcEventName(String cEventName) {
        this.cEventName = cEventName;
    }

    public String getcEventTime() {
        return cEventTime;
    }

    public void setcEventTime(String cEventTime) {
        this.cEventTime = cEventTime;
    }
}
