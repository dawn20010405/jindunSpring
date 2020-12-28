/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 16:30 2020-12-21
 * @ Description：Emp员工表 PxyempController
 */
package com.demo.controller;

import com.demo.services.PxyempServices;
import com.demo.pojo.Emp;
import com.demo.pojo.MyResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * @return PageInfo
     **/
    @RequestMapping("/listselectemppage")
    public MyResult listselectemppage(@RequestParam("no") Integer pageNo,
                                      @RequestParam(value = "size",required = false) Integer pageSize,
                                      Integer eid, String ename, String eiphone){
        System.out.println("我是listselectemp 员工表分页查询全部");
        PageInfo<Emp> info = es.listselectemppage(pageNo,pageSize,eid,ename,eiphone);
        System.out.println("info:"+info);
        return MyResult.returnObj(info);
    }
    /*
     * @Author Administrator
     * @Description //TODO 我是listempselect 员工表查询全部
     * @Date 10:22 2020-12-23
     * @Param []
     * @return java.util.List<com.demo.pojo.Emp>
     **/
    @RequestMapping("/listempselect")
    public MyResult listempselect(){
        return MyResult.returnObj(es.listempselect());
    }
    @RequestMapping("/listempselect2")
    public MyResult listempselect2(){

        return MyResult.returnObj(es.listempselect2());
    }
    /*
     * @Author Administrator
     * @Description //TODO 我是listempselectByeid 员工表根据eid查询全部
     * @Date 10:23 2020-12-23
     * @Param []
     * @return java.util.List<com.demo.pojo.Emp>
     **/
    @RequestMapping("/listempselectByeid")
    public MyResult listempselectByeid(Integer eid){
        return MyResult.returnObj(es.listempselectByeid(eid));
    }

    /*左增源 修改员工状态*/
    @RequestMapping("/updtemp")
    public Integer updateemp(@RequestParam("ezt")String ezt,
                             @RequestParam("eid")Integer eid){
        return es.updateezt(ezt,eid);
    }
}
