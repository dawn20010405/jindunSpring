package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp erutime;
    private String eiphone;
    private String epass;
    private Myproject myproject;
    private List<Mycanyu> mycanyu;
    private Mydynamic bdynamic;
    private Myrisk wrisk;
    private List<Exchangeassets> exassets;
    private List<Consumingdetails> condetails;
    private List<Purchase> purchase;
    private Achievementslc jixiaoone;
    private AssessmentTeamLc atlctow;
    private String ezt;
    private String esex;


//    12 22 左增源 公司公告
    private List<Notification> notifications;
    private List<Examine> examinelist;

    private Position myposition;
    private Just myjust;
    private Dimission mydimission;
    private List<Transfer> mytransfer;
    private Integer eqianyue;
    private Contracts mycontracts;


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
    @Column(name = "eiphone", nullable = false, length = 11)
    public String getEiphone() {
        return eiphone;
    }

    public void setEiphone(String eiphone) {
        this.eiphone = eiphone;
    }

    @Basic
    @Column(name = "epass", nullable = false, length = 30)
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

    @OneToMany(mappedBy = "emp")
    public List<Exchangeassets> getExassets() {
        return exassets;
    }

    public void setExassets(List<Exchangeassets> exassets) {
        this.exassets = exassets;
    }

    @OneToMany(mappedBy = "emp")
    public List<Consumingdetails> getCondetails() {
        return condetails;
    }

    public void setCondetails(List<Consumingdetails> condetails) {
        this.condetails = condetails;
    }

    @OneToMany(mappedBy = "emp")
    public List<Purchase> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Purchase> purchase) {
        this.purchase = purchase;
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

    @OneToMany(mappedBy = "mynoemp")
    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    @OneToMany(mappedBy = "myexemp")
    public List<Examine> getExaminelist() {
        return examinelist;
    }

    public void setExaminelist(List<Examine> examinelist) {
        this.examinelist = examinelist;
    }

    @OneToOne
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    public Position getMyposition() {
        return myposition;
    }

    public void setMyposition(Position myposition) {
        this.myposition = myposition;
    }

    @OneToOne
    @JoinColumn(name = "jid", referencedColumnName = "jid")
    public Just getMyjust() {
        return myjust;
    }

    public void setMyjust(Just myjust) {
        this.myjust = myjust;
    }

    @OneToOne
    @JoinColumn(name = "did", referencedColumnName = "dimid")
    public Dimission getMydimission() {
        return mydimission;
    }

    public void setMydimission(Dimission mydimission) {
        this.mydimission = mydimission;
    }

    @Basic
    @Column(name = "ezt", nullable = true, length = 255)
    public String getEzt() {
        return ezt;
    }

    public void setEzt(String ezt) {
        this.ezt = ezt;
    }

    @Basic
    @Column(name = "esex", nullable = true, length = 255)
    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    @Basic
    @Column(name = "eqianyue", nullable = true)
    public Integer getEqianyue() {
        return eqianyue;
    }

    public void setEqianyue(Integer eqianyue) {
        this.eqianyue = eqianyue;
    }

    @OneToMany(mappedBy = "myemp")
    public List<Transfer> getMytransfer() {
        return mytransfer;
    }

    public void setMytransfer(List<Transfer> mytransfer) {
        this.mytransfer = mytransfer;
    }


    @OneToOne(mappedBy = "myemp")
    public Contracts getMycontracts() {
        return mycontracts;
    }

    public void setMycontracts(Contracts mycontracts) {
        this.mycontracts = mycontracts;
    }
}
