package com.demo.Controller;

import com.demo.Services.DgRecruitmentService;
import com.demo.pojo.MyResult;
import com.demo.pojo.Recruitment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author: diga
 * <p>
 * Description: 招聘控制层
 * date: 2020/12/22 18:50
 */
@CrossOrigin
@RestController
@RequestMapping("/recru")
public class DgRecruitmentController {
    @Autowired
    DgRecruitmentService rs;

    /*
    * @Author diga
    * @Date 2020/12/22 19:11
    * @Description 查询所有招聘信息
    */
    @RequestMapping("/finall")
    public MyResult listRecruAll(@RequestParam(value = "retype",required = false) Integer retype,
                                 @RequestParam(value = "poname",required = false)String poname,
                                 @RequestParam(value = "dname",required = false)String dname,
                                 @RequestParam(value = "recrudemand",required = false)String recrudemand,
                                 @RequestParam(value = "peopcout",required = false)Integer peopcout,
                                 @RequestParam(value = "hopetime1",required = false)String hopetime1,
                                 @RequestParam(value = "hopetime2",required = false)String hopetime2,
                                 @RequestParam(value = "rcreate",required = false)String rcreate){
        List<Recruitment> list=rs.listRecruAll(retype, poname, dname, recrudemand, peopcout, hopetime1, hopetime2,rcreate);
        return MyResult.returnObjs(list);
    }

    /*
    * @Author diga
    * @Date 2020/12/23 11:08
    * @Description 新增招聘需求
    */
    @RequestMapping("/insert")
    public MyResult insertRecru(@RequestParam("pid") Integer pid,
                                @RequestParam("hopetime")String hopetime,
                                @RequestParam("peopcout")Integer peopcout,
                                @RequestParam(value = "recrudemand",required = false)String recrudemand,
                                @RequestParam("retype")Integer retype){
        try {
            //将字符串转成sql.date
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d = null;
            try {
                //先转成util.date
                d = format.parse(hopetime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //再由util.date转成sql.date
            java.sql.Date date = new java.sql.Date(d.getTime());
            //获取当前系统时间
            Date date1=new Date(new java.util.Date().getTime());
            Integer a=rs.insertRecru(pid, date, peopcout, recrudemand, date1, retype);
            if (a>0){
                return new MyResult(1,"新增成功");
            }else {
                return new MyResult(-1,"新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.ERROR("新增失败");
        }
    }

    /*
     * @Author diga
     * @Date 2020/12/23 19:28
     * @Description 修改招聘需求
     */
    @RequestMapping("/update1")
    public MyResult updateRecru(@RequestParam("peopcout") Integer peopcout,
                                @RequestParam("hopetime")String hopetime,
                                @RequestParam("rid")Integer rid){
        try {
            //将字符串转成sql.date
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d = null;
            try {
                //先转成util.date
                d = format.parse(hopetime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //再由util.date转成sql.date
            java.sql.Date date = new java.sql.Date(d.getTime());
            Integer a=rs.updateRecru(peopcout, date, rid);
            if (a>0){
                return new MyResult(1,"修改成功");
            }else{
                return new MyResult(-1,"修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.ERROR("修改失败");
        }
    }

    /*
     * @Author diga
     * @Date 2020/12/23 19:28
     * @Description 修改招聘状态(取消)
     */
    @RequestMapping("/update2")
    public MyResult updateRetype(@RequestParam("rid")Integer rid){
        try {
            Integer a=rs.updateRetype(rid);
            if (a>0){
                return new MyResult(1,"修改成功");
            }else{
                return new MyResult(-1,"修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.ERROR("修改失败");
        }
    }
}
