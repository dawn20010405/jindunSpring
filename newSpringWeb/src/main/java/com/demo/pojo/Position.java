package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Description: 岗位类
 * date: 2020/12/21 22:56、
 * @author diga
 */
@Entity
public class Position {
    private Integer pid;
    private String poname;
    private Integer ptype;
    private Dept dept;
    private List<Resume> rsid;

    private Emp myemp;
    private Transfer mytransfer;
    private Dimission mydimission;

    @Id
    @Column(name = "pid", nullable = false)
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "poname", nullable = false, length = 255)
    public String getPoname() {
        return poname;
    }

    public void setPoname(String poname) {
        this.poname = poname;
    }

    @Basic
    @Column(name = "ptype", nullable = false)
    public Integer getPtype() {
        return ptype;
    }

    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(pid, position.pid) &&
                Objects.equals(poname, position.poname) &&
                Objects.equals(ptype, position.ptype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, poname, ptype);
    }

    @ManyToOne
    @JoinColumn(name = "did", referencedColumnName = "did")
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @OneToMany(mappedBy = "posi")
    public List<Resume> getRsid() {
        return rsid;
    }

    public void setRsid(List<Resume> rsid) {
        this.rsid = rsid;
    }

    @OneToOne(mappedBy = "myposition")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }

    @OneToOne(mappedBy = "myposition")
    public Transfer getMytransfer() {
        return mytransfer;
    }

    public void setMytransfer(Transfer mytransfer) {
        this.mytransfer = mytransfer;
    }

    @OneToOne
    @JoinColumn(name = "pid", referencedColumnName = "pid", nullable = false)
    public Dimission getMydimission() {
        return mydimission;
    }

    public void setMydimission(Dimission mydimission) {
        this.mydimission = mydimission;
    }
}
