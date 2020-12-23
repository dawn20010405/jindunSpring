package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: Examine
 * @Author: 左增源
 * @create: 2020-12-22 09:13
 * @program: demo
 * @description:
 */
@Entity
public class Examine {
    private Integer exid;
    private String exstate;
    private Timestamp exdate;
    private String exyijian;
    private String exwid;
    private String zhuangtai;
    private Emp myexemp;
    private Integer extype;
    private Emp myemp;
    private Integer wxwid;

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
    @Column(name = "exwid", nullable = true, length = 255)
    public String getExwid() {
        return exwid;
    }

    public void setExwid(String exwid) {
        this.exwid = exwid;
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
                Objects.equals(exwid, examine.exwid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exid, exstate, exdate, exyijian, exwid);
    }

    @Basic
    @Column(name = "zhuangtai", nullable = true, length = 255)
    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    @ManyToOne
    @JoinColumn(name = "empno", referencedColumnName = "eid")
    public Emp getMyexemp() {
        return myexemp;
    }

    public void setMyexemp(Emp myexemp) {
        this.myexemp = myexemp;
    }

    @Basic
    @Column(name = "extype", nullable = true)
    public Integer getExtype() {
        return extype;
    }

    public void setExtype(Integer extype) {
        this.extype = extype;
    }

    @ManyToOne
    @JoinColumn(name = "exuser", referencedColumnName = "eid")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }

    @Basic
    @Column(name = "wxwid", nullable = true)
    public Integer getWxwid() {
        return wxwid;
    }

    public void setWxwid(Integer wxwid) {
        this.wxwid = wxwid;
    }
}
