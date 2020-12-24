package com.demo.pojo;/**
 * @Auther: Length
 * @Date: 2020/12/22 10:14
 * @Description:
 */

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 *@description:
 *@author: larry
 *@create: 2020-12-22 10:14
 */
@Entity
public class Achievementslc {
    private Integer acid;
    private String acname;
    private String acobjectives;
    private Integer actype;
    private Integer acyear;
    private Integer achalf;
    private Date starttime;
    private Date endtime;
    private Date acend;
    private Integer fachievement;
    private Integer fanonymous;
    private Integer startup;
    private Integer feedbacklc;
    private String acother;
    private Emp empacone;
    private List<AssessmentTeamLc> atllist;

    @Override
    public String toString() {
        return "Achievementslc{" +
                "acid=" + acid +
                ", acname='" + acname + '\'' +
                ", acobjectives='" + acobjectives + '\'' +
                ", actype=" + actype +
                ", acyear=" + acyear +
                ", achalf=" + achalf +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", acend=" + acend +
                ", fachievement=" + fachievement +
                ", fanonymous=" + fanonymous +
                ", startup=" + startup +
                ", feedbacklc=" + feedbacklc +
                ", acother='" + acother + '\'' +
                '}';
    }

    @Id
    @Column(name = "acid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
    }

    @Basic
    @Column(name = "acname")
    public String getAcname() {
        return acname;
    }

    public void setAcname(String acname) {
        this.acname = acname;
    }

    @Basic
    @Column(name = "acobjectives")
    public String getAcobjectives() {
        return acobjectives;
    }

    public void setAcobjectives(String acobjectives) {
        this.acobjectives = acobjectives;
    }

    @Basic
    @Column(name = "actype")
    public Integer getActype() {
        return actype;
    }

    public void setActype(Integer actype) {
        this.actype = actype;
    }

    @Basic
    @Column(name = "acyear")
    public Integer getAcyear() {
        return acyear;
    }

    public void setAcyear(Integer acyear) {
        this.acyear = acyear;
    }

    @Basic
    @Column(name = "achalf")
    public Integer getAchalf() {
        return achalf;
    }

    public void setAchalf(Integer achalf) {
        this.achalf = achalf;
    }

    @Basic
    @Column(name = "starttime")
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    @Basic
    @Column(name = "endtime")
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "acend")
    public Date getAcend() {
        return acend;
    }

    public void setAcend(Date acend) {
        this.acend = acend;
    }

    @Basic
    @Column(name = "fachievement")
    public Integer getFachievement() {
        return fachievement;
    }

    public void setFachievement(Integer fachievement) {
        this.fachievement = fachievement;
    }

    @Basic
    @Column(name = "fanonymous")
    public Integer getFanonymous() {
        return fanonymous;
    }

    public void setFanonymous(Integer fanonymous) {
        this.fanonymous = fanonymous;
    }

    @Basic
    @Column(name = "startup")
    public Integer getStartup() {
        return startup;
    }

    public void setStartup(Integer startup) {
        this.startup = startup;
    }

    @Basic
    @Column(name = "feedbacklc")
    public Integer getFeedbacklc() {
        return feedbacklc;
    }

    public void setFeedbacklc(Integer feedbacklc) {
        this.feedbacklc = feedbacklc;
    }

    @Basic
    @Column(name = "acother")
    public String getAcother() {
        return acother;
    }

    public void setAcother(String acother) {
        this.acother = acother;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Achievementslc that = (Achievementslc) o;
        return Objects.equals(acid, that.acid) &&
                Objects.equals(acname, that.acname) &&
                Objects.equals(acobjectives, that.acobjectives) &&
                Objects.equals(actype, that.actype) &&
                Objects.equals(acyear, that.acyear) &&
                Objects.equals(achalf, that.achalf) &&
                Objects.equals(starttime, that.starttime) &&
                Objects.equals(endtime, that.endtime) &&
                Objects.equals(acend, that.acend) &&
                Objects.equals(fachievement, that.fachievement) &&
                Objects.equals(fanonymous, that.fanonymous) &&
                Objects.equals(startup, that.startup) &&
                Objects.equals(feedbacklc, that.feedbacklc) &&
                Objects.equals(acother, that.acother);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acid, acname, acobjectives, actype, acyear, achalf, starttime, endtime, acend, fachievement, fanonymous, startup, feedbacklc, acother);
    }

    @OneToOne(mappedBy = "jixiaoone")
    public Emp getEmpacone() {
        return empacone;
    }

    public void setEmpacone(Emp empacone) {
        this.empacone = empacone;
    }

    @OneToMany(mappedBy = "aclcone")
    public List<AssessmentTeamLc> getAtllist() {
        return atllist;
    }

    public void setAtllist(List<AssessmentTeamLc> atllist) {
        this.atllist = atllist;
    }
}
