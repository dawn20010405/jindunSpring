/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 10:11 2020-12-24
 * @ Description：离职表
 */
package com.demo.Controller;

import com.demo.Services.PxyDimissionService;
import com.demo.Services.PxyempServices;
import com.demo.Services.ZzyexamineServices;
import com.demo.pojo.Dimission;
import com.demo.pojo.Just;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020-12-24 10:11
 * @Description:
 */
@RestController
@RequestMapping("/dimission")
@CrossOrigin
public class PxyDimissionController {
    @Autowired
    PxyDimissionService ds;
    @Autowired
    PxyempServices es;
    @Autowired
    ZzyexamineServices exs;
    @RequestMapping("/listselectdimission")
    public PageInfo<Dimission> listselectdimission(@RequestParam("no") Integer pageNo,
                                                   @RequestParam(value = "size",required = false) Integer pageSize,
                                                   Integer eid, Integer dimid){
        System.out.println("listselectdimission 离职表查询全部");
        PageInfo<Dimission> info = ds.listselectdimission(pageNo,pageSize,eid,dimid);
        System.out.println("info:"+info);
        return info;
    }

    @RequestMapping("/Insertdimission")
    public Integer InsertJust(Integer eid,String dimissiontime,String dzong){
        System.out.println("Insertdimission 离职表新增");
        System.out.println("eid:"+eid);
        System.out.println("jzong:"+dzong);
        Timestamp time = Timestamp.valueOf(dimissiontime);
        System.out.println("time:"+time);
        Integer a=ds.Insertdimission(time,dzong,eid);
        if (a>=1){
            System.out.println("新增离职表成功");
            Integer zhuan=es.updateempbyeid(eid);
            /*获取刚新增的iD*/
            Dimission in=ds.selectDimissionzui();
            Integer exsin=exs.insertExamine("离职",in.getDimid());
            if (exsin>=1){
                System.out.println("新增审批表成功");
            }else {
                System.out.println("新增审批表失败");
            }
        }else {
            System.out.println("新增失败");
        }
        return 11;
    }


    //    左增源  离职表待审批查询List<Dimission> listselecetlzall();
    @RequestMapping("/lizhiall")
    public PageInfo<Dimission> selectlizhill(@RequestParam(value = "no", required = false) Integer pageNo,
                                             @RequestParam(value = "size", required = false) Integer pageSize) {
        Integer no = (pageNo != null && pageNo >= 1) ? pageNo : 1;
        Integer size = (pageSize != null) ? pageSize : 1;
        return ds.selectlzall(no,size);
    }
    //    左增源  根据ID修改离职表Integer updatelizhiId(Integer dshenpi,Integer dimid);
    @RequestMapping("/uplizhi")
    public Integer updatelizhi(@RequestParam("dshenpi")Integer dshenpi,
                               @RequestParam("dimid")Integer dimid){
        return ds.updatelizhi(dshenpi,dimid);
    }
}
