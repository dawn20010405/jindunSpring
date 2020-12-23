/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 14:40 2020-12-22
 * @ Description：转正表 justConterollet
 */
package com.demo.Controller;

import com.demo.Services.PxyempServices;
import com.demo.Services.PxyjustServices;
import com.demo.Services.ZzyexamineServices;
import com.demo.pojo.Just;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * @Auther: Administrator
 * @Date: 2020-12-22 14:40
 * @Description:
 */
@RestController
@RequestMapping("/just")
@CrossOrigin
public class PxyjustController {
    @Autowired
    PxyjustServices js;
    @Autowired
    PxyempServices es;
    @Autowired
    ZzyexamineServices exs;
    @RequestMapping("/listselectJust")
    public PageInfo<Just> listselectJust(@RequestParam("no") Integer pageNo,
                                         @RequestParam(value = "size",required = false) Integer pageSize,
                                         Integer eid,Integer jid){
        System.out.println("listselectJust 转正表查询全部");
        PageInfo<Just> info = js.listselectJust(pageNo,pageSize,eid,jid);
        System.out.println("info:"+info);
        return info;
    }
    /*
     * @Author Administrator
     * @Description //TODO InsertJust 转正表新增
     * @Date 14:31 2020-12-23
     * @Param
     * @return
     **/
    @RequestMapping("/InsertJust")
    public Integer InsertJust(Integer eid,String justtime,String jzong,Integer did,Integer pid){
        System.out.println("InsertJust 转正表新增");
        System.out.println("eid:"+eid);
        System.out.println("jzong:"+jzong);
        System.out.println("did:"+did);
        System.out.println("pid:"+pid);
        Timestamp time = Timestamp.valueOf(justtime);
        System.out.println("time:"+time);
        Integer a=js.InsertJust(time,jzong,eid,pid);
        if (a>=1){
            System.out.println("新增转正表成功");
            Integer zhuan=es.updateempbyeid(eid);
            /*获取刚新增的iD*/
            Just in=js.selectJustzui();
            Integer exsin=exs.insertExamine("转正",in.getJid());
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
}
