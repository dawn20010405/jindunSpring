/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 14:23 2020-12-24
 * @ Description：合同表
 */
package com.demo.controller;

import com.demo.services.PxyContractsServices;
import com.demo.services.PxyempServices;
import com.demo.pojo.Contracts;
import com.demo.pojo.MyResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * @Auther: Administrator
 * @Date: 2020-12-24 14:23
 * @Description:
 */
@RestController
@RequestMapping("/contracts")
@CrossOrigin
public class PxyContractsController {
    @Autowired
    PxyempServices es;
    @Autowired
    PxyContractsServices cs;
    @RequestMapping("/Insertcontracts")
    public MyResult InsertJust(String ckaitime, String cjietime, Integer cqixian, Integer eid, String cleixing){
        System.out.println("InsertContracts");
        System.out.println("cqixian:"+cqixian);
        System.out.println("eid:"+eid);
        System.out.println("cleixing:"+cleixing);
        Timestamp timekai=Timestamp.valueOf(ckaitime);
        Timestamp timejie=Timestamp.valueOf(cjietime);
        System.out.println("timekai:"+timekai);
        System.out.println("timejie:"+timejie);
        Integer in=cs.InsertContracts(timekai,timejie,cqixian,eid,cleixing);
        if (in>=1){
            Integer a=es.updateempeqianyuebyeid(eid);
            System.out.println("新增成功");
        }else {
            System.out.println("新增失败");
        }
        return MyResult.returnObj(1);
    }

    @RequestMapping("/listselectcontracts")
    public MyResult listselectcontracts(@RequestParam("no") Integer pageNo,
                                              @RequestParam(value = "size",required = false) Integer pageSize){
        System.out.println("listselectcontracts 合同表查询全部");
        PageInfo<Contracts> info = cs.listselectcontracts(pageNo,pageSize);
        System.out.println("info:"+info);
        return MyResult.returnObj(info);
    }
}
