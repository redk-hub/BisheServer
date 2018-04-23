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
    private Integer middlereportIspass;
    private String middlereportSuggest;

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

    @Basic
    @Column(name = "middlereport_ispass")
    public Integer getMiddlereportIspass() {
        return middlereportIspass;
    }

    public void setMiddlereportIspass(Integer middlereportIspass) {
        this.middlereportIspass = middlereportIspass;
    }

    @Basic
    @Column(name = "middlereport_suggest")
    public String getMiddlereportSuggest() {
        return middlereportSuggest;
    }

    public void setMiddlereportSuggest(String middlereportSuggest) {
        this.middlereportSuggest = middlereportSuggest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiddlecheckManageEntity that = (MiddlecheckManageEntity) o;

        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (middlereportPath != null ? !middlereportPath.equals(that.middlereportPath) : that.middlereportPath != null)
            return false;
        if (middlereportIspass != null ? !middlereportIspass.equals(that.middlereportIspass) : that.middlereportIspass != null)
            return false;
        if (middlereportSuggest != null ? !middlereportSuggest.equals(that.middlereportSuggest) : that.middlereportSuggest != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid != null ? studentid.hashCode() : 0;
        result = 31 * result + (middlereportPath != null ? middlereportPath.hashCode() : 0);
        result = 31 * result + (middlereportIspass != null ? middlereportIspass.hashCode() : 0);
        result = 31 * result + (middlereportSuggest != null ? middlereportSuggest.hashCode() : 0);
        return result;
    }
}
