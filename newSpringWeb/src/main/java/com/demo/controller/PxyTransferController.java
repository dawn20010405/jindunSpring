/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 19:42 2020-12-23
 * @ Description：TransferController 调岗表
 */
package com.demo.controller;

import com.demo.services.PxyTransferServices;
import com.demo.services.PxyempServices;
import com.demo.services.ZzlxiangmuService;
import com.demo.services.ZzyexamineServices;
import com.demo.pojo.MyResult;
import com.demo.pojo.Transfer;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * @Auther: Administrator
 * @Date: 2020-12-23 19:42
 * @Description:
 */
@RestController
@RequestMapping("/transfer")
@CrossOrigin
public class PxyTransferController {
    @Autowired
    PxyTransferServices ts;
    @Autowired
    PxyempServices es;
    @Autowired
    ZzyexamineServices exs;
    @Autowired
    ZzlxiangmuService zzl;
    /*
      * @Author Administrator
      * @Description //TODO 调岗表分页查询全部 listselectTransferPage
      * @Date 19:45 2020-12-23
      * @Param [pageNo, pageSize, eid, jid]
      * @return com.github.pagehelper.PageInfo<com.demo.pojo.Transfer>
      **/
    @RequestMapping("/listselectTransferPage")
    public MyResult listselectTransferPage(@RequestParam("no") Integer pageNo,
                                           @RequestParam(value = "size",required = false) Integer pageSize,
                                           Integer eid, Integer tids){
        System.out.println("listselectTransferPage 调岗表分页查询全部");
        PageInfo<Transfer> info = ts.listselectTransfer(pageNo,pageSize,eid,tids);
        System.out.println("info:"+info);
        return MyResult.returnObj(info);
    }

    @RequestMapping("/InsertTransfer")
    public MyResult InsertTransfer(Integer eid,String transfertime,String tzong,Integer did,Integer pid){
        System.out.println("InsertTransfer 调岗表新增");
        System.out.println("eid:"+eid);
        System.out.println("tzong:"+tzong);
        System.out.println("did:"+did);
        System.out.println("pid:"+pid);
        Timestamp time = Timestamp.valueOf(transfertime);
        System.out.println("time:"+time);
        Integer a=ts.InsertTransfer(eid,time,tzong,did,pid);
        if (a>=1){
            System.out.println("新增调岗表成功");
            Integer zhuan=es.updateempPidbyeid(pid,eid);
            /*获取刚新增的iD*/
            Transfer in=ts.selectTransferzui();
            Integer exsin=zzl.addshenpi("调岗",1,in.getTids());
            if (exsin>=1){
                System.out.println("新增审批表成功");
            }else {
                System.out.println("新增审批表失败");
            }
        }else {
            System.out.println("新增失败");
        }
        return MyResult.returnObj(1);
    }



    //    左增源  调岗表待审批查询List<Transfer> listselectdgll();
    @RequestMapping("/tiaogangall")
    public PageInfo<Transfer> selecttgll(@RequestParam(value = "no", required = false) Integer pageNo,
                                         @RequestParam(value = "size", required = false) Integer pageSize) {
        Integer no = (pageNo != null && pageNo >= 1) ? pageNo : 1;
        Integer size = (pageSize != null) ? pageSize : 1;
        return ts.selecttgall(no,size);
    }
    //    左增源  根据ID修改调岗表Integer updatediaogangId(Integer tsehngpi,Integer tids);
    @RequestMapping("/uptg")
    public Integer updatetiaogang(@RequestParam("tsehngpi")Integer tsehngpi,
                                  @RequestParam("tids")Integer tids){
        return ts.updatediaogang(tsehngpi,tids);
    }
}
