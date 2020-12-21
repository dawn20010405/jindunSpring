/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 16:56 2020-12-21
 * @ Description：
 */
package com.demo.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Auther: Administrator
 * @Date: 2020-12-21 16:56
 * @Description:
 */
@Entity
public class Just {
    private Integer jid;
    private Timestamp justtime;

    @Id
    @Column(name = "jid", nullable = false)
    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    @Basic
    @Column(name = "justtime", nullable = false)
    public Timestamp getJusttime() {
        return justtime;
    }

    public void setJusttime(Timestamp justtime) {
        this.justtime = justtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Just just = (Just) o;
        return Objects.equals(jid, just.jid) &&
                Objects.equals(justtime, just.justtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jid, justtime);
    }
}
