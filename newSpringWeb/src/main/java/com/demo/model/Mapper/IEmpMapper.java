package com.demo.model.Mapper;/**
 * @Auther: Length
 * @Date: 2020/12/22 11:17
 * @Description:
 */

import com.demo.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@description: 员工接口
 *@author: larry
 *@create: 2020-12-22 11:17
 */
@Mapper
@Repository
public interface IEmpMapper {
    //根据eid查询员工
    Emp empbyid(Integer eid);
    //查询所有
    List<Emp> empall();
}
