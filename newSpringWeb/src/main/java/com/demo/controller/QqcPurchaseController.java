package com.demo.controller;

import com.demo.services.QqcPurchaseService;
import com.demo.pojo.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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

    /**
     * @Author: qqc on 2020/12/24 20:39
     * @param : [pageNum, pageSize, purchasetype, start, end, pname, empid]
     * @return : com.demo.pojo.MyResult
     * @Description :加载查询主界面
     */
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
