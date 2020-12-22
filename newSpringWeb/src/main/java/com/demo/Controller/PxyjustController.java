/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 14:40 2020-12-22
 * @ Description：转正表 justConterollet
 */
package com.demo.Controller;

import com.demo.Services.PxyjustServices;
import com.demo.pojo.Just;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/listselectJust")
    public PageInfo<Just> listselectJust(@RequestParam("no") Integer pageNo,
                                         @RequestParam(value = "size",required = false) Integer pageSize,
                                         Integer eid,Integer jid){
        System.out.println("listselectJust 转正表查询全部");
        PageInfo<Just> info = js.listselectJust(pageNo,pageSize,eid,jid);
        System.out.println("info:"+info);
        return info;
    }
}
