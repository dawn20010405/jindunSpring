package com.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by qqc on 2020/12/21
 */
@Entity
public class Consumingdetails {
    private Integer consumingdetailsid;
    private String codename;
    private String codedept;
    private String codetype;
    private String codestatus;
    private Timestamp codestart;
    private Integer codesquantity;
    private Assets assets;
    private Exchangeassets exassets;
    private Emp emp;

    @Id
    @Column(name = "consumingdetailsid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getConsumingdetailsid() {
        return consumingdetailsid;
    }

    public void setConsumingdetailsid(Integer consumingdetailsid) {
        this.consumingdetailsid = consumingdetailsid;
    }

    @Basic
    @Column(name = "codename", nullable = true, length = 60)
    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    @Basic
    @Column(name = "codesquantity", nullable = true)
    public Integer getCodesquantity() {
        return codesquantity;
    }

    public void setCodesquantity(Integer codesquantity) {
        this.codesquantity = codesquantity;
    }

    @Basic
    @Column(name = "codedept", nullable = true, length = 60)
    public String getCodedept() {
        return codedept;
    }

    public void setCodedept(String codedept) {
        this.codedept = codedept;
    }

    @Basic
    @Column(name = "codetype", nullable = true, length = 20)
    public String getCodetype() {
        return codetype;
    }

    public void setCodetype(String codetype) {
        this.codetype = codetype;
    }

    @Basic
    @Column(name = "codestatus", nullable = true, length = 20)
    public String getCodestatus() {
        return codestatus;
    }

    public void setCodestatus(String codestatus) {
        this.codestatus = codestatus;
    }

    @Basic
    @Column(name = "codestart", nullable = true)
    public Timestamp getCodestart() {
        return codestart;
    }

    public void setCodestart(Timestamp codestart) {
        this.codestart = codestart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumingdetails that = (Consumingdetails) o;
        if (consumingdetailsid != null ? !consumingdetailsid.equals(that.consumingdetailsid) : that.consumingdetailsid != null)
            return false;
        if (codename != null ? !codename.equals(that.codename) : that.codename != null) return false;
        if (codesquantity != null ? !codesquantity.equals(that.codesquantity) : that.codesquantity != null) return false;
        if (codedept != null ? !codedept.equals(that.codedept) : that.codedept != null) return false;
        if (codetype != null ? !codetype.equals(that.codetype) : that.codetype != null) return false;
        if (codestatus != null ? !codestatus.equals(that.codestatus) : that.codestatus != null) return false;
        if (codestart != null ? !codestart.equals(that.codestart) : that.codestart != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = consumingdetailsid != null ? consumingdetailsid.hashCode() : 0;
        result = 31 * result + (codename != null ? codename.hashCode() : 0);
        result = 31 * result + (codedept != null ? codedept.hashCode() : 0);
        result = 31 * result + (codetype != null ? codetype.hashCode() : 0);
        result = 31 * result + (codesquantity != null ? codesquantity.hashCode() : 0);
        result = 31 * result + (codestatus != null ? codestatus.hashCode() : 0);
        result = 31 * result + (codestart != null ? codestart.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "codeassetsid", referencedColumnName = "assetsid")
    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    @ManyToOne
    @JoinColumn(name = "conexasid", referencedColumnName = "exchangeassetsid")
    public Exchangeassets getExassets() {
        return exassets;
    }

    public void setExassets(Exchangeassets exassets) {
        this.exassets = exassets;
    }

    @ManyToOne
    @JoinColumn(name = "codeempid", referencedColumnName = "eid")
    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }
}
