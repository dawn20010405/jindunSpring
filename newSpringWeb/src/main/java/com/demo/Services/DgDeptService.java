package com.demo.Services;

import com.demo.model.Mapper.IDgDeptMapper;
import com.demo.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: 部门业务层
 * date: 2020/12/22 8:47
 *
 * @author: diga
 */
@Service
public class DgDeptService {
    @Autowired
    IDgDeptMapper mapper;

    /*
     * @Author diga
     * @Date 2020/12/22 10:14
     * @Description 查询所有部门
     */
    public List<Dept> listDeptAll(){
        return mapper.listDeptAll();
    }

    /*
     * @Author diga
     * @Date 2020/12/22 15:11
     * @Description 部门新增
     */
    public Integer insertDept(Dept dept){
        try {
            Integer a=mapper.insertDept(dept);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /*
     * @Author diga
     * @Date 2020/12/22 18:30
     * @Description 根据部门名称查询
     */
    public Dept getDname(String dname){
        return mapper.getDname(dname);
    }
}
