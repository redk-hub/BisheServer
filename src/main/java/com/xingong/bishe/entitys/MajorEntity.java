package com.xingong.bishe.entitys;

import javax.persistence.*;

/**
 * Created by zhang on 2018/5/2.
 */
@Entity
@Table(name = "major", schema = "bishe", catalog = "")
public class MajorEntity {
    private int majorid;
    private String majorname;
    private Integer collegeid;

    @Id
    @Column(name = "majorid")
    public int getMajorid() {
        return majorid;
    }

    public void setMajorid(int majorid) {
        this.majorid = majorid;
    }

    @Basic
    @Column(name = "majorname")
    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    @Basic
    @Column(name = "collegeid")
    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MajorEntity that = (MajorEntity) o;

        if (majorid != that.majorid) return false;
        if (majorname != null ? !majorname.equals(that.majorname) : that.majorname != null) return false;
        if (collegeid != null ? !collegeid.equals(that.collegeid) : that.collegeid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = majorid;
        result = 31 * result + (majorname != null ? majorname.hashCode() : 0);
        result = 31 * result + (collegeid != null ? collegeid.hashCode() : 0);
        return result;
    }
}
