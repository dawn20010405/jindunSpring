package com.demo.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Backlog {
    private Integer baid;
    private String batile;
    private String baname;
    private Timestamp baapplydate;
    private String batype;
    private String baemp;
    private Integer baresult;
    private Timestamp bacldate;
    private String bacause;
    private Integer baxxid;
    private Integer readorunread;

    @Id
    @Column(name = "baid")
    public Integer getBaid() {
        return baid;
    }

    public void setBaid(Integer baid) {
        this.baid = baid;
    }

    @Basic
    @Column(name = "batile")
    public String getBatile() {
        return batile;
    }

    public void setBatile(String batile) {
        this.batile = batile;
    }

    @Basic
    @Column(name = "baname")
    public String getBaname() {
        return baname;
    }

    public void setBaname(String baname) {
        this.baname = baname;
    }

    @Basic
    @Column(name = "baapplydate")
    public Timestamp getBaapplydate() {
        return baapplydate;
    }

    public void setBaapplydate(Timestamp baapplydate) {
        this.baapplydate = baapplydate;
    }

    @Basic
    @Column(name = "batype")
    public String getBatype() {
        return batype;
    }

    public void setBatype(String batype) {
        this.batype = batype;
    }

    @Basic
    @Column(name = "baemp")
    public String getBaemp() {
        return baemp;
    }

    public void setBaemp(String baemp) {
        this.baemp = baemp;
    }

    @Basic
    @Column(name = "baresult")
    public Integer getBaresult() {
        return baresult;
    }

    public void setBaresult(Integer baresult) {
        this.baresult = baresult;
    }

    @Basic
    @Column(name = "bacldate")
    public Timestamp getBacldate() {
        return bacldate;
    }

    public void setBacldate(Timestamp bacldate) {
        this.bacldate = bacldate;
    }

    @Basic
    @Column(name = "bacause")
    public String getBacause() {
        return bacause;
    }

    public void setBacause(String bacause) {
        this.bacause = bacause;
    }

    @Basic
    @Column(name = "baxxid")
    public Integer getBaxxid() {
        return baxxid;
    }

    public void setBaxxid(Integer baxxid) {
        this.baxxid = baxxid;
    }

    @Basic
    @Column(name = "readorunread")
    public Integer getReadorunread() {
        return readorunread;
    }

    public void setReadorunread(Integer readorunread) {
        this.readorunread = readorunread;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backlog backlog = (Backlog) o;
        return Objects.equals(baid, backlog.baid) &&
                Objects.equals(batile, backlog.batile) &&
                Objects.equals(baname, backlog.baname) &&
                Objects.equals(baapplydate, backlog.baapplydate) &&
                Objects.equals(batype, backlog.batype) &&
                Objects.equals(baemp, backlog.baemp) &&
                Objects.equals(baresult, backlog.baresult) &&
                Objects.equals(bacldate, backlog.bacldate) &&
                Objects.equals(bacause, backlog.bacause) &&
                Objects.equals(baxxid, backlog.baxxid) &&
                Objects.equals(readorunread, backlog.readorunread);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baid, batile, baname, baapplydate, batype, baemp, baresult, bacldate, bacause, baxxid, readorunread);
    }
}
