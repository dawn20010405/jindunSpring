package com.demo.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Title: Numset
 * Created by qqc on 2020/12/22
 */
@Entity
public class Numset {
    private Integer nid;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer num;

    @Id
    @Column(name = "nid", nullable = false)
    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    @Basic
    @Column(name = "year", nullable = true)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "month", nullable = true)
    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Basic
    @Column(name = "day", nullable = true)
    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Basic
    @Column(name = "num", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Numset numset = (Numset) o;

        if (nid != null ? !nid.equals(numset.nid) : numset.nid != null) return false;
        if (year != null ? !year.equals(numset.year) : numset.year != null) return false;
        if (month != null ? !month.equals(numset.month) : numset.month != null) return false;
        if (day != null ? !day.equals(numset.day) : numset.day != null) return false;
        if (num != null ? !num.equals(numset.num) : numset.num != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nid != null ? nid.hashCode() : 0;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        return result;
    }
}
