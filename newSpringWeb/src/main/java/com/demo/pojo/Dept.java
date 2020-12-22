package com.demo.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Description: <br/>
 * date: 2020/12/21 22:56<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */
@Entity
public class Dept {
    private Integer did;
    private String dname;
    private List<Position> posi;

    @Id
    @Column(name = "did", nullable = false)
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Basic
    @Column(name = "dname", nullable = false, length = 255)
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return Objects.equals(did, dept.did) &&
                Objects.equals(dname, dept.dname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, dname);
    }

    @OneToMany(mappedBy = "dept")
    public List<Position> getPosi() {
        return posi;
    }

    public void setPosi(List<Position> posi) {
        this.posi = posi;
    }
}
