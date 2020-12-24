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
public class Contracts {
    private Integer cids;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp ckaitime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp cjietime;
    private Integer cqixian;
    private String cleixing;
    private Integer cmoney;
    private Emp myemp;

    @Id
    @Column(name = "cids", nullable = false)
    public Integer getCids() {
        return cids;
    }

    public void setCids(Integer cids) {
        this.cids = cids;
    }

    @Basic
    @Column(name = "ckaitime", nullable = false)
    public Timestamp getCkaitime() {
        return ckaitime;
    }

    public void setCkaitime(Timestamp ckaitime) {
        this.ckaitime = ckaitime;
    }

    @Basic
    @Column(name = "cjietime", nullable = false)
    public Timestamp getCjietime() {
        return cjietime;
    }

    public void setCjietime(Timestamp cjietime) {
        this.cjietime = cjietime;
    }

    @Basic
    @Column(name = "cqixian", nullable = false)
    public Integer getCqixian() {
        return cqixian;
    }

    public void setCqixian(Integer cqixian) {
        this.cqixian = cqixian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contracts contracts = (Contracts) o;
        return Objects.equals(cids, contracts.cids) &&
                Objects.equals(ckaitime, contracts.ckaitime) &&
                Objects.equals(cjietime, contracts.cjietime) &&
                Objects.equals(cqixian, contracts.cqixian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cids, ckaitime, cjietime, cqixian);
    }

    @Basic
    @Column(name = "cleixing", nullable = true, length = 255)
    public String getCleixing() {
        return cleixing;
    }

    public void setCleixing(String cleixing) {
        this.cleixing = cleixing;
    }

    @Basic
    @Column(name = "cmoney", nullable = true)
    public Integer getCmoney() {
        return cmoney;
    }

    public void setCmoney(Integer cmoney) {
        this.cmoney = cmoney;
    }

    @OneToOne
    @JoinColumn(name = "eid", referencedColumnName = "eid")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }
}
