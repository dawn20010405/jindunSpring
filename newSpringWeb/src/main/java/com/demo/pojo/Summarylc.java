package com.demo.pojo;/**
 * @Auther: Length
 * @Date: 2020/12/22 10:28
 * @Description:
 */

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 *@description:
 *@author: larry
 *@create: 2020-12-22 10:28
 */
@Entity
public class Summarylc {
    private Integer suid;
    private String suneirong;
    private Date sutime;
    private String suother;
    private AssessmentTeamLc summarylcatone;

    @Override
    public String toString() {
        return "Summarylc{" +
                "suid=" + suid +
                ", suneirong='" + suneirong + '\'' +
                ", sutime=" + sutime +
                ", suother='" + suother + '\'' +
                '}';
    }

    @Id
    @Column(name = "suid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }

    @Basic
    @Column(name = "suneirong")
    public String getSuneirong() {
        return suneirong;
    }

    public void setSuneirong(String suneirong) {
        this.suneirong = suneirong;
    }

    @Basic
    @Column(name = "sutime")
    public Date getSutime() {
        return sutime;
    }

    public void setSutime(Date sutime) {
        this.sutime = sutime;
    }

    @Basic
    @Column(name = "suother")
    public String getSuother() {
        return suother;
    }

    public void setSuother(String suother) {
        this.suother = suother;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summarylc summarylc = (Summarylc) o;
        return Objects.equals(suid, summarylc.suid) &&
                Objects.equals(suneirong, summarylc.suneirong) &&
                Objects.equals(sutime, summarylc.sutime) &&
                Objects.equals(suother, summarylc.suother);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suid, suneirong, sutime, suother);
    }

    @OneToOne
    @JoinColumn(name = "atid", referencedColumnName = "atid")
    public AssessmentTeamLc getSummarylcatone() {
        return summarylcatone;
    }

    public void setSummarylcatone(AssessmentTeamLc summarylcatone) {
        this.summarylcatone = summarylcatone;
    }
}
