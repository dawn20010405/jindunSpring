package com.demo.Controller;

import com.demo.Services.DgEntryService;
import com.demo.pojo.Entry;
import com.demo.pojo.Interview;
import com.demo.pojo.MyResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author: diga
 * <p>
 * Description: 入职控制层
 * date: 2020/12/22 9:02
 */
@CrossOrigin
@RestController
@RequestMapping("/entry")
public class DgEntryController {
    @Autowired
    DgEntryService es;

    /*
     * @Author diga
     * @Date 2020/12/24 20:03
     * @Description 查询所有入职信息
     */
    @RequestMapping("/finall")
    public PageInfo<Entry> listEntryAll(@RequestParam(value = "pagesize",required = false)Integer pagesize, Integer pagenum){
        Integer size=8;
        if (pagesize!=null){
            size=pagesize;
        }
        PageInfo<Entry> page=es.listEntryAll(pagesize,pagenum);
        return page;
    }

    /*
     * @Author diga
     * @Date 2020/12/24 20:04
     * @Description 新增入职信息
     */
    @RequestMapping("/insert")
    public MyResult insertEntry(@RequestParam("rsid") Integer rsid,
                                @RequestParam("emoney")BigDecimal emoney,
                                @RequestParam("gotime")String gotime,
                                @RequestParam("eniphone")String eniphone){
        try {
            //将字符串转成sql.date
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d = null;
            try {
                //先转成util.date
                d = format.parse(gotime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //再由util.date转成sql.date
            java.sql.Date date = new java.sql.Date(d.getTime());
            //获取当前系统时间
            Date date1=new Date(new java.util.Date().getTime());
            Integer a=es.insertEntry(rsid, emoney, date, eniphone, date1);
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
}
