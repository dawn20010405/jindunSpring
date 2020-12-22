package com.demo.Controller;

import com.demo.Services.ZzlLoginService;
import com.demo.Services.ZzygonggaoServices;
import com.demo.pojo.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @Autowired
    ZzygonggaoServices zzygonggaoServices;

    /*查询所有公告*/
    @RequestMapping("/ggAll")
    public List<Notification> selectggAll(){
        return zzygonggaoServices.selectggAll();
    }
}
