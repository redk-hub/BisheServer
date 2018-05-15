package com.xingong.bishe.entitys;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by zhang on 2018/4/23.
 */
@Entity
@Table(name = "defence_manage", schema = "bishe", catalog = "")
public class DefenceManageEntity {
    private String studentid;
    private String paperdraftPath;
    private Integer paperdraftIspass;
    private String paperdraftSuggest;
    private String paperfinalPath;
    private Integer paperfinalIspass;
    private String paperfinalSuggest;
    private Date defenceTime;
    private String topicname;
    private String studentname;
    private String teacherid;
    private String teachername;
    private String topicid;
    private String defenceLocation;
    private Integer groupid;

    @Id
    @Column(name = "studentid")
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "paperdraft_path")
    public String getPaperdraftPath() {
        return paperdraftPath;
    }

    public void setPaperdraftPath(String paperdraftPath) {
        this.paperdraftPath = paperdraftPath;
    }

    @Basic
    @Column(name = "paperdraft_ispass")
    public Integer getPaperdraftIspass() {
        return paperdraftIspass;
    }

    public void setPaperdraftIspass(Integer paperdraftIspass) {
        this.paperdraftIspass = paperdraftIspass;
    }

    @Basic
    @Column(name = "paperdraft_suggest")
    public String getPaperdraftSuggest() {
        return paperdraftSuggest;
    }

    public void setPaperdraftSuggest(String paperdraftSuggest) {
        this.paperdraftSuggest = paperdraftSuggest;
    }

    @Basic
    @Column(name = "paperfinal_path")
    public String getPaperfinalPath() {
        return paperfinalPath;
    }

    public void setPaperfinalPath(String paperfinalPath) {
        this.paperfinalPath = paperfinalPath;
    }

    @Basic
    @Column(name = "paperfinal_ispass")
    public Integer getPaperfinalIspass() {
        return paperfinalIspass;
    }

    public void setPaperfinalIspass(Integer paperfinalIspass) {
        this.paperfinalIspass = paperfinalIspass;
    }

    @Basic
    @Column(name = "paperfinal_suggest")
    public String getPaperfinalSuggest() {
        return paperfinalSuggest;
    }

    public void setPaperfinalSuggest(String paperfinalSuggest) {
        this.paperfinalSuggest = paperfinalSuggest;
    }

    @Basic
    @Column(name = "defence_time")
    public Date getDefenceTime() {
        return defenceTime;
    }

    public void setDefenceTime(Date defenceTime) {
        this.defenceTime = defenceTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefenceManageEntity that = (DefenceManageEntity) o;

        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (paperdraftPath != null ? !paperdraftPath.equals(that.paperdraftPath) : that.paperdraftPath != null)
            return false;
        if (paperdraftIspass != null ? !paperdraftIspass.equals(that.paperdraftIspass) : that.paperdraftIspass != null)
            return false;
        if (paperdraftSuggest != null ? !paperdraftSuggest.equals(that.paperdraftSuggest) : that.paperdraftSuggest != null)
            return false;
        if (paperfinalPath != null ? !paperfinalPath.equals(that.paperfinalPath) : that.paperfinalPath != null)
            return false;
        if (paperfinalIspass != null ? !paperfinalIspass.equals(that.paperfinalIspass) : that.paperfinalIspass != null)
            return false;
        if (paperfinalSuggest != null ? !paperfinalSuggest.equals(that.paperfinalSuggest) : that.paperfinalSuggest != null)
            return false;
        if (defenceTime != null ? !defenceTime.equals(that.defenceTime) : that.defenceTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid != null ? studentid.hashCode() : 0;
        result = 31 * result + (paperdraftPath != null ? paperdraftPath.hashCode() : 0);
        result = 31 * result + (paperdraftIspass != null ? paperdraftIspass.hashCode() : 0);
        result = 31 * result + (paperdraftSuggest != null ? paperdraftSuggest.hashCode() : 0);
        result = 31 * result + (paperfinalPath != null ? paperfinalPath.hashCode() : 0);
        result = 31 * result + (paperfinalIspass != null ? paperfinalIspass.hashCode() : 0);
        result = 31 * result + (paperfinalSuggest != null ? paperfinalSuggest.hashCode() : 0);
        result = 31 * result + (defenceTime != null ? defenceTime.hashCode() : 0);
        return result;
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
    @Column(name = "studentname")
    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
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
    @Column(name = "topicid")
    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    @Basic
    @Column(name = "defence_location")
    public String getDefenceLocation() {
        return defenceLocation;
    }

    public void setDefenceLocation(String defenceLocation) {
        this.defenceLocation = defenceLocation;
    }

    @Basic
    @Column(name = "groupid")
    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }
}
