/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 21:32 2020-12-21
 * @ Description：
 */
package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Auther: Administrator
 * @Date: 2020-12-21 21:32
 * @Description:
 */
@Entity
public class Dept {
    private Integer did;
    private String dname;



    @Id
    @Column(name = "did", nullable = false)
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return Objects.equals(did, dept.did);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did);
    }

    @Basic
    @Column(name = "dname", nullable = false, length = 255)
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
