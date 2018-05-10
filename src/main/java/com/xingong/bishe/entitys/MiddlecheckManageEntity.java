package com.xingong.bishe.entitys;

import javax.persistence.*;

/**
 * Created by zhang on 2018/4/23.
 */
@Entity
@Table(name = "middlecheck_manage", schema = "bishe", catalog = "")
public class MiddlecheckManageEntity {
    private String studentid;
    private String middlereportPath;
    private String studentname;
    private String teachername;
    private Integer groupid;
    private String teacherid;
    private Integer middlecheckIspass;
    private String middlecheckSuggest;
    private Integer middlecheckScore;
    private String topicname;

    @Id
    @Column(name = "studentid")
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "middlereport_path")
    public String getMiddlereportPath() {
        return middlereportPath;
    }

    public void setMiddlereportPath(String middlereportPath) {
        this.middlereportPath = middlereportPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiddlecheckManageEntity that = (MiddlecheckManageEntity) o;

        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (middlereportPath != null ? !middlereportPath.equals(that.middlereportPath) : that.middlereportPath != null)
            return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid != null ? studentid.hashCode() : 0;
        result = 31 * result + (middlereportPath != null ? middlereportPath.hashCode() : 0);
        return result;
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
    @Column(name = "teachername")
    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    @Basic
    @Column(name = "groupid")
    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
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
    @Column(name = "middlecheck_ispass")
    public Integer getMiddlecheckIspass() {
        return middlecheckIspass;
    }

    public void setMiddlecheckIspass(Integer middlecheckIspass) {
        this.middlecheckIspass = middlecheckIspass;
    }

    @Basic
    @Column(name = "middlecheck_suggest")
    public String getMiddlecheckSuggest() {
        return middlecheckSuggest;
    }

    public void setMiddlecheckSuggest(String middlecheckSuggest) {
        this.middlecheckSuggest = middlecheckSuggest;
    }

    @Basic
    @Column(name = "middlecheck_score")
    public Integer getMiddlecheckScore() {
        return middlecheckScore;
    }

    public void setMiddlecheckScore(Integer middlecheckScore) {
        this.middlecheckScore = middlecheckScore;
    }

    @Basic
    @Column(name = "topicname")
    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }
}
