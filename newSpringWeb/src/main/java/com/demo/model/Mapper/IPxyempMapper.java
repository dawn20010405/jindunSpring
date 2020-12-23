package com.demo.model.Mapper;

import com.demo.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020-12-21 20:37
 * @Description:
 */
@Mapper
@Repository
public interface IPxyempMapper {
    /*
     * @Author 彭欣雨
     * @Description //TODO 员工表查询全部
     * @Date 20:42 2020-12-21
     * @Param []
     * @return java.util.List<com.demo.pojo.Emp>
     **/
    public abstract List<Emp> listselectemppage(Integer eid,String ename,String eiphone);
     List<Emp> listempselect();
     List<Emp> listempselect2();
     Emp listempselectByeid(Integer eid);
     Integer updateempPidbyeid(Integer pid,Integer eid);
     Integer updateempbyeid(Integer eid);
}
