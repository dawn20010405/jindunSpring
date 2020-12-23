package com.demo.Services;

import com.demo.model.Mapper.IZzlxiangmuMapper;
import com.demo.pojo.Emp;
import com.demo.pojo.Myproject;
import com.demo.pojo.Myrisk;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: ZzlxiangmuService
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-22 16:24
 * @Version: v1.0
 */
@Service
public class ZzlxiangmuService {

    @Autowired
    IZzlxiangmuMapper z;
/**
 * @Description:该方法名称(listxiangmu)
 * @param: [pageNo, pageSize]
 * @return: com.github.pagehelper.PageInfo<com.demo.pojo.Myproject>
 * @auther: zzl
 * @date: 2020-12-22 19:36
 */
    public PageInfo<Myproject> listxiangmu(Integer pageNo, Integer pageSize,@Param("empno") Integer empno,@Param("tid") Integer tid,@Param("state") Integer state,@Param("evel") Integer evel){
        PageHelper.startPage(pageNo,pageSize);
        List<Myproject> list = z.listxiangmu(empno, tid, state, evel);
        PageInfo<Myproject> info = new PageInfo<>(list);
        return info;
    }

    /**
     * @Description:该方法名称(listxiangmuBystate)
     * @param: [pageNo, pageSize, empno, tid, state, evel]
     * @return: com.github.pagehelper.PageInfo<com.demo.pojo.Myproject>
     * @auther: zzl
     * @date: 2020-12-23 19:34
     */
    public PageInfo<Myproject> listxiangmuBystate(Integer pageNo, Integer pageSize,@Param("empno") Integer empno,@Param("tid") Integer tid,@Param("state") Integer state,@Param("evel") Integer evel){
        PageHelper.startPage(pageNo,pageSize);
        List<Myproject> list = z.listxiangmuBystate(empno, tid, state, evel);
        PageInfo<Myproject> info = new PageInfo<>(list);
        return info;
    }
/**
 * @Description:该方法名称(addxiangmu)
 * @param: [xname, empno, start, end, explain, evel, cdate, tid]
 * @return: java.lang.Integer
 * @auther: zzl
 * @date: 2020-12-23 13:13
 */
    public Integer addxiangmu(
            @Param("empno")Integer empno,
            @Param("tid")Integer tid,
            @Param("x")Myproject x){
        return z.addxiangmu(empno,tid,x);
    }

    /**
     * @Description:该方法名称(addjilu)
     * @param: [empno, btype, content, cdate, xid]
     * @return: java.lang.Integer
     * @auther: zzl
     * @date: 2020-12-23 14:43
     */
    public Integer addjilu(@Param("empno")Integer empno, @Param("btype") String btype, @Param("content")String content, @Param("cdate") Timestamp cdate, @Param("xid")Integer xid){
        return z.addjilu(empno, btype, content, cdate, xid);
    }

    /**
     * @Description:该方法名称(addshenpi)
     * @param: [type, empno, xid]
     * @return: java.lang.Integer
     * @auther: zzl
     * @date: 2020-12-23 21:33
     */
    public Integer addshenpi(@Param("exstate")String type,@Param("exuser")Integer empno,@Param("wxwid")Integer xid){
        return z.addshenpi(type, empno, xid);
    }




/**
 * @Description:该方法名称(countxiangmu)
 * @param: []
 * @return: java.util.List<com.demo.pojo.Myproject>
 * @auther: zzl
 * @date: 2020-12-22 19:36
 */
    public List<Myproject> countxiangmu(){
        return z.countxiangmu();
    }

    /**
     * @Description:该方法名称(countype)
     * @param: []
     * @return: java.util.List<com.demo.pojo.Myproject>
     * @auther: zzl
     * @date: 2020-12-22 19:38
     */
    public List<Myproject> countype(){
        return z.countype();
    }
/**
 * @Description:该方法名称(countevel)
 * @param: []
 * @return: java.util.List<com.demo.pojo.Myproject>
 * @auther: zzl
 * @date: 2020-12-22 19:38
 */
    public List<Myproject> countevel(){
        return z.countevel();
    }

    /**
     * @Description:该方法名称(xmtype)
     * @param: []
     * @return: java.util.List<com.demo.pojo.Myproject>
     * @auther: zzl
     * @date: 2020-12-23 9:10
     */
    public List<Myproject> xmtype(){
        return z.xmtype();
    }
    
    /**
     * @Description:该方法名称(getdname)
     * @param: []
     * @return: com.demo.pojo.Emp
     * @auther: zzl
     * @date: 2020-12-23 9:58
     */
    public Emp getdname(Integer eid){
        return z.getdname(eid);
    }

    /**
     * @Description:该方法名称(listemp)
     * @param: []
     * @return: java.util.List<com.demo.pojo.Emp>
     * @auther: zzl
     * @date: 2020-12-23 15:24
     */
    public List<Emp> listemp(){
        return z.listemp();
    }

    public List<Myrisk> listrisk(Integer pageNo, Integer pageSize,Integer xid){
        PageHelper.startPage(pageNo,pageSize);
        List<Myrisk> list = z.listrisk(xid);
        PageInfo<Myrisk> info = new PageInfo<>(list);
        return z.listrisk(xid);
    }


}
