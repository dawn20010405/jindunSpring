package com.demo.controller;

import com.demo.services.ZzygonggaoServices;
import com.demo.pojo.Notification;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ZzygonggaoController
 * @Author: 左增源
 * @create: 2020-12-22 17:05
 * @program: demo
 * @description: 公告
 */
@RequestMapping("/gonggao")
@RestController
public class ZzygonggaoController {
    /*公告查询*/
    @Autowired
    ZzygonggaoServices zzygonggaoServices;
    /**/

    /*查询所有公告*/
    @RequestMapping("/ggAll")
    public PageInfo<Notification> selectggAll(@RequestParam(value = "no", required = false) Integer pageNo,
                                              @RequestParam(value = "size", required = false) Integer pageSize) {
        Integer no = (pageNo != null && pageNo >= 1) ? pageNo : 1;
        Integer size = (pageSize != null) ? pageSize : 1;
        System.out.println(no+"--------------"+size);
        return zzygonggaoServices.selectggAll(no,size);
    }

    /*根据ID查询*/
    @RequestMapping("/ggid")
    public Notification Updatesborr(@RequestParam("noid") Integer noid){
        return  zzygonggaoServices.getselectid(noid);
    }

    /*根据ID修改状态*/
    @RequestMapping("/updtgg")
    public Integer updategonggao(@RequestParam("notype")Integer notype,
                                 @RequestParam("noid")Integer noid){
        return zzygonggaoServices.updategonggao(notype,noid);
    }


}
