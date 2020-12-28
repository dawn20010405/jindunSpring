package com.demo.controller;

import com.demo.services.AchievementslcService;
import com.demo.pojo.Achievementslc;
import com.demo.pojo.Emp;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @Author lichao
 * @Description //TODO 
 * @Date 10:40 2020/12/22
 * @Param  
 * @return 
        **/
@RestController
@RequestMapping("/aclc")
public class AchievementslcController {
    @Autowired
    AchievementslcService as;
    /*
     * @Author lichao
     * @Description //查询公开的绩效活动 并分页
     * @Date 11:13 2020/12/22
     * @Param
     * @return
            **/
    @RequestMapping("/pageac")
    public PageInfo<Achievementslc> selectAc(Integer no){
        return as.selectAc(no);
    }
    /*
     * @Author lichao
     * @Description //新增一个绩效活动
     * @Date 11:15 2020/12/22
     * @Param
     * @return
            **/
    @PostMapping("/addac/{eid}")
    public Integer addac(@RequestBody Achievementslc ac,@PathVariable Integer eid){
        ac.setEmpacone(as.empbyid(eid));
        return as.addAchievementslc(ac);
    }
    /*
     * @Author lichao
     * @Description //查询所有员工
     * @Date 14:47 2020/12/22
     * @Param
     * @return
            **/
    @RequestMapping("/empall")
    public List<Emp> empall(){
        return as.empall();
    }
    /*
     * @Author lichao
     * @Description //like 查询
     * @Date 16:39 2020/12/22
     * @Param
     * @return
            **/
    @RequestMapping("/likename")
    public PageInfo<Achievementslc> likename(Integer no,String acname){
        String a="%"+acname+"%";
        return as.likename(no,a);
    }
    /*
     * @Author lichao
     * @Description //TODO 
     * @Date 3:44 2020/12/25
     * @Param  
     * @return 
            **/
}
