package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * Description: 面试记录类
 * date: 2020/12/21 23:19
 * @author diga
 */
@Entity
public class Intrecord {
    private Integer irid;
    private Integer iresult;
    private String iremark;
    private Interview invw;

    @Id
    @Column(name = "irid", nullable = false)
    public Integer getIrid() {
        return irid;
    }

    public void setIrid(Integer irid) {
        this.irid = irid;
    }

    @Basic
    @Column(name = "iresult", nullable = false)
    public Integer getIresult() {
        return iresult;
    }

    public void setIresult(Integer iresult) {
        this.iresult = iresult;
    }

    @Basic
    @Column(name = "iremark", nullable = true, length = 255)
    public String getIremark() {
        return iremark;
    }

    public void setIremark(String iremark) {
        this.iremark = iremark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intrecord intrecord = (Intrecord) o;
        return Objects.equals(irid, intrecord.irid) &&
                Objects.equals(iresult, intrecord.iresult) &&
                Objects.equals(iremark, intrecord.iremark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(irid, iresult, iremark);
    }

    @OneToOne(mappedBy = "inrd")
    public Interview getInvw() {
        return invw;
    }

    public void setInvw(Interview invw) {
        this.invw = invw;
    }
}
