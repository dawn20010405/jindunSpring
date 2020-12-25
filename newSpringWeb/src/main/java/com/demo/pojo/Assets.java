package com.demo.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by qqc on 2020/12/21
 *
 */
@Entity
public class Assets {
    private Integer assetsid;
    private String assetsnum;
    private String assetsname;
    private String assetstype;
    private Integer assetsquantity;
    private Timestamp assetsretime;
    private String assetsgstatus;
    private BigDecimal assetsorivalue;
    private String assetsstatus;
    private List<Consumingdetails> conde;

    public Assets() {
    }

    public Assets(Integer assetsid, String assetsnum, String assetsname, String assetstype, Integer assetsquantity, Timestamp assetsretime, String assetsgstatus, BigDecimal assetsorivalue, String assetsstatus) {
        this.assetsid = assetsid;
        this.assetsnum = assetsnum;
        this.assetsname = assetsname;
        this.assetstype = assetstype;
        this.assetsquantity = assetsquantity;
        this.assetsretime = assetsretime;
        this.assetsgstatus = assetsgstatus;
        this.assetsorivalue = assetsorivalue;
        this.assetsstatus = assetsstatus;
    }

    @Id
    @Column(name = "assetsid", nullable = false)

    public Integer getAssetsid() {
        return assetsid;
    }

    public void setAssetsid(Integer assetsid) {
        this.assetsid = assetsid;
    }

    @Basic
    @Column(name = "assetsnum", nullable = true, length = 60)
    public String getAssetsnum() {
        return assetsnum;
    }

    public void setAssetsnum(String assetsnum) {
        this.assetsnum = assetsnum;
    }

    @Basic
    @Column(name = "assetsname", nullable = true, length = 60)
    public String getAssetsname() {
        return assetsname;
    }

    public void setAssetsname(String assetsname) {
        this.assetsname = assetsname;
    }

    @Basic
    @Column(name = "assetstype", nullable = true, length = 20)
    public String getAssetstype() {
        return assetstype;
    }

    public void setAssetstype(String assetstype) {
        this.assetstype = assetstype;
    }

    @Basic
    @Column(name = "assetsquantity", nullable = true)
    public Integer getAssetsquantity() {
        return assetsquantity;
    }

    public void setAssetsquantity(Integer assetsquantity) {
        this.assetsquantity = assetsquantity;
    }

    @Basic
    @Column(name = "assetsretime", nullable = true)
    public Timestamp getAssetsretime() {
        return assetsretime;
    }

    public void setAssetsretime(Timestamp assetsretime) {
        this.assetsretime = assetsretime;
    }

    @Basic
    @Column(name = "assetsgstatus", nullable = true, length = 20)
    public String getAssetsgstatus() {
        return assetsgstatus;
    }

    public void setAssetsgstatus(String assetsgstatus) {
        this.assetsgstatus = assetsgstatus;
    }

    @Basic
    @Column(name = "assetsorivalue", nullable = true, precision = 2)
    public BigDecimal getAssetsorivalue() {
        return assetsorivalue;
    }

    public void setAssetsorivalue(BigDecimal assetsorivalue) {
        this.assetsorivalue = assetsorivalue;
    }

    @Basic
    @Column(name = "assetsstatus", nullable = true, length = 20)
    public String getAssetsstatus() {
        return assetsstatus;
    }

    public void setAssetsstatus(String assetsstatus) {
        this.assetsstatus = assetsstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assets assets = (Assets) o;

        if (assetsid != null ? !assetsid.equals(assets.assetsid) : assets.assetsid != null) return false;
        if (assetsnum != null ? !assetsnum.equals(assets.assetsnum) : assets.assetsnum != null) return false;
        if (assetsname != null ? !assetsname.equals(assets.assetsname) : assets.assetsname != null) return false;
        if (assetstype != null ? !assetstype.equals(assets.assetstype) : assets.assetstype != null) return false;
        if (assetsquantity != null ? !assetsquantity.equals(assets.assetsquantity) : assets.assetsquantity != null)
            return false;
        if (assetsretime != null ? !assetsretime.equals(assets.assetsretime) : assets.assetsretime != null)
            return false;
        if (assetsgstatus != null ? !assetsgstatus.equals(assets.assetsgstatus) : assets.assetsgstatus != null)
            return false;
        if (assetsorivalue != null ? !assetsorivalue.equals(assets.assetsorivalue) : assets.assetsorivalue != null)
            return false;
        if (assetsstatus != null ? !assetsstatus.equals(assets.assetsstatus) : assets.assetsstatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = assetsid != null ? assetsid.hashCode() : 0;
        result = 31 * result + (assetsnum != null ? assetsnum.hashCode() : 0);
        result = 31 * result + (assetsname != null ? assetsname.hashCode() : 0);
        result = 31 * result + (assetstype != null ? assetstype.hashCode() : 0);
        result = 31 * result + (assetsquantity != null ? assetsquantity.hashCode() : 0);
        result = 31 * result + (assetsretime != null ? assetsretime.hashCode() : 0);
        result = 31 * result + (assetsgstatus != null ? assetsgstatus.hashCode() : 0);
        result = 31 * result + (assetsorivalue != null ? assetsorivalue.hashCode() : 0);
        result = 31 * result + (assetsstatus != null ? assetsstatus.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "assets")
    public List<Consumingdetails> getConde() {
        return conde;
    }

    public void setConde(List<Consumingdetails> conde) {
        this.conde = conde;
    }
}
