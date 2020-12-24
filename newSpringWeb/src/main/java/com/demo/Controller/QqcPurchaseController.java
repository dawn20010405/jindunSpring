package com.demo.Controller;

import com.demo.Services.QqcPurchaseService;
import com.demo.pojo.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;


/**
 * @Title: QqcPurchaseController
 * Created by qqc on 2020/12/24
 */

@RestController
@CrossOrigin
@RequestMapping("/purchase")
@Transactional
public class QqcPurchaseController {

    @Autowired
    QqcPurchaseService qqcPurchaseService;

    @RequestMapping("/load")
    public MyResult pageSelectAll(@RequestParam("pageNum")Integer pageNum,
                                  @RequestParam("pageSize")Integer pageSize,
                                  @RequestParam("purchasetype")String purchasetype,
                                  @RequestParam("start") String  start,
                                  @RequestParam("end")String end,
                                  @RequestParam("pname")String pname,
                                  @RequestParam("empid")Integer empid){
        try{
            return MyResult.returnObj(qqcPurchaseService.pagerSelectAll(pageNum,pageSize,start,end,pname,empid,purchasetype));
        }catch (Exception e){
            e.printStackTrace();
            return MyResult.ERROR("查询失败！");
        }
    }
}
