package com.xingong.bishe.entitys;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by zhang on 2018/4/17.
 */
@Entity
@Table(name = "topic", schema = "bishe", catalog = "")
public class TopicEntity {
    private String topicid;
    private String topicname;
    private String topiccontent;
    private int topicstate;
    private String topicteacher;
    private Integer supplynum;
    private Integer alreadynum;
    private Date createtime;

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Id
    @Column(name = "topicid")
    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    @Basic
    @Column(name = "topicname")
    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    @Basic
    @Column(name = "topiccontent")
    public String getTopiccontent() {
        return topiccontent;
    }

    public void setTopiccontent(String topiccontent) {
        this.topiccontent = topiccontent;
    }

    @Basic
    @Column(name = "topicstate")
    public int getTopicstate() {
        return topicstate;
    }

    public void setTopicstate(int topicstate) {
        this.topicstate = topicstate;
    }

    @Basic
    @Column(name = "topicteacher")
    public String getTopicteacher() {
        return topicteacher;
    }

    public void setTopicteacher(String topicteacher) {
        this.topicteacher = topicteacher;
    }

    @Basic
    @Column(name = "supplynum")
    public Integer getSupplynum() {
        return supplynum;
    }

    public void setSupplynum(Integer supplynum) {
        this.supplynum = supplynum;
    }

    @Basic
    @Column(name = "alreadynum")
    public Integer getAlreadynum() {
        return alreadynum;
    }

    public void setAlreadynum(Integer alreadynum) {
        this.alreadynum = alreadynum;
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

        TopicEntity that = (TopicEntity) o;

        if (topicstate != that.topicstate) return false;
        if (topicid != null ? !topicid.equals(that.topicid) : that.topicid != null) return false;
        if (topicname != null ? !topicname.equals(that.topicname) : that.topicname != null) return false;
        if (topiccontent != null ? !topiccontent.equals(that.topiccontent) : that.topiccontent != null) return false;
        if (topicteacher != null ? !topicteacher.equals(that.topicteacher) : that.topicteacher != null) return false;
        if (supplynum != null ? !supplynum.equals(that.supplynum) : that.supplynum != null) return false;
        if (alreadynum != null ? !alreadynum.equals(that.alreadynum) : that.alreadynum != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = topicid != null ? topicid.hashCode() : 0;
        result = 31 * result + (topicname != null ? topicname.hashCode() : 0);
        result = 31 * result + (topiccontent != null ? topiccontent.hashCode() : 0);
        result = 31 * result + topicstate;
        result = 31 * result + (topicteacher != null ? topicteacher.hashCode() : 0);
        result = 31 * result + (supplynum != null ? supplynum.hashCode() : 0);
        result = 31 * result + (alreadynum != null ? alreadynum.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }
}
