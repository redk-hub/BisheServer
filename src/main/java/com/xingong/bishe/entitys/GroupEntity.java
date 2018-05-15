package com.xingong.bishe.entitys;

import java.util.Date;
import java.util.List;

/**
 * Created by zhang on 2018/5/10.
 */
public class GroupEntity {
    private int groupid;
    private List<String> grouplist;
    private String location;
    private Date time;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public List<String> getGrouplist() {
        return grouplist;
    }

    public void setGrouplist(List<String> grouplist) {
        this.grouplist = grouplist;
    }
}
