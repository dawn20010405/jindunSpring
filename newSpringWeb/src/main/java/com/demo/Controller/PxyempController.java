/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 16:30 2020-12-21
 * @ Description：Emp员工表 PxyempController
 */
package com.demo.Controller;

import com.demo.Services.PxyempServices;
import com.demo.pojo.Emp;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 彭欣雨
 * @Date: 2020-12-21 16:30
 * @Description:
 */
@RestController
@RequestMapping("/emp")
@CrossOrigin
public class PxyempController {
    @Autowired
    PxyempServices es;
    /*
     * @Author Administrator
     * @Description //TODO 员工表查询全部
     * @Date 20:46 2020-12-21
     * @Param []
     * @return ResultVO
     **/
    @RequestMapping("/listselectemp")
    public PageInfo<Emp> listselectemp(@RequestParam("no") Integer pageNo,
                                       @RequestParam(value = "size",required = false) Integer pageSize,
                                       Integer eid,String ename,String eiphone){
        System.out.println("我是listselectemp 员工表查询全部");
        PageInfo<Emp> info = es.listselectemp(pageNo,pageSize,eid,ename,eiphone);
        System.out.println("info:"+info);
        return info;
    }
    /*@RestController("/listempselectByeid")
    public */
}
