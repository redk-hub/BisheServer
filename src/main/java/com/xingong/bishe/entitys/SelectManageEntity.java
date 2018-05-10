package com.xingong.bishe.entitys;

import javax.persistence.*;

/**
 * Created by zhang on 2018/4/23.
 */
@Entity
@Table(name = "select_manage", schema = "bishe", catalog = "")
public class SelectManageEntity {
    private String studentid;
    private Integer selectIspass;
    private String taskbookPath;
    private String topicid;
    private String studentname;
    private String major;
    private String studentphone;
    private String taskbookContent;
    private String taskbookTechnology;
    private String taskbookProcess;
    private String topicname;
    private String teacherid;
    private String teachername;
    private String taskbookWenxian;
    private Integer taskbookIsconfirm;

    @Id
    @Column(name = "studentid")
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "select_ispass")
    public Integer getSelectIspass() {
        return selectIspass;
    }

    public void setSelectIspass(Integer selectIspass) {
        this.selectIspass = selectIspass;
    }

    @Basic
    @Column(name = "taskbook_path")
    public String getTaskbookPath() {
        return taskbookPath;
    }

    public void setTaskbookPath(String taskbookPath) {
        this.taskbookPath = taskbookPath;
    }

    @Basic
    @Column(name = "topicid")
    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectManageEntity that = (SelectManageEntity) o;

        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (selectIspass != null ? !selectIspass.equals(that.selectIspass) : that.selectIspass != null) return false;
        if (taskbookPath != null ? !taskbookPath.equals(that.taskbookPath) : that.taskbookPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid != null ? studentid.hashCode() : 0;
        result = 31 * result + (selectIspass != null ? selectIspass.hashCode() : 0);
        result = 31 * result + (taskbookPath != null ? taskbookPath.hashCode() : 0);
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
    @Column(name = "major")
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "studentphone")
    public String getStudentphone() {
        return studentphone;
    }

    public void setStudentphone(String studentphone) {
        this.studentphone = studentphone;
    }

    @Basic
    @Column(name = "taskbook_content")
    public String getTaskbookContent() {
        return taskbookContent;
    }

    public void setTaskbookContent(String taskbookContent) {
        this.taskbookContent = taskbookContent;
    }

    @Basic
    @Column(name = "taskbook_technology")
    public String getTaskbookTechnology() {
        return taskbookTechnology;
    }

    public void setTaskbookTechnology(String taskbookTechnology) {
        this.taskbookTechnology = taskbookTechnology;
    }

    @Basic
    @Column(name = "taskbook_process")
    public String getTaskbookProcess() {
        return taskbookProcess;
    }

    public void setTaskbookProcess(String taskbookProcess) {
        this.taskbookProcess = taskbookProcess;
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
    @Column(name = "taskbook_wenxian")
    public String getTaskbookWenxian() {
        return taskbookWenxian;
    }

    public void setTaskbookWenxian(String taskbookWenxian) {
        this.taskbookWenxian = taskbookWenxian;
    }

    @Basic
    @Column(name = "taskbook_isconfirm")
    public Integer getTaskbookIsconfirm() {
        return taskbookIsconfirm;
    }

    public void setTaskbookIsconfirm(Integer taskbookIsconfirm) {
        this.taskbookIsconfirm = taskbookIsconfirm;
    }
}
