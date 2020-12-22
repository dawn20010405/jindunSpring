package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: Mydynamic
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-21 21:30
 * @Version: v1.0
 */
@Entity
public class Mydynamic {
    private Integer bid;
    private String btype;
    private String content;
    private Timestamp cdate;
    private Myproject myprojects;
    private Emp bemp;

    @Id
    @Column(name = "bid", nullable = false)
    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
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
    @Column(name = "cdate", nullable = true)
    public Timestamp getCdate() {
        return cdate;
    }

    public void setCdate(Timestamp cdate) {
        this.cdate = cdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mydynamic mydynamic = (Mydynamic) o;
        return Objects.equals(bid, mydynamic.bid) &&
                Objects.equals(btype, mydynamic.btype) &&
                Objects.equals(content, mydynamic.content) &&
                Objects.equals(cdate, mydynamic.cdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bid, btype, content, cdate);
    }

    @ManyToOne
    @JoinColumn(name = "xid", referencedColumnName = "xid")
    public Myproject getMyprojects() {
        return myprojects;
    }

    public void setMyprojects(Myproject myprojects) {
        this.myprojects = myprojects;
    }

    @OneToOne
    @JoinColumn(name = "empno", referencedColumnName = "eid")
    public Emp getBemp() {
        return bemp;
    }

    public void setBemp(Emp bemp) {
        this.bemp = bemp;
    }
}
