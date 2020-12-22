package com.demo.pojo;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by qqc on 2020/12/21
 */
@Entity
public class Purdetaisl {
    private Integer purdetaislid;

    private String pudegname;
    private String pudecname;
    private Integer pudenum;
    private String pudeunit;
    private BigDecimal pudeexpect;
    private BigDecimal pudeexpectall;
    private String pudefollow;
    private Purchase purchase;

    @Id
    @Column(name = "purdetaislid", nullable = false)
    public Integer getPurdetaislid() {
        return purdetaislid;
    }

    public void setPurdetaislid(Integer purdetaislid) {
        this.purdetaislid = purdetaislid;
    }



    @Basic
    @Column(name = "pudegname", nullable = true, length = 60)
    public String getPudegname() {
        return pudegname;
    }

    public void setPudegname(String pudegname) {
        this.pudegname = pudegname;
    }

    @Basic
    @Column(name = "pudecname", nullable = true, length = 60)
    public String getPudecname() {
        return pudecname;
    }

    public void setPudecname(String pudecname) {
        this.pudecname = pudecname;
    }

    @Basic
    @Column(name = "pudenum", nullable = true)
    public Integer getPudenum() {
        return pudenum;
    }

    public void setPudenum(Integer pudenum) {
        this.pudenum = pudenum;
    }

    @Basic
    @Column(name = "pudeunit", nullable = true, length = 20)
    public String getPudeunit() {
        return pudeunit;
    }

    public void setPudeunit(String pudeunit) {
        this.pudeunit = pudeunit;
    }

    @Basic
    @Column(name = "pudeexpect", nullable = true, precision = 2)
    public BigDecimal getPudeexpect() {
        return pudeexpect;
    }

    public void setPudeexpect(BigDecimal pudeexpect) {
        this.pudeexpect = pudeexpect;
    }

    @Basic
    @Column(name = "pudeexpectall", nullable = true, precision = 2)
    public BigDecimal getPudeexpectall() {
        return pudeexpectall;
    }

    public void setPudeexpectall(BigDecimal pudeexpectall) {
        this.pudeexpectall = pudeexpectall;
    }

    @Basic
    @Column(name = "pudefollow", nullable = true, length = 60)
    public String getPudefollow() {
        return pudefollow;
    }

    public void setPudefollow(String pudefollow) {
        this.pudefollow = pudefollow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purdetaisl that = (Purdetaisl) o;

        if (purdetaislid != null ? !purdetaislid.equals(that.purdetaislid) : that.purdetaislid != null) return false;

        if (pudegname != null ? !pudegname.equals(that.pudegname) : that.pudegname != null) return false;
        if (pudecname != null ? !pudecname.equals(that.pudecname) : that.pudecname != null) return false;
        if (pudenum != null ? !pudenum.equals(that.pudenum) : that.pudenum != null) return false;
        if (pudeunit != null ? !pudeunit.equals(that.pudeunit) : that.pudeunit != null) return false;
        if (pudeexpect != null ? !pudeexpect.equals(that.pudeexpect) : that.pudeexpect != null) return false;
        if (pudeexpectall != null ? !pudeexpectall.equals(that.pudeexpectall) : that.pudeexpectall != null)
            return false;
        if (pudefollow != null ? !pudefollow.equals(that.pudefollow) : that.pudefollow != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = purdetaislid != null ? purdetaislid.hashCode() : 0;

        result = 31 * result + (pudegname != null ? pudegname.hashCode() : 0);
        result = 31 * result + (pudecname != null ? pudecname.hashCode() : 0);
        result = 31 * result + (pudenum != null ? pudenum.hashCode() : 0);
        result = 31 * result + (pudeunit != null ? pudeunit.hashCode() : 0);
        result = 31 * result + (pudeexpect != null ? pudeexpect.hashCode() : 0);
        result = 31 * result + (pudeexpectall != null ? pudeexpectall.hashCode() : 0);
        result = 31 * result + (pudefollow != null ? pudefollow.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "pudepuid", referencedColumnName = "purchaseid")
    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
