package com.demo.model.Mapper;

import com.demo.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: 部门dao层
 * date: 2020/12/21 17:14
 * @author diga
 */
@Mapper
@Repository
public interface IDgDeptMapper {
    /*
    * @Author diga
    * @Date 2020/12/22 10:21
    * @Description 查询所有部门
    */
    List<Dept> listDeptAll();

    /*
    * @Author diga
    * @Date 2020/12/22 15:10
    * @Description 部门新增
    */
    Integer insertDept(Dept dept);

    /*
    * @Author diga
    * @Date 2020/12/22 18:29
    * @Description 根据部门名称查询
    */
    Dept getDname(String dname);
}
