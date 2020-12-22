package com.demo.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: Myproject
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-21 21:30
 * @Version: v1.0
 */
@Entity
public class Myproject {
    private Integer xid;
    private String xname;
    private Date start;
    private Date end;
    private String explain;
    private Integer evel;
    private Integer state;
    private Integer jindu;
    private Integer ziping;
    private Date skaishi;
    private Date sjieshu;
    private Date cdate;
    private Projectype mytype;
    private Emp myfzr;
    private List<Mydynamic> myxiaoxi;
    private List<Mycanyu> canyus;
    private List<Myrisk> mrisk;

    @Id
    @Column(name = "xid", nullable = false)
    public Integer getXid() {
        return xid;
    }

    public void setXid(Integer xid) {
        this.xid = xid;
    }

    @Basic
    @Column(name = "xname", nullable = true, length = 30)
    public String getXname() {
        return xname;
    }

    public void setXname(String xname) {
        this.xname = xname;
    }

    @Basic
    @Column(name = "start", nullable = true)
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @Basic
    @Column(name = "end", nullable = true)
    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Basic
    @Column(name = "explain", nullable = true, length = 50)
    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    @Basic
    @Column(name = "evel", nullable = true)
    public Integer getEvel() {
        return evel;
    }

    public void setEvel(Integer evel) {
        this.evel = evel;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "jindu", nullable = true)
    public Integer getJindu() {
        return jindu;
    }

    public void setJindu(Integer jindu) {
        this.jindu = jindu;
    }

    @Basic
    @Column(name = "ziping", nullable = true)
    public Integer getZiping() {
        return ziping;
    }

    public void setZiping(Integer ziping) {
        this.ziping = ziping;
    }

    @Basic
    @Column(name = "skaishi", nullable = true)
    public Date getSkaishi() {
        return skaishi;
    }

    public void setSkaishi(Date skaishi) {
        this.skaishi = skaishi;
    }

    @Basic
    @Column(name = "sjieshu", nullable = true)
    public Date getSjieshu() {
        return sjieshu;
    }

    public void setSjieshu(Date sjieshu) {
        this.sjieshu = sjieshu;
    }

    @Basic
    @Column(name = "cdate", nullable = true)
    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Myproject myproject = (Myproject) o;
        return Objects.equals(xid, myproject.xid) &&
                Objects.equals(xname, myproject.xname) &&
                Objects.equals(start, myproject.start) &&
                Objects.equals(end, myproject.end) &&
                Objects.equals(explain, myproject.explain) &&
                Objects.equals(evel, myproject.evel) &&
                Objects.equals(state, myproject.state) &&
                Objects.equals(jindu, myproject.jindu) &&
                Objects.equals(ziping, myproject.ziping) &&
                Objects.equals(skaishi, myproject.skaishi) &&
                Objects.equals(sjieshu, myproject.sjieshu) &&
                Objects.equals(cdate, myproject.cdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xid, xname, start, end, explain, evel, state, jindu, ziping, skaishi, sjieshu, cdate);
    }

    @OneToOne(mappedBy = "myproject")
    public Projectype getMytype() {
        return mytype;
    }

    public void setMytype(Projectype mytype) {
        this.mytype = mytype;
    }

    @OneToOne
    @JoinColumn(name = "empno", referencedColumnName = "eid")
    public Emp getMyfzr() {
        return myfzr;
    }

    public void setMyfzr(Emp myfzr) {
        this.myfzr = myfzr;
    }

    @OneToMany(mappedBy = "myprojects")
    public List<Mydynamic> getMyxiaoxi() {
        return myxiaoxi;
    }

    public void setMyxiaoxi(List<Mydynamic> myxiaoxi) {
        this.myxiaoxi = myxiaoxi;
    }

    @OneToMany(mappedBy = "projects")
    public List<Mycanyu> getCanyus() {
        return canyus;
    }

    public void setCanyus(List<Mycanyu> canyus) {
        this.canyus = canyus;
    }

    @OneToMany(mappedBy = "mproject")
    public List<Myrisk> getMrisk() {
        return mrisk;
    }

    public void setMrisk(List<Myrisk> mrisk) {
        this.mrisk = mrisk;
    }
}
