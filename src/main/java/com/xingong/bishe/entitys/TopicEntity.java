package com.xingong.bishe.entitys;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by zhang on 2018/5/3.
 */
@Entity
@Table(name = "topic", schema = "bishe", catalog = "")
public class TopicEntity {
    private String topicid;
    private String topicname;
    private String topiccontent;
    private Integer topicstate;
    private Integer supplynum;
    private Integer alreadynum;
    private Date createtime;
    private String teacherid;
    private String teachername;
    private String topictype;
    private String topicsource;
    private String teacherphone;
    private Integer shiji;
    private String target;
    private String schedule;
    private Integer collegeid;
    private String collegename;
    private String major;

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
    public Integer getTopicstate() {
        return topicstate;
    }

    public void setTopicstate(Integer topicstate) {
        this.topicstate = topicstate;
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

    @Basic
    @Column(name = "teacherid")
    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    @Basic
    @Column(name = "teachername")
    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    @Basic
    @Column(name = "topictype")
    public String getTopictype() {
        return topictype;
    }

    public void setTopictype(String topictype) {
        this.topictype = topictype;
    }

    @Basic
    @Column(name = "topicsource")
    public String getTopicsource() {
        return topicsource;
    }

    public void setTopicsource(String topicsource) {
        this.topicsource = topicsource;
    }

    @Basic
    @Column(name = "teacherphone")
    public String getTeacherphone() {
        return teacherphone;
    }

    public void setTeacherphone(String teacherphone) {
        this.teacherphone = teacherphone;
    }

    @Basic
    @Column(name = "shiji")
    public Integer getShiji() {
        return shiji;
    }

    public void setShiji(Integer shiji) {
        this.shiji = shiji;
    }

    @Basic
    @Column(name = "target")
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Basic
    @Column(name = "schedule")
    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Basic
    @Column(name = "collegeid")
    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    @Basic
    @Column(name = "collegename")
    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    @Basic
    @Column(name = "major")
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopicEntity that = (TopicEntity) o;

        if (topicid != null ? !topicid.equals(that.topicid) : that.topicid != null) return false;
        if (topicname != null ? !topicname.equals(that.topicname) : that.topicname != null) return false;
        if (topiccontent != null ? !topiccontent.equals(that.topiccontent) : that.topiccontent != null) return false;
        if (topicstate != null ? !topicstate.equals(that.topicstate) : that.topicstate != null) return false;
        if (supplynum != null ? !supplynum.equals(that.supplynum) : that.supplynum != null) return false;
        if (alreadynum != null ? !alreadynum.equals(that.alreadynum) : that.alreadynum != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;
        if (teacherid != null ? !teacherid.equals(that.teacherid) : that.teacherid != null) return false;
        if (teachername != null ? !teachername.equals(that.teachername) : that.teachername != null) return false;
        if (topictype != null ? !topictype.equals(that.topictype) : that.topictype != null) return false;
        if (topicsource != null ? !topicsource.equals(that.topicsource) : that.topicsource != null) return false;
        if (teacherphone != null ? !teacherphone.equals(that.teacherphone) : that.teacherphone != null) return false;
        if (shiji != null ? !shiji.equals(that.shiji) : that.shiji != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;
        if (schedule != null ? !schedule.equals(that.schedule) : that.schedule != null) return false;
        if (collegeid != null ? !collegeid.equals(that.collegeid) : that.collegeid != null) return false;
        if (collegename != null ? !collegename.equals(that.collegename) : that.collegename != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = topicid != null ? topicid.hashCode() : 0;
        result = 31 * result + (topicname != null ? topicname.hashCode() : 0);
        result = 31 * result + (topiccontent != null ? topiccontent.hashCode() : 0);
        result = 31 * result + (topicstate != null ? topicstate.hashCode() : 0);
        result = 31 * result + (supplynum != null ? supplynum.hashCode() : 0);
        result = 31 * result + (alreadynum != null ? alreadynum.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (teacherid != null ? teacherid.hashCode() : 0);
        result = 31 * result + (teachername != null ? teachername.hashCode() : 0);
        result = 31 * result + (topictype != null ? topictype.hashCode() : 0);
        result = 31 * result + (topicsource != null ? topicsource.hashCode() : 0);
        result = 31 * result + (teacherphone != null ? teacherphone.hashCode() : 0);
        result = 31 * result + (shiji != null ? shiji.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        result = 31 * result + (collegeid != null ? collegeid.hashCode() : 0);
        result = 31 * result + (collegename != null ? collegename.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        return result;
    }
}
