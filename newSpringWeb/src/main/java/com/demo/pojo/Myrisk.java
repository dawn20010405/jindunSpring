package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: Myrisk
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-21 21:30
 * @Version: v1.0
 */
@Entity
public class Myrisk {
    private Integer fid;
    private String fname;
    private String btype;
    private String content;
    private String cuoshi;
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Timestamp cdate;
    private Integer level;
    private String influence;
    private Emp wemp;
    private Myproject mproject;

    @Id
    @Column(name = "fid", nullable = false)
    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "fname", nullable = true, length = 20)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "btype", nullable = true, length = 20)
    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 50)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "cuoshi", nullable = true, length = 50)
    public String getCuoshi() {
        return cuoshi;
    }

    public void setCuoshi(String cuoshi) {
        this.cuoshi = cuoshi;
    }

    @Basic
    @Column(name = "cdate", nullable = true)
    public Timestamp getCdate() {
        return cdate;
    }

    public void setCdate(Timestamp cdate) {
        this.cdate = cdate;
    }

    @Basic
    @Column(name = "level", nullable = true)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "influence", nullable = true, length = 50)
    public String getInfluence() {
        return influence;
    }

    public void setInfluence(String influence) {
        this.influence = influence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Myrisk myrisk = (Myrisk) o;
        return Objects.equals(fid, myrisk.fid) &&
                Objects.equals(fname, myrisk.fname) &&
                Objects.equals(btype, myrisk.btype) &&
                Objects.equals(content, myrisk.content) &&
                Objects.equals(cuoshi, myrisk.cuoshi) &&
                Objects.equals(cdate, myrisk.cdate) &&
                Objects.equals(level, myrisk.level) &&
                Objects.equals(influence, myrisk.influence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fid, fname, btype, content, cuoshi, cdate, level, influence);
    }

    @OneToOne
    @JoinColumn(name = "empno", referencedColumnName = "eid")
    public Emp getWemp() {
        return wemp;
    }

    public void setWemp(Emp wemp) {
        this.wemp = wemp;
    }

    @ManyToOne
    @JoinColumn(name = "xid", referencedColumnName = "xid")
    public Myproject getMproject() {
        return mproject;
    }

    public void setMproject(Myproject mproject) {
        this.mproject = mproject;
    }
}
