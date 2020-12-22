/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 21:54 2020-12-21
 * @ Description：
 */
package com.demo.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Auther: Administrator
 * @Date: 2020-12-21 21:54
 * @Description:
 */
@Entity
public class Position {
    private Emp myemp;
    private Integer pid;
    private String poname;
    @OneToOne(mappedBy = "myposition")
    public Emp getMyemp() {
        return myemp;
    }

    public void setMyemp(Emp myemp) {
        this.myemp = myemp;
    }

    @Id
    @Column(name = "pid", nullable = false)
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "poname", nullable = false, length = 255)
    public String getPoname() {
        return poname;
    }

    public void setPoname(String poname) {
        this.poname = poname;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(pid, position.pid) &&
                Objects.equals(poname, position.poname) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, poname);
    }
}
