package com.example.lenovo.week.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public  class ChildListBean {
                /**
                 * airTime : 0
                 * duration :
                 * loadType : html
                 * score : 0
                 * angleIcon :
                 * dataId :
                 * description :
                 * loadURL : http://www.iqiyi.com/v_19rrefck18.html
                 * shareURL :
                 * pic : http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/11/28/1511855662282067261.jpg
                 * title : 《大明锦衣卫2》应昊茗、修杰楷首次对决
                 * roomId :
                 */
                @Id(autoincrement = true)
                private Long iid;
                private int airTime;
                private String duration;
                private String loadType;
                private int score;
                private String angleIcon;
                private String dataId;
                private String description;
                private String loadURL;
                private String shareURL;
                private String pic;
                private String title;
                private String roomId;

                @Generated(hash = 1499907890)
                public ChildListBean(Long iid, int airTime, String duration, String loadType, int score, String angleIcon,
                        String dataId, String description, String loadURL, String shareURL, String pic, String title,
                        String roomId) {
                    this.iid = iid;
                    this.airTime = airTime;
                    this.duration = duration;
                    this.loadType = loadType;
                    this.score = score;
                    this.angleIcon = angleIcon;
                    this.dataId = dataId;
                    this.description = description;
                    this.loadURL = loadURL;
                    this.shareURL = shareURL;
                    this.pic = pic;
                    this.title = title;
                    this.roomId = roomId;
                }

                @Generated(hash = 1320755235)
                public ChildListBean() {
                }

                public int getAirTime() {
                    return airTime;
                }

                public void setAirTime(int airTime) {
                    this.airTime = airTime;
                }

                public String getDuration() {
                    return duration;
                }

                public void setDuration(String duration) {
                    this.duration = duration;
                }

                public String getLoadType() {
                    return loadType;
                }

                public void setLoadType(String loadType) {
                    this.loadType = loadType;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public String getAngleIcon() {
                    return angleIcon;
                }

                public void setAngleIcon(String angleIcon) {
                    this.angleIcon = angleIcon;
                }

                public String getDataId() {
                    return dataId;
                }

                public void setDataId(String dataId) {
                    this.dataId = dataId;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getLoadURL() {
                    return loadURL;
                }

                public void setLoadURL(String loadURL) {
                    this.loadURL = loadURL;
                }

                public String getShareURL() {
                    return shareURL;
                }

                public void setShareURL(String shareURL) {
                    this.shareURL = shareURL;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getRoomId() {
                    return roomId;
                }

                public void setRoomId(String roomId) {
                    this.roomId = roomId;
                }

                public Long getIid() {
                    return this.iid;
                }

                public void setIid(Long iid) {
                    this.iid = iid;
                }
            }