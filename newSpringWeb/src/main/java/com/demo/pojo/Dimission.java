/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 16:55 2020-12-21
 * @ Description：
 */
package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Auther: Administrator
 * @Date: 2020-12-21 16:55
 * @Description:
 */
@Entity
public class Dimission {
    private Integer dimid;
    private Timestamp dimissiontime;
    private Emp myemp;

    @Id
    @Column(name = "dimid", nullable = false)
    public Integer getDimid() {
        return dimid;
    }

    public void setDimid(Integer dimid) {
        this.dimid = dimid;
    }

    @Basic
    @Column(name = "dimissiontime", nullable = false)
    public Timestamp getDimissiontime() {
        return dimissiontime;
    }

    public void setDimissiontime(Timestamp dimissiontime) {
        this.dimissiontime = dimissiontime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimission dimission = (Dimission) o;
        return Objects.equals(dimid, dimission.dimid) &&
                Objects.equals(dimissiontime, dimission.dimissiontime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimid, dimissiontime);
    }

    @OneToOne(mappedBy = "mydimission")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }
}
