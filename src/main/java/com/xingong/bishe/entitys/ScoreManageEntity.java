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
}
