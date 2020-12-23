package com.demo.Controller;

import com.demo.Services.ZzyexamineServices;
import com.demo.pojo.Examine;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName: ZzyshenpiController
 * @Author: 左增源
 * @create: 2020-12-22 12:04
 * @program: demo
 * @description: 审批
 */
@RestController
@RequestMapping("/shenpi")
public class ZzyexamineController {
    @Autowired
    ZzyexamineServices zzyexamineServices;

    /*查询待审*/
    @RequestMapping("/dsall")
    public PageInfo<Examine> selectdsAll(@RequestParam(value = "no", required = false) Integer pageNo,
                                         @RequestParam(value = "size", required = false) Integer pageSize) {
        Integer no = (pageNo != null && pageNo >= 1) ? pageNo : 1;
        Integer size = (pageSize != null) ? pageSize : 1;
        System.out.println(no+"--------------"+size);
        return zzyexamineServices.selectdsAll(no,size);
    }
    /*查询已审批*/
    @RequestMapping("/ysall")
    public PageInfo<Examine> selectysAll(@RequestParam(value = "no", required = false) Integer pageNo,
                                         @RequestParam(value = "size", required = false) Integer pageSize) {
        Integer no = (pageNo != null && pageNo >= 1) ? pageNo : 1;
        Integer size = (pageSize != null) ? pageSize : 1;
        System.out.println(no+"--------------"+size);
        return zzyexamineServices.selectysAll(no,size);
    }
    /*修改审批*/
    @RequestMapping("/updtsp")
    public Integer updategonggao(@RequestParam("exyijian") String exyijian,
                                 @RequestParam("extype") Integer extype,
                                 @RequestParam("exstate") String exstate,
                                 @RequestParam("wxwid") Integer wxwid){
        System.out.println("进入修改！！！！");
        System.out.println("获取到："+zzyexamineServices.updategonggao(new Date(),exyijian,extype,exstate,wxwid));
        return zzyexamineServices.updategonggao(new Date(),exyijian,extype,exstate,wxwid);

    }

}
