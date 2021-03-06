package com.demo.controller;

import com.demo.services.QqcExchangeassetsService;
import com.demo.pojo.Exchangeassets;
import com.demo.pojo.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: QqcExchangeassetsController
 * Created by qqc on 2020/12/23
 */
@RestController
@CrossOrigin
@RequestMapping("/exchangeassets")
@Transactional
public class QqcExchangeassetsController {
    @Autowired
    QqcExchangeassetsService qqcExchangeassetsService;


    /**
     * @Author: qqc on 2020/12/23 15:51
     * @param : [pageNum, pageSize, exastype, exasnum, empid]
     * @return : com.demo.pojo.MyResult
     * @Description :页面数据加载
     */
    @RequestMapping("/load")
    public MyResult pageSelectAll(@RequestParam("pageNum")Integer pageNum,
                                  @RequestParam("pageSize")Integer pageSize,
                                  @RequestParam("exastype")String exastype,
                                  @RequestParam("exasnum")String exasnum,
                                  @RequestParam("empid")Integer empid){
        try {
            return MyResult.returnObj(qqcExchangeassetsService.listSelectAll(pageNum, pageSize, exastype, exasnum, empid));
        }catch (Exception e){
            e.printStackTrace();
            return MyResult.ERROR("查询失败！");
        }
    }

    /**
     * @Author: qqc on 2020/12/24 20:37
     * @param : [exchangeassetsid]
     * @return : com.demo.pojo.MyResult
     * @Description : 根据主键查询单个交换记录
     */
    @RequestMapping("/findone")
    public MyResult getSelectByPk(@RequestParam("exchangeassetsid")Integer exchangeassetsid){
        try{

           return  MyResult.returnObj(qqcExchangeassetsService.getSelectByPk(exchangeassetsid)) ;
        }catch (Exception e){
            e.printStackTrace();
            return MyResult.ERROR("查询失败！");
        }
    }
    /**
     * @Author: qqc on 2020/12/24 20:38
     * @param : [exchangeassets]
     * @return : com.demo.pojo.MyResult
     * @Description : 领用记录添加
     */
    @RequestMapping("/addone")
    public MyResult insertOne(@RequestBody Exchangeassets exchangeassets){

        try{
            qqcExchangeassetsService.insertOne(exchangeassets);
            return MyResult.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return MyResult.ERROR("新增失败！");
        }
    }
}
