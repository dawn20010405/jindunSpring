package com.demo.controller;

import com.demo.services.DgResumeSerivce;
import com.demo.pojo.MyResult;
import com.demo.pojo.Resume;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author: diga
 * <p>
 * Description: 简历控制层
 * date: 2020/12/22 9:15
 */
@CrossOrigin
@RestController
@RequestMapping("/resum")
public class DgResumeController {
    @Autowired
    DgResumeSerivce rs;

    /*
     * @Author diga
     * @Date 2020/12/23 16:21
     * @Description 根据招聘信息查询所有简历信息
     */
    @RequestMapping("/finall/{rid}")
    public PageInfo<Resume> listResumeAll(@PathVariable Integer rid,
                                          @RequestParam(value = "pagesize",required = false) Integer pagesize,
                                          Integer pagenum){
        System.out.println("RID："+rid+" Size："+pagesize+" Num："+pagenum);
        Integer size=8;
        if (pagesize!=null){
            size=pagesize;
        }
        PageInfo<Resume> page=rs.listResumeAll(rid,pagesize,pagenum);

        for (Resume e:page.getList()) {
            System.out.println(e);
        }
        return page;
    }

    /*
     * @Author diga
     * @Date 2020/12/23 16:17
     * @Description 根据招聘信息新增简历
     */
    @RequestMapping("/insert")
    public MyResult insertResume(@RequestParam("rname") String rname,
                                 @RequestParam("rsex")Integer rsex,
                                 @RequestParam(value = "rbirthday",required = false)String rbirthday,
                                 @RequestParam("workyear")String workyear,
                                 @RequestParam("education")String education,
                                 @RequestParam("rid")Integer rid){
        try {
            //根据根据姓名、性别、生日、工作年限、学历查询判断该简历是否存在
            Resume r=rs.getResumeExist(rname,rsex,rbirthday,workyear,education);
            if (r!=null){
                return new MyResult(-1,"该简历已存在");
            }else{
                //将字符串转成sql.date
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date d = null;
                try {
                    //先转成util.date
                    d = format.parse(rbirthday);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //再由util.date转成sql.date
                java.sql.Date date = new java.sql.Date(d.getTime());
                //获取当前系统时间
                Date date1=new Date(new java.util.Date().getTime());
                Integer a=rs.insertResume(rname, rsex, date, workyear, education, date1, rid);
                if (a>0){
                    return new MyResult(1,"新增成功");
                }else{
                    return new MyResult(-1,"新增失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.ERROR("新增失败");
        }
    }
}
