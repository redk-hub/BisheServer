package com.xingong.bishe.entitys;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhang on 2018/4/17.
 */
@Entity
@Table(name = "notice", schema = "bishe", catalog = "")
public class NoticeEntity {
    private String noticid;
    private String userid;
    private Date createtime;
    private String noticetitle;
    private String username;
    private String noticecontent;

    @Id
    @Column(name = "noticid")
    public String getNoticid() {
        return noticid;
    }

    public void setNoticid(String noticid) {
        this.noticid = noticid;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "createtime")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoticeEntity that = (NoticeEntity) o;

        if (noticid != null ? !noticid.equals(that.noticid) : that.noticid != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noticid != null ? noticid.hashCode() : 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "noticetitle")
    public String getNoticetitle() {
        return noticetitle;
    }

    public void setNoticetitle(String noticetitle) {
        this.noticetitle = noticetitle;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "noticecontent")
    public String getNoticecontent() {
        return noticecontent;
    }

    public void setNoticecontent(String noticecontent) {
        this.noticecontent = noticecontent;
    }
}
