package com.example.lenovo.week.bean;

/**
 * Created by lenovo on 2017/12/2.
 */

public class EventBean {
     String textview;
     String pic;

    public EventBean(String textview, String pic) {
        this.textview = textview;
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "EventBean{" +
                "textview='" + textview + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }

    public String getTextview() {
        return textview;
    }

    public void setTextview(String textview) {
        this.textview = textview;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
