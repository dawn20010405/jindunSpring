package com.demo.pojo;/**
 * @Auther: Length
 * @Date: 2020/12/22 10:20
 * @Description:
 */

import javax.persistence.*;
import java.util.Objects;

/**
 *@description:
 *@author: larry
 *@create: 2020-12-22 10:20
 */
@Entity
@Table(name = "ration_lc", schema = "test", catalog = "")
public class RationLc {
    private Integer raid;
    private String raname;
    private Integer rascore;
    private String raothr;
    private AssessmentTeamLc atlcraone;

    @Id
    @Column(name = "raid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getRaid() {
        return raid;
    }

    public void setRaid(Integer raid) {
        this.raid = raid;
    }

    @Basic
    @Column(name = "raname")
    public String getRaname() {
        return raname;
    }

    public void setRaname(String raname) {
        this.raname = raname;
    }

    @Basic
    @Column(name = "rascore")
    public Integer getRascore() {
        return rascore;
    }

    public void setRascore(Integer rascore) {
        this.rascore = rascore;
    }

    @Basic
    @Column(name = "raothr")
    public String getRaothr() {
        return raothr;
    }

    public void setRaothr(String raothr) {
        this.raothr = raothr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RationLc rationLc = (RationLc) o;
        return Objects.equals(raid, rationLc.raid) &&
                Objects.equals(raname, rationLc.raname) &&
                Objects.equals(rascore, rationLc.rascore) &&
                Objects.equals(raothr, rationLc.raothr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raid, raname, rascore, raothr);
    }

    @OneToOne
    @JoinColumn(name = "atid", referencedColumnName = "atid")
    public AssessmentTeamLc getAtlcraone() {
        return atlcraone;
    }

    public void setAtlcraone(AssessmentTeamLc atlcraone) {
        this.atlcraone = atlcraone;
    }
}
