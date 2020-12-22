package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName: Mycanyu
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-21 21:30
 * @Version: v1.0
 */
@Entity
public class Mycanyu {
    private Integer cid;
    private Emp myemps;
    private Myproject projects;

    @Id
    @Column(name = "cid", nullable = false)
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mycanyu mycanyu = (Mycanyu) o;
        return Objects.equals(cid, mycanyu.cid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid);
    }

    @ManyToOne
    @JoinColumn(name = "empno", referencedColumnName = "eid")
    public Emp getMyemps() {
        return myemps;
    }

    public void setMyemps(Emp myemps) {
        this.myemps = myemps;
    }

    @ManyToOne
    @JoinColumn(name = "xid", referencedColumnName = "xid")
    public Myproject getProjects() {
        return projects;
    }

    public void setProjects(Myproject projects) {
        this.projects = projects;
    }
}
