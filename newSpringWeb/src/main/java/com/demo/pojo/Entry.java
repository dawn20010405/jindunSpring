package com.demo.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 * Description: 入职类
 * date: 2020/12/21 23:31
 * @author diga
 */
@Entity
public class Entry {
    private Integer enid;
    private BigDecimal emoney;
    private Date gotime;
    private Date creatime;
    private Resume resu;

    @Id
    @Column(name = "enid", nullable = false)
    public Integer getEnid() {
        return enid;
    }

    public void setEnid(Integer enid) {
        this.enid = enid;
    }

    @Basic
    @Column(name = "emoney", nullable = false, precision = 2)
    public BigDecimal getEmoney() {
        return emoney;
    }

    public void setEmoney(BigDecimal emoney) {
        this.emoney = emoney;
    }

    @Basic
    @Column(name = "gotime", nullable = true)
    public Date getGotime() {
        return gotime;
    }

    public void setGotime(Date gotime) {
        this.gotime = gotime;
    }

    @Basic
    @Column(name = "creatime", nullable = true)
    public Date getCreatime() {
        return creatime;
    }

    public void setCreatime(Date creatime) {
        this.creatime = creatime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(enid, entry.enid) &&
                Objects.equals(emoney, entry.emoney) &&
                Objects.equals(gotime, entry.gotime) &&
                Objects.equals(creatime, entry.creatime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enid, emoney, gotime, creatime);
    }

    @OneToOne(mappedBy = "enty")
    public Resume getResu() {
        return resu;
    }

    public void setResu(Resume resu) {
        this.resu = resu;
    }
}
