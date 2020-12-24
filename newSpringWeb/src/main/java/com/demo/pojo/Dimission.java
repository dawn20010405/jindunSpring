/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 16:55 2020-12-21
 * @ Description：
 */
package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp dimissiontime;
    private Emp myemp;
    private String dshenpi;
    private String dzong;

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

    @Basic
    @Column(name = "dshenpi", nullable = true, length = 255)
    public String getDshenpi() {
        return dshenpi;
    }

    public void setDshenpi(String dshenpi) {
        this.dshenpi = dshenpi;
    }

    @Basic
    @Column(name = "dzong", nullable = true, length = 255)
    public String getDzong() {
        return dzong;
    }

    public void setDzong(String dzong) {
        this.dzong = dzong;
    }

}
