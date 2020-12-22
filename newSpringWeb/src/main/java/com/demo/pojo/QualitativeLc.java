package com.demo.pojo;/**
 * @Auther: Length
 * @Date: 2020/12/22 10:21
 * @Description:
 */

import javax.persistence.*;
import java.util.Objects;

/**
 *@description:
 *@author: larry
 *@create: 2020-12-22 10:21
 */
@Entity
@Table(name = "qualitative_lc", schema = "test", catalog = "")
public class QualitativeLc {
    private Integer quid;
    private String quname;
    private Integer quscore;
    private String quother;
    private AssessmentTeamLc quaclcone;

    @Id
    @Column(name = "quid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getQuid() {
        return quid;
    }

    public void setQuid(Integer quid) {
        this.quid = quid;
    }

    @Basic
    @Column(name = "quname")
    public String getQuname() {
        return quname;
    }

    public void setQuname(String quname) {
        this.quname = quname;
    }

    @Basic
    @Column(name = "quscore")
    public Integer getQuscore() {
        return quscore;
    }

    public void setQuscore(Integer quscore) {
        this.quscore = quscore;
    }

    @Basic
    @Column(name = "quother")
    public String getQuother() {
        return quother;
    }

    public void setQuother(String quother) {
        this.quother = quother;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QualitativeLc that = (QualitativeLc) o;
        return Objects.equals(quid, that.quid) &&
                Objects.equals(quname, that.quname) &&
                Objects.equals(quscore, that.quscore) &&
                Objects.equals(quother, that.quother);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quid, quname, quscore, quother);
    }

    @OneToOne
    @JoinColumn(name = "atid", referencedColumnName = "atid")
    public AssessmentTeamLc getQuaclcone() {
        return quaclcone;
    }

    public void setQuaclcone(AssessmentTeamLc quaclcone) {
        this.quaclcone = quaclcone;
    }
}
