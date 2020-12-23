package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: Notification
 * @Author: 左增源
 * @create: 2020-12-23 15:03
 * @program: demo
 * @description:
 */
@Entity
public class Notification {
    private Integer noid;
    private String noname;
    private String nofenlei;
    private String notype;
    private String zhengwen;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
//    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp nodzdate;
    private Emp mynoemp;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(noid, that.noid) &&
                Objects.equals(noname, that.noname) &&
                Objects.equals(nofenlei, that.nofenlei) &&
                Objects.equals(notype, that.notype) &&
                Objects.equals(zhengwen, that.zhengwen) &&
                Objects.equals(nodzdate, that.nodzdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noid, noname, nofenlei, notype, zhengwen, nodzdate);
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
