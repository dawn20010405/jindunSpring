package com.demo.pojo;/**
 * @Auther: Length
 * @Date: 2020/12/22 10:16
 * @Description:
 */

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 *@description:
 *@author: larry
 *@create: 2020-12-22 10:16
 */
@Entity
@Table(name = "assessment_team_lc", schema = "test", catalog = "")
public class AssessmentTeamLc {
    private Integer atid;
    private Integer scoreeid;
    private String acopinion;
    private Integer actotal;
    private Achievementslc aclcone;
    private Emp atlempone;
    private RationLc raone;
    private QualitativeLc qualitativeone;
    private List<AppealFormLc> afatlclist;
    private Summarylc sulcatone;

    @Id
    @Column(name = "atid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAtid() {
        return atid;
    }

    public void setAtid(Integer atid) {
        this.atid = atid;
    }

    @Basic
    @Column(name = "scoreeid")
    public Integer getScoreeid() {
        return scoreeid;
    }

    public void setScoreeid(Integer scoreeid) {
        this.scoreeid = scoreeid;
    }

    @Basic
    @Column(name = "acopinion")
    public String getAcopinion() {
        return acopinion;
    }

    public void setAcopinion(String acopinion) {
        this.acopinion = acopinion;
    }

    @Basic
    @Column(name = "actotal")
    public Integer getActotal() {
        return actotal;
    }

    public void setActotal(Integer actotal) {
        this.actotal = actotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssessmentTeamLc that = (AssessmentTeamLc) o;
        return Objects.equals(atid, that.atid) &&
                Objects.equals(scoreeid, that.scoreeid) &&
                Objects.equals(acopinion, that.acopinion) &&
                Objects.equals(actotal, that.actotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atid, scoreeid, acopinion, actotal);
    }

    @ManyToOne
    @JoinColumn(name = "acid", referencedColumnName = "acid")
    public Achievementslc getAclcone() {
        return aclcone;
    }

    public void setAclcone(Achievementslc aclcone) {
        this.aclcone = aclcone;
    }

    @OneToOne(mappedBy = "atlctow")
    public Emp getAtlempone() {
        return atlempone;
    }

    public void setAtlempone(Emp atlempone) {
        this.atlempone = atlempone;
    }

    @OneToOne(mappedBy = "atlcraone")
    public RationLc getRaone() {
        return raone;
    }

    public void setRaone(RationLc raone) {
        this.raone = raone;
    }

    @OneToOne(mappedBy = "quaclcone")
    public QualitativeLc getQualitativeone() {
        return qualitativeone;
    }

    public void setQualitativeone(QualitativeLc qualitativeone) {
        this.qualitativeone = qualitativeone;
    }

    @OneToMany(mappedBy = "aflclone")
    public List<AppealFormLc> getAfatlclist() {
        return afatlclist;
    }

    public void setAfatlclist(List<AppealFormLc> afatlclist) {
        this.afatlclist = afatlclist;
    }

    @OneToOne(mappedBy = "summarylcatone")
    public Summarylc getSulcatone() {
        return sulcatone;
    }

    public void setSulcatone(Summarylc sulcatone) {
        this.sulcatone = sulcatone;
    }
}
