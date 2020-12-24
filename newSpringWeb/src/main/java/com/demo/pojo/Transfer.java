/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 16:56 2020-12-21
 * @ Description：
 */
package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Auther: Administrator
 * @Date: 2020-12-21 16:56
 * @Description:
 */
@Entity
public class Transfer {
    private Integer tids;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
    private Timestamp transfertime;
    private Emp myemp;
    private String tzong;
    private Integer tsehngpi;
    private Position myposition;

    @ManyToOne
    @JoinColumn(name = "eid", referencedColumnName = "eid")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }

    @Id
    @Column(name = "tids", nullable = false)
    public Integer getTids() {
        return tids;
    }

    public void setTids(Integer tids) {
        this.tids = tids;
    }

    @Basic
    @Column(name = "transfertime", nullable = false)
    public Timestamp getTransfertime() {
        return transfertime;
    }

    public void setTransfertime(Timestamp transfertime) {
        this.transfertime = transfertime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return Objects.equals(tids, transfer.tids) &&
                Objects.equals(transfertime, transfer.transfertime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tids, transfertime);
    }

    @Basic
    @Column(name = "tzong", nullable = true, length = 255)
    public String getTzong() {
        return tzong;
    }

    public void setTzong(String tzong) {
        this.tzong = tzong;
    }

    @Basic
    @Column(name = "tsehngpi", nullable = true, length = 255)
    public Integer getTsehngpi() {
        return tsehngpi;
    }

    public void setTsehngpi(Integer tsehngpi) {
        this.tsehngpi = tsehngpi;
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
