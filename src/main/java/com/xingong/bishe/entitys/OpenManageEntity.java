package com.xingong.bishe.entitys;

import javax.persistence.*;

/**
 * Created by zhang on 2018/4/23.
 */
@Entity
@Table(name = "open_manage", schema = "bishe", catalog = "")
public class OpenManageEntity {
    private String studentid;
    private String openreportPath;
    private Integer openreportIspass;
    private String openreportSuggest;
    private String wenxianPath;
    private Integer wenxianIspass;
    private String wenxianSuggest;
    private String studentname;
    private String topicname;
    private Integer wenxianScore;
    private Integer openreportScore;
    private String teacherid;
    private String teachername;

    @Id
    @Column(name = "studentid")
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "openreport_path")
    public String getOpenreportPath() {
        return openreportPath;
    }

    public void setOpenreportPath(String openreportPath) {
        this.openreportPath = openreportPath;
    }

    @Basic
    @Column(name = "openreport_ispass")
    public Integer getOpenreportIspass() {
        return openreportIspass;
    }

    public void setOpenreportIspass(Integer openreportIspass) {
        this.openreportIspass = openreportIspass;
    }

    @Basic
    @Column(name = "openreport_suggest")
    public String getOpenreportSuggest() {
        return openreportSuggest;
    }

    public void setOpenreportSuggest(String openreportSuggest) {
        this.openreportSuggest = openreportSuggest;
    }

    @Basic
    @Column(name = "wenxian_path")
    public String getWenxianPath() {
        return wenxianPath;
    }

    public void setWenxianPath(String wenxianPath) {
        this.wenxianPath = wenxianPath;
    }

    @Basic
    @Column(name = "wenxian_ispass")
    public Integer getWenxianIspass() {
        return wenxianIspass;
    }

    public void setWenxianIspass(Integer wenxianIspass) {
        this.wenxianIspass = wenxianIspass;
    }

    @Basic
    @Column(name = "wenxian_suggest")
    public String getWenxianSuggest() {
        return wenxianSuggest;
    }

    public void setWenxianSuggest(String wenxianSuggest) {
        this.wenxianSuggest = wenxianSuggest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpenManageEntity that = (OpenManageEntity) o;

        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (openreportPath != null ? !openreportPath.equals(that.openreportPath) : that.openreportPath != null)
            return false;
        if (openreportIspass != null ? !openreportIspass.equals(that.openreportIspass) : that.openreportIspass != null)
            return false;
        if (openreportSuggest != null ? !openreportSuggest.equals(that.openreportSuggest) : that.openreportSuggest != null)
            return false;
        if (wenxianPath != null ? !wenxianPath.equals(that.wenxianPath) : that.wenxianPath != null) return false;
        if (wenxianIspass != null ? !wenxianIspass.equals(that.wenxianIspass) : that.wenxianIspass != null)
            return false;
        if (wenxianSuggest != null ? !wenxianSuggest.equals(that.wenxianSuggest) : that.wenxianSuggest != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid != null ? studentid.hashCode() : 0;
        result = 31 * result + (openreportPath != null ? openreportPath.hashCode() : 0);
        result = 31 * result + (openreportIspass != null ? openreportIspass.hashCode() : 0);
        result = 31 * result + (openreportSuggest != null ? openreportSuggest.hashCode() : 0);
        result = 31 * result + (wenxianPath != null ? wenxianPath.hashCode() : 0);
        result = 31 * result + (wenxianIspass != null ? wenxianIspass.hashCode() : 0);
        result = 31 * result + (wenxianSuggest != null ? wenxianSuggest.hashCode() : 0);
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
    @Column(name = "topicname")
    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    @Basic
    @Column(name = "wenxian_score")
    public Integer getWenxianScore() {
        return wenxianScore;
    }

    public void setWenxianScore(Integer wenxianScore) {
        this.wenxianScore = wenxianScore;
    }

    @Basic
    @Column(name = "openreport_score")
    public Integer getOpenreportScore() {
        return openreportScore;
    }

    public void setOpenreportScore(Integer openreportScore) {
        this.openreportScore = openreportScore;
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
}
