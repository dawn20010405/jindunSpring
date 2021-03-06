package com.demo.controller;

import com.demo.services.DgDeptService;
import com.demo.pojo.Dept;
import com.demo.pojo.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: diga
 * <p>
 * Description: 部门控制层
 * date: 2020/12/22 9:02
 */
@CrossOrigin
@RestController
@RequestMapping("/dept")
public class DgDeptController {
    @Autowired
    DgDeptService ds;

    /*
    * @Author diga
    * @Date 2020/12/22 10:17
    * @Description 查询所有部门
    */
    @RequestMapping("/finall")
    public MyResult listDeptAll(){
        return MyResult.returnObjs(ds.listDeptAll());
    }
    /*
     * @Author Administrator
     * @Description //TODO  查询全部
     * @Date 15:04 2020-12-23
     * @Param []
     * @return com.demo.pojo.MyResult
     **/
    @RequestMapping("/listDeptAllpxy")
    public MyResult listDeptAllpxy(){
        return MyResult.returnObj(ds.listDeptAll());
    }

    /*
    * @Author diga
    * @Date 2020/12/22 15:12
    * @Description 部门新增
    */
    @RequestMapping("/insert")
    public MyResult insertDept(@RequestBody Dept dept){
        try {
            Dept d=ds.getDname(dept.getDname());
            if (d!=null){
                return new MyResult(-1,"该部门已存在！");
            }else {
                Integer a=ds.insertDept(dept);
                if (a>0){
                    return new MyResult(1,"新增成功");
                }else {
                    return new MyResult(-1,"新增失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.ERROR("新增失败");
        }
    }
}
