package com.demo.Controller;

import com.demo.Services.ZzlxiangmuService;
import com.demo.pojo.MyResult;
import com.demo.pojo.Myproject;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: ZzlxiangmuController
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-22 16:28
 * @Version: v1.0
 */
@RestController()
@RequestMapping("/xm")
@CrossOrigin
public class ZzlxiangmuController {
    
    @Autowired
    ZzlxiangmuService x;

    /**
     * @Description:该方法名称(listxiangmu)
     * @param: [no, size]
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-22 16:29
     */
    @RequestMapping("/all")
    public MyResult listxiangmu(Integer no, Integer size,@Param("empno") Integer empno,@Param("tid") Integer tid,@Param("state") Integer state,@Param("evel") Integer evel){
        PageInfo<Myproject> pager=x.listxiangmu(no,size,empno,tid,state,evel);
        return MyResult.returnObj(pager);
    }

    /**
     * @Description:该方法名称(listxiangmuBystate)
     * @param: [no, size, empno, tid, state, evel]
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-23 19:34
     */
    @RequestMapping("/all2")
    public MyResult listxiangmuBystate(Integer no, Integer size,@Param("empno") Integer empno,@Param("tid") Integer tid,@Param("state") Integer state,@Param("evel") Integer evel){
        PageInfo<Myproject> pager=x.listxiangmuBystate(no,size,empno,tid,state,evel);
        return MyResult.returnObj(pager);
    }

 /**
  * @Description:该方法名称(addxiangmu)
  * @param: [xname, empno, start, end, explain, evel, tid]
  * @return: com.demo.pojo.MyResult
  * @auther: zzl
  * @date: 2020-12-23 13:14
  */
    @RequestMapping("/add")
    public MyResult addxiangmu(@Param("xname")String xname,
                               @Param("empno")Integer empno,
                               @Param("start") String start,
                               @Param("end")String end,
                               @Param("explain")String explain,
                               @Param("evel") Integer evel,
                               @Param("tid")Integer tid) throws ParseException {
        Date t=new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date = ft.parse(start);
        Date date1 = ft.parse(end);
        Timestamp time1 = new Timestamp(System.currentTimeMillis());

        Myproject m=new Myproject();
        m.setXname(xname);
        m.setStart(date);
        m.setEnd(date1);
        m.setExplain(explain);
        m.setEvel(evel);
        m.setCdate(time1);

//        Integer i=x.addxiangmu(xname, empno, date, date1, explain, evel, t, tid);
        Integer i=x.addxiangmu(empno,tid,m);
        System.out.println(m.getXid());
        if(i>0 && m.getXid()!=null){
            x.addjilu(empno,"申请项目","申请了项目",time1,m.getXid());
            x.addshenpi("项目",1,m.getXid());
        }else{
            return MyResult.returnObj(-1);
        }

        return MyResult.returnObj(i);
    }

    public MyResult addjilu(@Param("empno")Integer empno,
                            @Param("btype") String btype,
                            @Param("content")String content,
                            @Param("cdate") Timestamp cdate,
                            @Param("xid")Integer xid){

        return MyResult.returnObj(x.addjilu(empno, btype, content, cdate, xid));
    }

    /**
     * @Description:该方法名称(xmtype)
     * @param: []
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-23 9:07
     */
    @RequestMapping("/xmtype")
    public MyResult xmtype(){
        return MyResult.returnObj(x.xmtype());
    }


    /**
     * @Description:该方法名称(countxiangmu)
     * @param: []
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-22 19:39
     * 根据项目状态统计
     */
    @RequestMapping("/counts")
    public MyResult countxiangmu(){
        return MyResult.returnObj(x.countxiangmu());
    }

    /**
     * @Description:该方法名称(countype)
     * @param: []
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-22 19:39
     * 根据项目类型统计
     */
    @RequestMapping("/countype")
    public MyResult countype(){
        Map<String, Object> objectHashMap = new HashMap<>();
        List<String> name=new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        List<Myproject> list=x.countype();
        for (Myproject m : list) {
            name.add(m.getXname());
            data.add(m.getXid());
        }
        objectHashMap.put("name", name);
        objectHashMap.put("data", data);
        return MyResult.returnObj(objectHashMap);
    }

    /**
     * @Description:该方法名称(countevel)
     * @param: []
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-22 19:39
     * 根据级别统计
     */
    @RequestMapping("/countevel")
    public MyResult countevel(){
        Map<String, Object> objectHashMap = new HashMap<>();
        List<String> name=new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        List<Myproject> list=x.countevel();
        name.add("非常紧急");
        name.add("比较紧急");
        name.add("一般紧急");

        for (Myproject m : list) {
            data.add(m.getXid());
        }

        objectHashMap.put("name", name);
        objectHashMap.put("data", data);
        return MyResult.returnObj(objectHashMap);
    }

    /**
     * @Description:该方法名称(getdname)
     * @param: [eid]
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-23 21:34
     */
    @RequestMapping("/userdept")
    public MyResult getdname(Integer eid){
        System.out.println(eid);
        return MyResult.returnObj(x.getdname(eid));
    }

    /**
     * @Description:该方法名称(listemp)
     * @param: []
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-23 21:34
     */
    @RequestMapping("/eall")
    public MyResult listemp(){
        return MyResult.returnObj(x.listemp());
    }

    /**
     * @Description:该方法名称(listrisk)
     * @param: [xid]
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-23 21:48
     */
    @RequestMapping("/risk")
    public MyResult listrisk(Integer no, Integer size,Integer xid){
        return MyResult.returnObj(x.listrisk(no, size, xid));
    }





}
