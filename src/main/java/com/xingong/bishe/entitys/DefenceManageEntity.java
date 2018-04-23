package com.xingong.bishe.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by zhang on 2018/4/23.
 */
@Entity
@Table(name = "defence_manage", schema = "bishe", catalog = "")
public class DefenceManageEntity {
    private String studentid;
    private String paperdraftPath;
    private Integer paperdraftIspass;
    private String paperdraftSuggest;
    private String paperfinalPath;
    private Integer paperfinalIspass;
    private String paperfinalSuggest;
    private Timestamp defenceTime;
    private Integer defenceScore;

    @Id
    @Column(name = "studentid")
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "paperdraft_path")
    public String getPaperdraftPath() {
        return paperdraftPath;
    }

    public void setPaperdraftPath(String paperdraftPath) {
        this.paperdraftPath = paperdraftPath;
    }

    @Basic
    @Column(name = "paperdraft_ispass")
    public Integer getPaperdraftIspass() {
        return paperdraftIspass;
    }

    public void setPaperdraftIspass(Integer paperdraftIspass) {
        this.paperdraftIspass = paperdraftIspass;
    }

    @Basic
    @Column(name = "paperdraft_suggest")
    public String getPaperdraftSuggest() {
        return paperdraftSuggest;
    }

    public void setPaperdraftSuggest(String paperdraftSuggest) {
        this.paperdraftSuggest = paperdraftSuggest;
    }

    @Basic
    @Column(name = "paperfinal_path")
    public String getPaperfinalPath() {
        return paperfinalPath;
    }

    public void setPaperfinalPath(String paperfinalPath) {
        this.paperfinalPath = paperfinalPath;
    }

    @Basic
    @Column(name = "paperfinal_ispass")
    public Integer getPaperfinalIspass() {
        return paperfinalIspass;
    }

    public void setPaperfinalIspass(Integer paperfinalIspass) {
        this.paperfinalIspass = paperfinalIspass;
    }

    @Basic
    @Column(name = "paperfinal_suggest")
    public String getPaperfinalSuggest() {
        return paperfinalSuggest;
    }

    public void setPaperfinalSuggest(String paperfinalSuggest) {
        this.paperfinalSuggest = paperfinalSuggest;
    }

    @Basic
    @Column(name = "defence_time")
    public Timestamp getDefenceTime() {
        return defenceTime;
    }

    public void setDefenceTime(Timestamp defenceTime) {
        this.defenceTime = defenceTime;
    }

    @Basic
    @Column(name = "defence_score")
    public Integer getDefenceScore() {
        return defenceScore;
    }

    public void setDefenceScore(Integer defenceScore) {
        this.defenceScore = defenceScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefenceManageEntity that = (DefenceManageEntity) o;

        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (paperdraftPath != null ? !paperdraftPath.equals(that.paperdraftPath) : that.paperdraftPath != null)
            return false;
        if (paperdraftIspass != null ? !paperdraftIspass.equals(that.paperdraftIspass) : that.paperdraftIspass != null)
            return false;
        if (paperdraftSuggest != null ? !paperdraftSuggest.equals(that.paperdraftSuggest) : that.paperdraftSuggest != null)
            return false;
        if (paperfinalPath != null ? !paperfinalPath.equals(that.paperfinalPath) : that.paperfinalPath != null)
            return false;
        if (paperfinalIspass != null ? !paperfinalIspass.equals(that.paperfinalIspass) : that.paperfinalIspass != null)
            return false;
        if (paperfinalSuggest != null ? !paperfinalSuggest.equals(that.paperfinalSuggest) : that.paperfinalSuggest != null)
            return false;
        if (defenceTime != null ? !defenceTime.equals(that.defenceTime) : that.defenceTime != null) return false;
        if (defenceScore != null ? !defenceScore.equals(that.defenceScore) : that.defenceScore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid != null ? studentid.hashCode() : 0;
        result = 31 * result + (paperdraftPath != null ? paperdraftPath.hashCode() : 0);
        result = 31 * result + (paperdraftIspass != null ? paperdraftIspass.hashCode() : 0);
        result = 31 * result + (paperdraftSuggest != null ? paperdraftSuggest.hashCode() : 0);
        result = 31 * result + (paperfinalPath != null ? paperfinalPath.hashCode() : 0);
        result = 31 * result + (paperfinalIspass != null ? paperfinalIspass.hashCode() : 0);
        result = 31 * result + (paperfinalSuggest != null ? paperfinalSuggest.hashCode() : 0);
        result = 31 * result + (defenceTime != null ? defenceTime.hashCode() : 0);
        result = 31 * result + (defenceScore != null ? defenceScore.hashCode() : 0);
        return result;
    }
}
