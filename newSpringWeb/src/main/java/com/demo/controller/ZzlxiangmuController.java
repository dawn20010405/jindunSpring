package com.demo.controller;

import com.demo.services.ZzlxiangmuService;
import com.demo.pojo.MyResult;
import com.demo.pojo.Myproject;
import com.demo.pojo.Myrisk;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        return MyResult.returnObj(x.listxiangmu(no,size,empno,tid,state,evel));
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
        return MyResult.returnObj(x.listxiangmuBystate(no,size,empno,tid,state,evel));
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

    /**
     * @Description:该方法名称(listjilu)
     * @param: [no, size, xid]
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-24 13:16
     */
    @RequestMapping("/jilu")
    public MyResult listjilu(Integer no, Integer size,Integer xid){
        return MyResult.returnObj(x.listjilu(no, size, xid));
    }

    /**
     * @Description:该方法名称(countype)
     * @param: []
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * 根据风险类型统计
     * @date: 2020-12-24 13:17
     */
    @RequestMapping("/risktype")
    public MyResult listrisktype(){
        Map<String, Object> objectHashMap = new HashMap<>();
        List<String> name=new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        List<Myrisk> list=x.listrisktype();
        for (Myrisk m : list) {
            name.add(m.getBtype());
            data.add(m.getFid());
        }
        objectHashMap.put("name", name);
        objectHashMap.put("data", data);
        return MyResult.returnObj(objectHashMap);
    }

    /**
     * @Description:该方法名称(getByxid)
     * @param: [xid]
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-24 13:41
     */
    @RequestMapping("/byxid")
    public MyResult getByxid(Integer xid){
        return MyResult.returnObj(x.getByxid(xid));
    }

    /**
     * @Description:该方法名称(listcanyu)
     * @param: [xid]
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-24 14:46
     */
    @RequestMapping("/canyu")
    public MyResult listcanyu(Integer xid){
        return MyResult.returnObj(x.listcanyu(xid));
    }

    @RequestMapping("/updatejindu")
    public MyResult updatejindu(@Param("jindu")Integer jindu,@Param("ziping")Integer ziping,@Param("xid") Integer xid,@Param("neirong")String neirong,@Param("empno")Integer empno){
        Timestamp time1 = new Timestamp(System.currentTimeMillis());
        Integer i=x.updatejindu(jindu, ziping, xid);
        if(i>0){
            x.addjilu(empno,"项目进度变动到"+jindu+"",neirong,time1,xid);
        }
        return MyResult.returnObj(i);
    }
    /**
     * @Description:该方法名称(addrisk)
     * @param: [fname, empno, btype, content, xid, level]
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-24 19:32
     */
    @RequestMapping("/addrisk")
    public MyResult addrisk(@Param("fname")String fname,@Param("empno")Integer empno,@Param("btype")String btype,@Param("content")String content,@Param("xid")Integer xid,@Param("level")Integer level){
        Timestamp time1 = new Timestamp(System.currentTimeMillis());
        Integer i=x.addrisk(fname, empno, btype, content, xid, time1, level);
        if(i>0){
            x.addjilu(empno,"项目"+btype+"风险报告",content,time1,xid);
        }
        return MyResult.returnObj(i);
    }

    @RequestMapping("/delectcanyu")
    public MyResult delectcanyu(Integer cid [],Integer empno,Integer xid){

        Timestamp time1 = new Timestamp(System.currentTimeMillis());
        
        try {
            for (int i = 0; i < cid.length; i++) {
                x.delectcanyu(cid[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MyResult.returnObj(x.addjilu(empno,"项目人员调整","移出了"+cid.length+"名人员",time1,xid));
    }

    /**
     * @Description:该方法名称(wancheng)
     * @param: [empno, xid]
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-25 2:25
     */
    @RequestMapping("/wancheng")
    public MyResult wancheng(Integer empno,Integer xid){
        Timestamp time1 = new Timestamp(System.currentTimeMillis());
        Integer i=x.wancheng(xid);
        return MyResult.returnObj(x.addjilu(empno,"项目完结","项目进度完成了",time1,xid));
    }

    @RequestMapping("/addempandxm")
    public MyResult addempandxm(Integer xid,Integer empno []){
        for (int i = 0; i <empno.length ; i++) {
            Integer j=x.addempandxm(xid, empno[i]);
        }
        return MyResult.returnObj(1);
    }



    //    左增源  查询项目待审批 List<Myproject> listxmall();
    @RequestMapping("/xmall")
    public PageInfo<Myproject> selectggAll(@RequestParam(value = "no", required = false) Integer pageNo,
                                           @RequestParam(value = "size", required = false) Integer pageSize) {
        Integer no = (pageNo != null && pageNo >= 1) ? pageNo : 1;
        Integer size = (pageSize != null) ? pageSize : 1;
        return x.selectxmall(no,size);
    }

    //    左增源  修改项目表状态 Integer updatexiangmu(Integer state,Integer xid);
    @RequestMapping("/xmupdt")
    public Integer updatezhuanzheng(@RequestParam("state")Integer state,
                                    @RequestParam("xid")Integer xid){
        return x.updatexiangmu(state,xid);
    }

    /*
     * @Author lichao
     * @Description //TODO 
     * @Date 18:57 2020/12/25
     * @Param  
     * @return 
            **/
    
    @RequestMapping("/add")
    public MyResult addxiangmu(@Param("xname")String xname,
                               @Param("empno")Integer empno,
                               @Param("start") String start,
                               @Param("end")String end,
                               @Param("explain")String explain,
                               @Param("evel") Integer evel,
                               @Param("tid")Integer tid) throws ParseException {
        Integer i= null;
        try {
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

            i = x.addxiangmu(empno,tid,m);
            System.out.println(m.getXid());
            if(i>0 && m.getXid()!=null){
                x.addjilu(empno,"申请项目","申请了项目"+xname+"",time1,m.getXid());
                x.addshenpi("项目",1,m.getXid());
            }else{
                return MyResult.returnObj(-1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return MyResult.returnObj(i);
    }




}
