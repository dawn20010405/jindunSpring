package com.demo.controller;

import com.demo.services.DgIntrecordService;
import com.demo.pojo.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: diga
 * <p>
 * Description: 面试记录控制层
 * date: 2020/12/22 9:07
 */
@CrossOrigin
@RestController
@RequestMapping("/intcord")
public class DgIntrecordController {
    @Autowired
    DgIntrecordService is;

    /*
     * @Author diga
     * @Date 2020/12/24 17:00
     * @Description 根据面试新增面试记录
     */
    @RequestMapping("/insert")
    public MyResult insertIntrecord(@RequestParam("iresult") Integer iresult,
                                    @RequestParam(value = "iremark",required = false)String iremark,
                                    @RequestParam("iid")Integer iid){
        try {
            Integer a=is.insertIntrecord(iresult, iremark, iid);
            if (a>0){
                return new MyResult(1,"新增成功");
            }else{
                return new MyResult(-1,"新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new MyResult(-1,"新增失败");
        }
    }

    /*
     * @Author diga
     * @Date 2020/12/24 18:31
     * @Description 根据面试信息编号查询面试记录
     */
    @RequestMapping("/getOne/{iid}")
    public MyResult getIntrecord(@PathVariable Integer iid){
        return MyResult.returnObj(is.getIntrecord(iid));
    }
}
