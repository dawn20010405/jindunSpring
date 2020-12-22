package com.demo.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by qqc on 2020/12/21
 */
@Entity
public class Purchase {
    private Integer purchaseid;
    private String purchasename;
    private Integer purchaseempid;
    private String purchasedept;
    private BigDecimal purchasemoney;
    private String purchasereson;
    private String purchasetype;
    private Timestamp purchasestart;
    private List<Actualpurdetails> acpurchase;
    private List<Purdetaisl> depurchase;

    @Id
    @Column(name = "purchaseid", nullable = false)
    public Integer getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(Integer purchaseid) {
        this.purchaseid = purchaseid;
    }

    @Basic
    @Column(name = "purchasename", nullable = true, length = 60)
    public String getPurchasename() {
        return purchasename;
    }

    public void setPurchasename(String purchasename) {
        this.purchasename = purchasename;
    }

    @Basic
    @Column(name = "purchaseempid", nullable = true)
    public Integer getPurchaseempid() {
        return purchaseempid;
    }

    public void setPurchaseempid(Integer purchaseempid) {
        this.purchaseempid = purchaseempid;
    }

    @Basic
    @Column(name = "purchasedept", nullable = true, length = 30)
    public String getPurchasedept() {
        return purchasedept;
    }

    public void setPurchasedept(String purchasedept) {
        this.purchasedept = purchasedept;
    }

    @Basic
    @Column(name = "purchasemoney", nullable = true, precision = 2)
    public BigDecimal getPurchasemoney() {
        return purchasemoney;
    }

    public void setPurchasemoney(BigDecimal purchasemoney) {
        this.purchasemoney = purchasemoney;
    }

    @Basic
    @Column(name = "purchasereson", nullable = true, length = 60)
    public String getPurchasereson() {
        return purchasereson;
    }

    public void setPurchasereson(String purchasereson) {
        this.purchasereson = purchasereson;
    }

    @Basic
    @Column(name = "purchasetype", nullable = true, length = 20)
    public String getPurchasetype() {
        return purchasetype;
    }

    public void setPurchasetype(String purchasetype) {
        this.purchasetype = purchasetype;
    }

    @Basic
    @Column(name = "purchasestart", nullable = true)
    public Timestamp getPurchasestart() {
        return purchasestart;
    }

    public void setPurchasestart(Timestamp purchasestart) {
        this.purchasestart = purchasestart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (purchaseid != null ? !purchaseid.equals(purchase.purchaseid) : purchase.purchaseid != null) return false;
        if (purchasename != null ? !purchasename.equals(purchase.purchasename) : purchase.purchasename != null)
            return false;
        if (purchaseempid != null ? !purchaseempid.equals(purchase.purchaseempid) : purchase.purchaseempid != null)
            return false;
        if (purchasedept != null ? !purchasedept.equals(purchase.purchasedept) : purchase.purchasedept != null)
            return false;
        if (purchasemoney != null ? !purchasemoney.equals(purchase.purchasemoney) : purchase.purchasemoney != null)
            return false;
        if (purchasereson != null ? !purchasereson.equals(purchase.purchasereson) : purchase.purchasereson != null)
            return false;
        if (purchasetype != null ? !purchasetype.equals(purchase.purchasetype) : purchase.purchasetype != null)
            return false;
        if (purchasestart != null ? !purchasestart.equals(purchase.purchasestart) : purchase.purchasestart != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = purchaseid != null ? purchaseid.hashCode() : 0;
        result = 31 * result + (purchasename != null ? purchasename.hashCode() : 0);
        result = 31 * result + (purchaseempid != null ? purchaseempid.hashCode() : 0);
        result = 31 * result + (purchasedept != null ? purchasedept.hashCode() : 0);
        result = 31 * result + (purchasemoney != null ? purchasemoney.hashCode() : 0);
        result = 31 * result + (purchasereson != null ? purchasereson.hashCode() : 0);
        result = 31 * result + (purchasetype != null ? purchasetype.hashCode() : 0);
        result = 31 * result + (purchasestart != null ? purchasestart.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "purchase")
    public List<Actualpurdetails> getAcpurchase() {
        return acpurchase;
    }

    public void setAcpurchase(List<Actualpurdetails> acpurchase) {
        this.acpurchase = acpurchase;
    }

    @OneToMany(mappedBy = "purchase")
    public List<Purdetaisl> getDepurchase() {
        return depurchase;
    }

    public void setDepurchase(List<Purdetaisl> depurchase) {
        this.depurchase = depurchase;
    }
}
