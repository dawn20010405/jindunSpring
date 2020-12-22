/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 21:20 2020-12-21
 * @ Description：
 */
package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Auther: Administrator
 * @Date: 2020-12-21 21:20
 * @Description:
 */
@Entity
public class Emp {
    private Integer eid;
    private String ename;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp erutime;
    private String eiphone;
    private String epass;
    private Just myjust;
    private Transfer mytransfer;
    private Dimission mydimission;
    private Position myposition;

    @Id
    @Column(name = "eid", nullable = false)
    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "ename", nullable = false, length = 255)
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "erutime", nullable = false)
    public Timestamp getErutime() {
        return erutime;
    }

    public void setErutime(Timestamp erutime) {
        this.erutime = erutime;
    }

    @Basic
    @Column(name = "eiphone", nullable = true, length = 11)
    public String getEiphone() {
        return eiphone;
    }

    public void setEiphone(String eiphone) {
        this.eiphone = eiphone;
    }

    @Basic
    @Column(name = "epass", nullable = true, length = 30)
    public String getEpass() {
        return epass;
    }

    public void setEpass(String epass) {
        this.epass = epass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(eid, emp.eid) &&
                Objects.equals(ename, emp.ename) &&
                Objects.equals(erutime, emp.erutime) &&
                Objects.equals(eiphone, emp.eiphone) &&
                Objects.equals(epass, emp.epass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eid, ename, erutime, eiphone, epass);
    }

    @OneToOne
    @JoinColumn(name = "jid", referencedColumnName = "jid")
    public Just getMyjust() {
        return myjust;
    }

    public void setMyjust(Just myjust) {
        this.myjust = myjust;
    }

    @OneToOne
    @JoinColumn(name = "tid", referencedColumnName = "tids")
    public Transfer getMytransfer() {
        return mytransfer;
    }

    public void setMytransfer(Transfer mytransfer) {
        this.mytransfer = mytransfer;
    }

    @OneToOne
    @JoinColumn(name = "did", referencedColumnName = "dimid")
    public Dimission getMydimission() {
        return mydimission;
    }

    public void setMydimission(Dimission mydimission) {
        this.mydimission = mydimission;
    }

    @OneToOne
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    public Position getMyposition() {
        return myposition;
    }

    public void setMyposition(Position myposition) {
        this.myposition = myposition;
    }
}
