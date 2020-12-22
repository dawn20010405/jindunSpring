package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName: Projectype
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-21 21:30
 * @Version: v1.0
 */
@Entity
public class Projectype {
    private Integer tid;
    private String tname;
    private Integer tzhuangtai;
    private Myproject myproject;

    @Id
    @Column(name = "tid", nullable = false)
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "tname", nullable = true, length = 30)
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Basic
    @Column(name = "tzhuangtai", nullable = true)
    public Integer getTzhuangtai() {
        return tzhuangtai;
    }

    public void setTzhuangtai(Integer tzhuangtai) {
        this.tzhuangtai = tzhuangtai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projectype that = (Projectype) o;
        return Objects.equals(tid, that.tid) &&
                Objects.equals(tname, that.tname) &&
                Objects.equals(tzhuangtai, that.tzhuangtai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, tname, tzhuangtai);
    }

    @OneToOne
    @JoinColumn(name = "tid", referencedColumnName = "tid", nullable = false)
    public Myproject getMyproject() {
        return myproject;
    }

    public void setMyproject(Myproject myproject) {
        this.myproject = myproject;
    }
}
