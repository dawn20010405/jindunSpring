/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 16:55 2020-12-21
 * @ Description：
 */
package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: Administrator
 * @Date: 2020-12-21 16:55
 * @Description:
 */
@Entity
public class Emp {
    private Integer eid;
    private String ename;
    private Timestamp erutime;
    private String eiphone;
    private List<Transfer> myreansfer;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(eid, emp.eid) &&
                Objects.equals(ename, emp.ename) &&
                Objects.equals(erutime, emp.erutime) &&
                Objects.equals(eiphone, emp.eiphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eid, ename, erutime, eiphone);
    }

    @OneToMany(mappedBy = "myemp")
    public List<Transfer> getMyreansfer() {
        return myreansfer;
    }

    public void setMyreansfer(List<Transfer> myreansfer) {
        this.myreansfer = myreansfer;
    }
}
