package com.demo.pojo;/**
 * @Auther: Length
 * @Date: 2020/12/22 10:26
 * @Description:
 */

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 *@description:
 *@author: larry
 *@create: 2020-12-22 10:26
 */
@Entity
@Table(name = "appeal_form_lc", schema = "test", catalog = "")
public class AppealFormLc {
    private Integer afid;
    private String afreason;
    private Date aftime;
    private Integer oldrascore;
    private Integer newrascore;
    private String afadopt;
    private AssessmentTeamLc aflclone;

    @Id
    @Column(name = "afid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAfid() {
        return afid;
    }

    public void setAfid(Integer afid) {
        this.afid = afid;
    }

    @Basic
    @Column(name = "afreason")
    public String getAfreason() {
        return afreason;
    }

    public void setAfreason(String afreason) {
        this.afreason = afreason;
    }

    @Basic
    @Column(name = "aftime")
    public Date getAftime() {
        return aftime;
    }

    public void setAftime(Date aftime) {
        this.aftime = aftime;
    }

    @Basic
    @Column(name = "oldrascore")
    public Integer getOldrascore() {
        return oldrascore;
    }

    public void setOldrascore(Integer oldrascore) {
        this.oldrascore = oldrascore;
    }

    @Basic
    @Column(name = "newrascore")
    public Integer getNewrascore() {
        return newrascore;
    }

    public void setNewrascore(Integer newrascore) {
        this.newrascore = newrascore;
    }

    @Basic
    @Column(name = "afadopt")
    public String getAfadopt() {
        return afadopt;
    }

    public void setAfadopt(String afadopt) {
        this.afadopt = afadopt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppealFormLc that = (AppealFormLc) o;
        return Objects.equals(afid, that.afid) &&
                Objects.equals(afreason, that.afreason) &&
                Objects.equals(aftime, that.aftime) &&
                Objects.equals(oldrascore, that.oldrascore) &&
                Objects.equals(newrascore, that.newrascore) &&
                Objects.equals(afadopt, that.afadopt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(afid, afreason, aftime, oldrascore, newrascore, afadopt);
    }

    @ManyToOne
    @JoinColumn(name = "atid", referencedColumnName = "atid")
    public AssessmentTeamLc getAflclone() {
        return aflclone;
    }

    public void setAflclone(AssessmentTeamLc aflclone) {
        this.aflclone = aflclone;
    }
}
