package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: Examine
 * @Author: 左增源
 * @create: 2020-12-23 15:03
 * @program: demo
 * @description:
 */
@Entity
public class Examine {
    private Integer exid;
    private String exstate;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
//    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp exdate;
    private String exyijian;
    private String wxwid;
    private Integer extype;
    private Emp myexemp;

    @Id
    @Column(name = "exid", nullable = false)
    public Integer getExid() {
        return exid;
    }

    public void setExid(Integer exid) {
        this.exid = exid;
    }

    @Basic
    @Column(name = "exstate", nullable = true, length = 255)
    public String getExstate() {
        return exstate;
    }

    public void setExstate(String exstate) {
        this.exstate = exstate;
    }

    @Basic
    @Column(name = "exdate", nullable = true)
    public Timestamp getExdate() {
        return exdate;
    }

    public void setExdate(Timestamp exdate) {
        this.exdate = exdate;
    }

    @Basic
    @Column(name = "exyijian", nullable = true, length = 255)
    public String getExyijian() {
        return exyijian;
    }

    public void setExyijian(String exyijian) {
        this.exyijian = exyijian;
    }

    @Basic
    @Column(name = "wxwid", nullable = true, length = 255)
    public String getWxwid() {
        return wxwid;
    }

    public void setWxwid(String wxwid) {
        this.wxwid = wxwid;
    }

    @Basic
    @Column(name = "extype", nullable = true)
    public Integer getExtype() {
        return extype;
    }

    public void setExtype(Integer extype) {
        this.extype = extype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Examine examine = (Examine) o;
        return Objects.equals(exid, examine.exid) &&
                Objects.equals(exstate, examine.exstate) &&
                Objects.equals(exdate, examine.exdate) &&
                Objects.equals(exyijian, examine.exyijian) &&
                Objects.equals(wxwid, examine.wxwid) &&
                Objects.equals(extype, examine.extype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exid, exstate, exdate, exyijian, wxwid, extype);
    }

    @ManyToOne
    @JoinColumn(name = "exuser", referencedColumnName = "eid")
    public Emp getMyexemp() {
        return myexemp;
    }

    public void setMyexemp(Emp myexemp) {
        this.myexemp = myexemp;
    }
}
