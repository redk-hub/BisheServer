package com.xingong.bishe.entitys;

import javax.persistence.*;

/**
 * Created by zhang on 2018/5/2.
 */
@Entity
@Table(name = "college", schema = "bishe", catalog = "")
public class CollegeEntity {
    private int collegeid;
    private String collegename;

    @Id
    @Column(name = "collegeid")
    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollegeEntity that = (CollegeEntity) o;

        if (collegeid != that.collegeid) return false;
        if (collegename != null ? !collegename.equals(that.collegename) : that.collegename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collegeid;
        result = 31 * result + (collegename != null ? collegename.hashCode() : 0);
        return result;
    }
}
