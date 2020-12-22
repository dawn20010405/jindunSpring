package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: Notification
 * @Author: 左增源
 * @create: 2020-12-22 09:13
 * @program: demo
 * @description:
 */
@Entity
public class Notification {
    private Integer noid;
    private String noname;
    private String nofenlei;
    private String notype;
    private Timestamp nodate;
    private String zhengwen;
    private Timestamp nodzdate;
    private String nonid;
    private String zhuangtai;
    private Emp mynoemp;

    /*公告关联审批表*/
    private List<Examine> examines;

    @Id
    @Column(name = "noid", nullable = false)
    public Integer getNoid() {
        return noid;
    }

    public void setNoid(Integer noid) {
        this.noid = noid;
    }

    @Basic
    @Column(name = "noname", nullable = true, length = 255)
    public String getNoname() {
        return noname;
    }

    public void setNoname(String noname) {
        this.noname = noname;
    }

    @Basic
    @Column(name = "nofenlei", nullable = true, length = 255)
    public String getNofenlei() {
        return nofenlei;
    }

    public void setNofenlei(String nofenlei) {
        this.nofenlei = nofenlei;
    }

    @Basic
    @Column(name = "notype", nullable = true, length = 255)
    public String getNotype() {
        return notype;
    }

    public void setNotype(String notype) {
        this.notype = notype;
    }

    @Basic
    @Column(name = "nodate", nullable = true)
    public Timestamp getNodate() {
        return nodate;
    }

    public void setNodate(Timestamp nodate) {
        this.nodate = nodate;
    }

    @Basic
    @Column(name = "zhengwen", nullable = true, length = 999)
    public String getZhengwen() {
        return zhengwen;
    }

    public void setZhengwen(String zhengwen) {
        this.zhengwen = zhengwen;
    }

    @Basic
    @Column(name = "nodzdate", nullable = true)
    public Timestamp getNodzdate() {
        return nodzdate;
    }

    public void setNodzdate(Timestamp nodzdate) {
        this.nodzdate = nodzdate;
    }

    @Basic
    @Column(name = "nonid", nullable = true, length = 255)
    public String getNonid() {
        return nonid;
    }

    public void setNonid(String nonid) {
        this.nonid = nonid;
    }

    @Basic
    @Column(name = "zhuangtai", nullable = true, length = 255)
    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(noid, that.noid) &&
                Objects.equals(noname, that.noname) &&
                Objects.equals(nofenlei, that.nofenlei) &&
                Objects.equals(notype, that.notype) &&
                Objects.equals(nodate, that.nodate) &&
                Objects.equals(zhengwen, that.zhengwen) &&
                Objects.equals(nodzdate, that.nodzdate) &&
                Objects.equals(nonid, that.nonid) &&
                Objects.equals(zhuangtai, that.zhuangtai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noid, noname, nofenlei, notype, nodate, zhengwen, nodzdate, nonid, zhuangtai);
    }

    @ManyToOne
    @JoinColumn(name = "empno", referencedColumnName = "eid")
    public Emp getMynoemp() {
        return mynoemp;
    }

    public void setMynoemp(Emp mynoemp) {
        this.mynoemp = mynoemp;
    }

}
