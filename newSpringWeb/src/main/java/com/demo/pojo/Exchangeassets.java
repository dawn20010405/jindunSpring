package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by qqc on 2020/12/21
 */
@Entity
public class Exchangeassets {
    private Integer exchangeassetsid;
    private String exchassetsname;
    private String exasnum;
    private String exastype;
    private Integer exasquantity;
    private Integer exasempid;
    private Timestamp exasstart;
    private String exasreason;
    private String exasfollow;
    private Timestamp exasback;
    private List<Consumingdetails> codes;

    @Id
    @Column(name = "exchangeassetsid", nullable = false)
    public Integer getExchangeassetsid() {
        return exchangeassetsid;
    }

    public void setExchangeassetsid(Integer exchangeassetsid) {
        this.exchangeassetsid = exchangeassetsid;
    }

    @Basic
    @Column(name = "exchassetsname", nullable = true, length = 60)
    public String getExchassetsname() {
        return exchassetsname;
    }

    public void setExchassetsname(String exchassetsname) {
        this.exchassetsname = exchassetsname;
    }

    @Basic
    @Column(name = "exasnum", nullable = true, length = 60)
    public String getExasnum() {
        return exasnum;
    }

    public void setExasnum(String exasnum) {
        this.exasnum = exasnum;
    }

    @Basic
    @Column(name = "exastype", nullable = true, length = 20)
    public String getExastype() {
        return exastype;
    }

    public void setExastype(String exastype) {
        this.exastype = exastype;
    }

    @Basic
    @Column(name = "exasquantity", nullable = true)
    public Integer getExasquantity() {
        return exasquantity;
    }

    public void setExasquantity(Integer exasquantity) {
        this.exasquantity = exasquantity;
    }

    @Basic
    @Column(name = "exasempid", nullable = true)
    public Integer getExasempid() {
        return exasempid;
    }

    public void setExasempid(Integer exasempid) {
        this.exasempid = exasempid;
    }

    @Basic
    @Column(name = "exasstart", nullable = true)
    public Timestamp getExasstart() {
        return exasstart;
    }

    public void setExasstart(Timestamp exasstart) {
        this.exasstart = exasstart;
    }

    @Basic
    @Column(name = "exasreason", nullable = true, length = 200)
    public String getExasreason() {
        return exasreason;
    }

    public void setExasreason(String exasreason) {
        this.exasreason = exasreason;
    }

    @Basic
    @Column(name = "exasfollow", nullable = true, length = 200)
    public String getExasfollow() {
        return exasfollow;
    }

    public void setExasfollow(String exasfollow) {
        this.exasfollow = exasfollow;
    }

    @Basic
    @Column(name = "exasback", nullable = true)
    public Timestamp getExasback() {
        return exasback;
    }

    public void setExasback(Timestamp exasback) {
        this.exasback = exasback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exchangeassets that = (Exchangeassets) o;

        if (exchangeassetsid != null ? !exchangeassetsid.equals(that.exchangeassetsid) : that.exchangeassetsid != null)
            return false;
        if (exchassetsname != null ? !exchassetsname.equals(that.exchassetsname) : that.exchassetsname != null)
            return false;
        if (exasnum != null ? !exasnum.equals(that.exasnum) : that.exasnum != null) return false;
        if (exastype != null ? !exastype.equals(that.exastype) : that.exastype != null) return false;
        if (exasquantity != null ? !exasquantity.equals(that.exasquantity) : that.exasquantity != null) return false;
        if (exasempid != null ? !exasempid.equals(that.exasempid) : that.exasempid != null) return false;
        if (exasstart != null ? !exasstart.equals(that.exasstart) : that.exasstart != null) return false;
        if (exasreason != null ? !exasreason.equals(that.exasreason) : that.exasreason != null) return false;
        if (exasfollow != null ? !exasfollow.equals(that.exasfollow) : that.exasfollow != null) return false;
        if (exasback != null ? !exasback.equals(that.exasback) : that.exasback != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exchangeassetsid != null ? exchangeassetsid.hashCode() : 0;
        result = 31 * result + (exchassetsname != null ? exchassetsname.hashCode() : 0);
        result = 31 * result + (exasnum != null ? exasnum.hashCode() : 0);
        result = 31 * result + (exastype != null ? exastype.hashCode() : 0);
        result = 31 * result + (exasquantity != null ? exasquantity.hashCode() : 0);
        result = 31 * result + (exasempid != null ? exasempid.hashCode() : 0);
        result = 31 * result + (exasstart != null ? exasstart.hashCode() : 0);
        result = 31 * result + (exasreason != null ? exasreason.hashCode() : 0);
        result = 31 * result + (exasfollow != null ? exasfollow.hashCode() : 0);
        result = 31 * result + (exasback != null ? exasback.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "exassets")
    public List<Consumingdetails> getCodes() {
        return codes;
    }

    public void setCodes(List<Consumingdetails> codes) {
        this.codes = codes;
    }
}
