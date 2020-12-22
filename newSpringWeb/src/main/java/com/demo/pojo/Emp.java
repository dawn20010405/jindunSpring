package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: Emp
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-21 20:24
 * @Version: v1.0
 */
@Entity
public class Emp {
    private Integer eid;
    private String ename;
    private Timestamp erutime;
    private String eiphone;
    private String epass;
    private Myproject myproject;
    private List<Mycanyu> mycanyu;
    private Mydynamic bdynamic;
    private Myrisk wrisk;
    private Integer pid;
    private Integer jid;
    private Integer tid;
    private Integer did;
    private Achievementslc jixiaoone;
    private AssessmentTeamLc atlctow;

    @Id
    @Column(name = "eid", nullable = false)
    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "ename", nullable = false, length = 255)
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "erutime", nullable = false)
    public Timestamp getErutime() {
        return erutime;
    }

    public void setErutime(Timestamp erutime) {
        this.erutime = erutime;
    }

    @Basic
    @Column(name = "eiphone", nullable = true, length = 11)
    public String getEiphone() {
        return eiphone;
    }

    public void setEiphone(String eiphone) {
        this.eiphone = eiphone;
    }

    @Basic
    @Column(name = "epass", nullable = true, length = 30)
    public String getEpass() {
        return epass;
    }

    public void setEpass(String epass) {
        this.epass = epass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(eid, emp.eid) &&
                Objects.equals(ename, emp.ename) &&
                Objects.equals(erutime, emp.erutime) &&
                Objects.equals(eiphone, emp.eiphone) &&
                Objects.equals(epass, emp.epass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eid, ename, erutime, eiphone, epass);
    }

    @OneToOne(mappedBy = "myfzr")
    public Myproject getMyproject() {
        return myproject;
    }

    public void setMyproject(Myproject myproject) {
        this.myproject = myproject;
    }

    @OneToMany(mappedBy = "myemps")
    public List<Mycanyu> getMycanyu() {
        return mycanyu;
    }

    public void setMycanyu(List<Mycanyu> mycanyu) {
        this.mycanyu = mycanyu;
    }

    @OneToOne(mappedBy = "bemp")
    public Mydynamic getBdynamic() {
        return bdynamic;
    }

    public void setBdynamic(Mydynamic bdynamic) {
        this.bdynamic = bdynamic;
    }

    @OneToOne(mappedBy = "wemp")
    public Myrisk getWrisk() {
        return wrisk;
    }

    public void setWrisk(Myrisk wrisk) {
        this.wrisk = wrisk;
    }

    @Basic
    @Column(name = "pid")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "jid")
    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    @Basic
    @Column(name = "tid")
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "did")
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @OneToOne
    @JoinColumn(name = "eid", referencedColumnName = "eid", nullable = false)
    public Achievementslc getJixiaoone() {
        return jixiaoone;
    }

    public void setJixiaoone(Achievementslc jixiaoone) {
        this.jixiaoone = jixiaoone;
    }

    @OneToOne
    @JoinColumn(name = "eid", referencedColumnName = "ateid", nullable = false)
    public AssessmentTeamLc getAtlctow() {
        return atlctow;
    }

    public void setAtlctow(AssessmentTeamLc atlctow) {
        this.atlctow = atlctow;
    }
}
