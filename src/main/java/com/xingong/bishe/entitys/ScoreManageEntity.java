package com.xingong.bishe.entitys;

import javax.persistence.*;

/**
 * Created by zhang on 2018/4/23.
 */
@Entity
@Table(name = "score_manage", schema = "bishe", catalog = "")
public class ScoreManageEntity {
    private String studentid;
    private Integer totalscore;
    private Integer defencescore;
    private Integer paperscore;
    private String studentname;
    private String topicname;
    private String topicid;
    private String teacherid;
    private Integer isrecommend;

    @Id
    @Column(name = "studentid")
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "totalscore")
    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreManageEntity that = (ScoreManageEntity) o;

        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (totalscore != null ? !totalscore.equals(that.totalscore) : that.totalscore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid != null ? studentid.hashCode() : 0;
        result = 31 * result + (totalscore != null ? totalscore.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "defencescore")
    public Integer getDefencescore() {
        return defencescore;
    }

    public void setDefencescore(Integer defencescore) {
        this.defencescore = defencescore;
    }

    @Basic
    @Column(name = "paperscore")
    public Integer getPaperscore() {
        return paperscore;
    }

    public void setPaperscore(Integer paperscore) {
        this.paperscore = paperscore;
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
    @Column(name = "topicname")
    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
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
    @Column(name = "teacherid")
    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    @Basic
    @Column(name = "isrecommend")
    public Integer getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(Integer isrecommend) {
        this.isrecommend = isrecommend;
    }
}
