package com.demo.pojo;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by qqc on 2020/12/21
 */
@Entity
public class Actualpurdetails {
    private Integer actualpurdetailsid;

    private String acputdename;
    private String acputdecname;
    private Integer acputdequantity;
    private String acputdeunit;
    private BigDecimal acputdeactual;
    private Integer acputdeactualall;
    private String acputdefollow;
    private Purchase purchase;

    @Id
    @Column(name = "actualpurdetailsid", nullable = false)
    public Integer getActualpurdetailsid() {
        return actualpurdetailsid;
    }

    public void setActualpurdetailsid(Integer actualpurdetailsid) {
        this.actualpurdetailsid = actualpurdetailsid;
    }



    @Basic
    @Column(name = "acputdename", nullable = true, length = 60)
    public String getAcputdename() {
        return acputdename;
    }

    public void setAcputdename(String acputdename) {
        this.acputdename = acputdename;
    }

    @Basic
    @Column(name = "acputdecname", nullable = true, length = 60)
    public String getAcputdecname() {
        return acputdecname;
    }

    public void setAcputdecname(String acputdecname) {
        this.acputdecname = acputdecname;
    }

    @Basic
    @Column(name = "acputdequantity", nullable = true)
    public Integer getAcputdequantity() {
        return acputdequantity;
    }

    public void setAcputdequantity(Integer acputdequantity) {
        this.acputdequantity = acputdequantity;
    }

    @Basic
    @Column(name = "acputdeunit", nullable = true, length = 20)
    public String getAcputdeunit() {
        return acputdeunit;
    }

    public void setAcputdeunit(String acputdeunit) {
        this.acputdeunit = acputdeunit;
    }

    @Basic
    @Column(name = "acputdeactual", nullable = true, precision = 2)
    public BigDecimal getAcputdeactual() {
        return acputdeactual;
    }

    public void setAcputdeactual(BigDecimal acputdeactual) {
        this.acputdeactual = acputdeactual;
    }

    @Basic
    @Column(name = "acputdeactualall", nullable = true, precision = 0)
    public Integer getAcputdeactualall() {
        return acputdeactualall;
    }

    public void setAcputdeactualall(Integer acputdeactualall) {
        this.acputdeactualall = acputdeactualall;
    }

    @Basic
    @Column(name = "acputdefollow", nullable = true, length = 60)
    public String getAcputdefollow() {
        return acputdefollow;
    }

    public void setAcputdefollow(String acputdefollow) {
        this.acputdefollow = acputdefollow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actualpurdetails that = (Actualpurdetails) o;

        if (actualpurdetailsid != null ? !actualpurdetailsid.equals(that.actualpurdetailsid) : that.actualpurdetailsid != null)
            return false;

        if (acputdename != null ? !acputdename.equals(that.acputdename) : that.acputdename != null) return false;
        if (acputdecname != null ? !acputdecname.equals(that.acputdecname) : that.acputdecname != null) return false;
        if (acputdequantity != null ? !acputdequantity.equals(that.acputdequantity) : that.acputdequantity != null)
            return false;
        if (acputdeunit != null ? !acputdeunit.equals(that.acputdeunit) : that.acputdeunit != null) return false;
        if (acputdeactual != null ? !acputdeactual.equals(that.acputdeactual) : that.acputdeactual != null)
            return false;
        if (acputdeactualall != null ? !acputdeactualall.equals(that.acputdeactualall) : that.acputdeactualall != null)
            return false;
        if (acputdefollow != null ? !acputdefollow.equals(that.acputdefollow) : that.acputdefollow != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actualpurdetailsid != null ? actualpurdetailsid.hashCode() : 0;

        result = 31 * result + (acputdename != null ? acputdename.hashCode() : 0);
        result = 31 * result + (acputdecname != null ? acputdecname.hashCode() : 0);
        result = 31 * result + (acputdequantity != null ? acputdequantity.hashCode() : 0);
        result = 31 * result + (acputdeunit != null ? acputdeunit.hashCode() : 0);
        result = 31 * result + (acputdeactual != null ? acputdeactual.hashCode() : 0);
        result = 31 * result + (acputdeactualall != null ? acputdeactualall.hashCode() : 0);
        result = 31 * result + (acputdefollow != null ? acputdefollow.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "acputdepuid", referencedColumnName = "purchaseid")
    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
