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
}
