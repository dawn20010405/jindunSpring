package com.demo.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * Description: <br/>
 * date: 2020/12/21 23:17<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */
@Entity
public class Interview {
    private Integer iid;
    private Integer intype;
    private Date intime;
    private String inaddress;
    private Resume resu;
    private Integer rsid;
    private Intrecord inrd;

    @Id
    @Column(name = "iid", nullable = false)
    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    @Basic
    @Column(name = "intype", nullable = false)
    public Integer getIntype() {
        return intype;
    }

    public void setIntype(Integer intype) {
        this.intype = intype;
    }

    @Basic
    @Column(name = "intime", nullable = false)
    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    @Basic
    @Column(name = "inaddress", nullable = false, length = 255)
    public String getInaddress() {
        return inaddress;
    }

    public void setInaddress(String inaddress) {
        this.inaddress = inaddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return Objects.equals(iid, interview.iid) &&
                Objects.equals(intype, interview.intype) &&
                Objects.equals(intime, interview.intime) &&
                Objects.equals(inaddress, interview.inaddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, intype, intime, inaddress);
    }

    @OneToOne(mappedBy = "inter")
    public Resume getResu() {
        return resu;
    }

    public void setResu(Resume resu) {
        this.resu = resu;
    }

    @Basic
    @Column(name = "rsid", nullable = true)
    public Integer getRsid() {
        return rsid;
    }

    public void setRsid(Integer rsid) {
        this.rsid = rsid;
    }

    @OneToOne
    @JoinColumn(name = "iid", referencedColumnName = "iid", nullable = false)
    public Intrecord getInrd() {
        return inrd;
    }

    public void setInrd(Intrecord inrd) {
        this.inrd = inrd;
    }
}
