package com.demo.controller;

import com.demo.services.DgInterviewService;
import com.demo.services.DgResumeSerivce;
import com.demo.pojo.Interview;
import com.demo.pojo.MyResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * @author: diga
 * <p>
 * Description: 面试控制层
 * date: 2020/12/22 9:07
 */
@CrossOrigin
@RestController
@RequestMapping("/intview")
public class DgInterviewController {
    @Autowired
    DgInterviewService is;
    @Autowired
    DgResumeSerivce rs;

    /*
     * @Author diga
     * @Date 2020/12/24 13:59
     * @Description 查询所有面试
     */
    @RequestMapping("/finall")
    public PageInfo<Interview> listInterViewAll(@RequestParam(value = "pagesize",required = false) Integer pagesize,
                                                Integer pagenum){
        Integer size=8;
        if (pagesize!=null){
            size=pagesize;
        }
        PageInfo<Interview> page=is.listInterViewAll(pagesize,pagenum);
        return page;
    }

    /*
     * @Author diga
     * @Date 2020/12/24 14:01
     * @Description 新增面试
     */
    @RequestMapping("/insert")
    public MyResult insertInterView(@RequestParam("intype") Integer intype,
                                    @RequestParam("intime") String intime,
                                    @RequestParam("inaddress") String inaddress,
                                    @RequestParam("rsid")Integer rsid){
        try {
            System.out.println("所有参数："+intype+" "+intime+" "+inaddress+" "+rsid);
            //将字符串转成simpledate
            Timestamp t1 =Timestamp.valueOf(intime);
            Integer a=is.insertInterView(intype, t1, inaddress, rsid);
            Integer b=rs.updateRstype(rsid);
            if(a>0 & b>0){
                return new MyResult(1,"新增成功");
            }else{
                return new MyResult(-1,"新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new MyResult(-1,"新增失败");
        }
    }
}
