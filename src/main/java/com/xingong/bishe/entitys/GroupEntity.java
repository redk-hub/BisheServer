package com.xingong.bishe.entitys;

import java.util.List;

/**
 * Created by zhang on 2018/5/10.
 */
public class GroupEntity {
    private int groupid;
    private List<String> grouplist;

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
