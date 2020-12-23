package com.demo.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author: diga
 * <p>
 * Description: 招聘类
 * date: 2020/12/22 19:04
 */
@Entity
public class Recruitment {
    private Integer rid;
    private Date hopetime;
    private Integer peopcout;
    private String recrudemand;
    private Integer retype;
    private Position posi;
    private Date rcreate;
    private Resume resum;

    @Id
    @Column(name = "rid", nullable = false)
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "hopetime", nullable = false)
    public Date getHopetime() {
        return hopetime;
    }

    public void setHopetime(Date hopetime) {
        this.hopetime = hopetime;
    }

    @Basic
    @Column(name = "peopcout", nullable = false)
    public Integer getPeopcout() {
        return peopcout;
    }

    public void setPeopcout(Integer peopcout) {
        this.peopcout = peopcout;
    }

    @Basic
    @Column(name = "recrudemand", nullable = true, length = 255)
    public String getRecrudemand() {
        return recrudemand;
    }

    public void setRecrudemand(String recrudemand) {
        this.recrudemand = recrudemand;
    }

    @Basic
    @Column(name = "retype", nullable = false)
    public Integer getRetype() {
        return retype;
    }

    public void setRetype(Integer retype) {
        this.retype = retype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruitment that = (Recruitment) o;
        return Objects.equals(rid, that.rid) &&
                Objects.equals(hopetime, that.hopetime) &&
                Objects.equals(peopcout, that.peopcout) &&
                Objects.equals(recrudemand, that.recrudemand) &&
                Objects.equals(rcreate, that.rcreate) &&
                Objects.equals(retype, that.retype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rid, hopetime, peopcout, recrudemand,rcreate, retype);
    }

    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    public Position getPosi() {
        return posi;
    }

    public void setPosi(Position posi) {
        this.posi = posi;
    }

    @Basic
    @Column(name = "rcreate", nullable = false)
    public Date getRcreate() {
        return rcreate;
    }

    public void setRcreate(Date rcreate) {
        this.rcreate = rcreate;
    }

    @OneToOne(mappedBy = "recru")
    public Resume getResum() {
        return resum;
    }

    public void setResum(Resume resum) {
        this.resum = resum;
    }
}
