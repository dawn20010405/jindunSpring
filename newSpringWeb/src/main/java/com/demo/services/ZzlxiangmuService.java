package com.demo.services;

import com.demo.model.Mapper.IZzlxiangmuMapper;
import com.demo.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName: ZzlxiangmuService
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-22 16:24
 * @Version: v1.0
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
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

    /**
     * @Description:该方法名称(listrisk)
     * @param: [pageNo, pageSize, xid]
     * @return: java.util.List<com.demo.pojo.Myrisk>
     * @auther: zzl
     * @date: 2020-12-24 10:00
     */
    public List<Myrisk> listrisk(Integer pageNo, Integer pageSize,Integer xid){
        PageHelper.startPage(pageNo,pageSize);
        List<Myrisk> list = z.listrisk(xid);
        PageInfo<Myrisk> info = new PageInfo<>(list);
        return z.listrisk(xid);
    }

    /**
     * @Description:该方法名称(listjilu)
     * @param: [pageNo, pageSize, xid]
     * @return: java.util.List<com.demo.pojo.Mydynamic>
     * @auther: zzl
     * @date: 2020-12-24 13:16
     */
    public List<Mydynamic> listjilu(Integer pageNo, Integer pageSize,Integer xid){
        PageHelper.startPage(pageNo,pageSize);
        List<Mydynamic> list = z.listjilu(xid);
        PageInfo<Mydynamic> info = new PageInfo<>(list);
        return z.listjilu(xid);
    }

    /**
     * @Description:该方法名称(listrisktype)
     * @param: []
     * @return: java.util.List<com.demo.pojo.Myrisk>
     * @auther: zzl
     * @date: 2020-12-24 13:40
     */
    public List<Myrisk> listrisktype(){
        return z.listrisktype();
    }

    /**
     * @Description:该方法名称(getByxid)
     * @param: [xid]
     * @return: com.demo.pojo.Myproject
     * @auther: zzl
     * @date: 2020-12-24 14:45
     */
    public Myproject getByxid(Integer xid){
        return z.getByxid(xid);
    }

    /**
     * @Description:该方法名称(listcanyu)
     * @param: [xid]
     * @return: java.util.List<com.demo.pojo.Emp>
     * @auther: zzl
     * @date: 2020-12-24 16:53
     */
    public List<Emp> listcanyu(Integer xid){
        return z.listcanyu(xid);
    }

    /**
     * @Description:该方法名称(updatejindu)
     * @param: [jindu, zidping, xid]
     * @return: java.lang.Integer
     * @auther: zzl
     * @date: 2020-12-24 19:09
     */
    public Integer updatejindu(@Param("jindu")Integer jindu,@Param("ziping")Integer zidping,@Param("xid") Integer xid){
        return z.updatejindu(jindu, zidping, xid);
    }

    /**
     * @Description:该方法名称(addrisk)
     * @param: [fname, empno, btype, content, xid, cdate, level]
     * @return: java.lang.Integer
     * @auther: zzl
     * @date: 2020-12-24 19:09
     */
    public Integer addrisk(@Param("fname")String fname,@Param("empno")Integer empno,@Param("btype")String btype,@Param("content")String content,@Param("xid")Integer xid,@Param("cdate")Timestamp cdate,@Param("level")Integer level){
        return z.addrisk(fname, empno, btype, content, xid, cdate, level);
    }

    /**
     * @Description:该方法名称(delectcanyu)
     * @param: [cid]
     * @return: java.lang.Integer
     * @auther: zzl
     * @date: 2020-12-24 19:56
     */
    public Integer delectcanyu(Integer cid){
        return z.delectcanyu(cid);
    }
    /**
     * @Description:该方法名称(wancheng)
     * @param: [xid]
     * @return: java.lang.Integer
     * @auther: zzl
     * @date: 2020-12-24 20:22
     */
    public Integer wancheng(Integer xid){
        return z.wancheng(xid);
    }

    /*
     * @Author lichao
     * @Description //TODO
     * @Date 16:23 2020/12/25
     * @Param [xid, empno]
     * @return java.lang.Integer
            **/
    public Integer addempandxm(Integer xid,Integer empno){
        return z.addempandxm(xid,empno);
    }

/*
 * @Author lichao
 * @Description //TODO
 * @Date 16:44 2020/12/25
 * @Param [pageNo, pageSize]
 * @return com.github.pagehelper.PageInfo<com.demo.pojo.Myproject>
        **/
    //    左增源  查询项目待审批 List<Myproject> listxmall();
    public PageInfo<Myproject> selectxmall(Integer pageNo, Integer pageSize) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper的查询方法
        List<Myproject> list = z.listxmall();
        //将结果集封装到分页对象中
        PageInfo<Myproject> info = new PageInfo<>(list);
        //返回
        return info;
    }

    /*
     * @Author lichao
     * @Description //TODO
     * @Date 16:44 2020/12/25
     * @Param
     * @return
            **/

    //    左增源  修改项目表状态 Integer updatexiangmu(Integer state,Integer xid);
    public Integer updatexiangmu(Integer state,Integer xid){
        return z.updatexiangmu(state,xid);
    }


}
