package com.xingong.bishe.entitys;

import javax.persistence.*;

/**
 * Created by zhang on 2018/4/23.
 */
@Entity
@Table(name = "stu_topic", schema = "bishe", catalog = "")
public class StuTopicEntity {
    private String studentid;
    private Integer designprocess;
    private String topicid;

    @Id
    @Column(name = "studentid")
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "designprocess")
    public Integer getDesignprocess() {
        return designprocess;
    }

    public void setDesignprocess(Integer designprocess) {
        this.designprocess = designprocess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuTopicEntity that = (StuTopicEntity) o;

        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (designprocess != null ? !designprocess.equals(that.designprocess) : that.designprocess != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid != null ? studentid.hashCode() : 0;
        result = 31 * result + (designprocess != null ? designprocess.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "topicid")
    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }
}
