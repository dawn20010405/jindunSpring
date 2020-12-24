package com.demo.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * Description: 简历类
 * date: 2020/12/21 23:01
 * @author diga
 */
@Entity
public class Resume {
    private Integer rsid;
    private String rname;
    private Integer rsex;
    private Date rbirthday;
    private String workyear;
    private String education;
    private Date createdate;
    private Integer rstype;
    private Interview inter;
    private Entry enty;
    private Recruitment recru;

    @Id
    @Column(name = "rsid", nullable = false)
    public Integer getRsid() {
        return rsid;
    }

    public void setRsid(Integer rsid) {
        this.rsid = rsid;
    }

    @Basic
    @Column(name = "rname", nullable = false, length = 255)
    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Basic
    @Column(name = "rsex", nullable = true)
    public Integer getRsex() {
        return rsex;
    }

    public void setRsex(Integer rsex) {
        this.rsex = rsex;
    }

    @Basic
    @Column(name = "rbirthday", nullable = true)
    public Date getRbirthday() {
        return rbirthday;
    }

    public void setRbirthday(Date rbirthday) {
        this.rbirthday = rbirthday;
    }

    @Basic
    @Column(name = "workyear", nullable = false, length = 255)
    public String getWorkyear() {
        return workyear;
    }

    public void setWorkyear(String workyear) {
        this.workyear = workyear;
    }

    @Basic
    @Column(name = "education", nullable = false, length = 255)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "createdate", nullable = false)
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Basic
    @Column(name = "rstype", nullable = true)
    public Integer getRstype() {
        return rstype;
    }

    public void setRstype(Integer rstype) {
        this.rstype = rstype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(rsid, resume.rsid) &&
                Objects.equals(rname, resume.rname) &&
                Objects.equals(rsex, resume.rsex) &&
                Objects.equals(rbirthday, resume.rbirthday) &&
                Objects.equals(workyear, resume.workyear) &&
                Objects.equals(education, resume.education) &&
                Objects.equals(rstype, resume.rstype) &&
                Objects.equals(createdate, resume.createdate);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "rsid=" + rsid +
                ", rname='" + rname + '\'' +
                ", rsex=" + rsex +
                ", rbirthday=" + rbirthday +
                ", workyear='" + workyear + '\'' +
                ", education='" + education + '\'' +
                ", createdate=" + createdate + '\'' +
                ", rstype=" + rstype +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(rsid, rname, rsex, rbirthday, workyear, education, createdate,rstype);
    }

    @OneToOne
    @JoinColumn(name = "rsid", referencedColumnName = "rsid", nullable = false)
    public Interview getInter() {
        return inter;
    }

    public void setInter(Interview inter) {
        this.inter = inter;
    }

    @OneToOne
    @JoinColumn(name = "rsid", referencedColumnName = "rsid", nullable = false)
    public Entry getEnty() {
        return enty;
    }

    public void setEnty(Entry enty) {
        this.enty = enty;
    }

    @OneToOne
    @JoinColumn(name = "rid", referencedColumnName = "rid")
    public Recruitment getRecru() {
        return recru;
    }

    public void setRecru(Recruitment recru) {
        this.recru = recru;
    }
}
