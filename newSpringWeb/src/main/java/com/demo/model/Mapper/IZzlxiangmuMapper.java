package com.demo.model.Mapper;


import com.demo.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: IZzlxiangmuMapper
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-22 16:03
 * @Version: v1.0
 */
@Repository
@Mapper
public interface IZzlxiangmuMapper {
/**
 * @Description:该方法名称(listxiangmu)
 * @param: []
 * @return: java.util.List<com.demo.pojo.Myproject>
 * @auther: zzl
 * @date: 2020-12-22 19:33
 * and m.empno=1 and m.tid=1 and m.state=1 and m.evel=1
 * 查询项目
 */
    List<Myproject> listxiangmu(@Param("empno") Integer empno, @Param("tid") Integer tid, @Param("state") Integer state, @Param("evel") Integer evel);

   List<Myproject> listxiangmuBystate(@Param("empno") Integer empno, @Param("tid") Integer tid, @Param("state") Integer state, @Param("evel") Integer evel);




    /**
 *
 * @Description:该方法名称(addxiangmu)
 * @param: []
 * @return: java.lang.Integer
 * @auther: zzl
 * @date: 2020-12-22 19:33
 * 新增项目
 */
//    xname,empno,start,end,explain,evel,cdate,tid
//Integer addxiangmu(@Param("xname")String xname,
//                   @Param("empno")Integer empno,
//                   @Param("start")Date start,
//                   @Param("end")Date end,
//                   @Param("explain")String explain,
//                   @Param("evel") Integer evel,
//                   @Param("cdate")Date cdate,
//                   @Param("tid")Integer tid);
    Integer addxiangmu(
            @Param("empno") Integer empno,
            @Param("tid") Integer tid,
            @Param("x") Myproject x);

    Integer addjilu(@Param("empno") Integer empno, @Param("btype") String btype, @Param("content") String content, @Param("cdate") Timestamp cdate, @Param("xid") Integer xid);

    Integer addshenpi(@Param("exstate") String type, @Param("exuser") Integer empno, @Param("wxwid") Integer xid);
/**
 * @Description:该方法名称(countxiangmu)
 * @param: []
 * @return: java.util.List<com.demo.pojo.Myproject>
 * @auther: zzl
 * @date: 2020-12-22 19:33
 * 根据项目状态统计
 */
    List<Myproject> countxiangmu();
/**
 * @Description:该方法名称(countype)
 * @param: []
 * @return: java.util.List<com.demo.pojo.Myproject>
 * @auther: zzl
 * @date: 2020-12-22 19:33
 * 根据项目类别统计
 */
    List<Myproject> countype();
/**
 * @Description:该方法名称(countevel)
 * @param: []
 * @return: java.util.List<com.demo.pojo.Myproject>
 * @auther: zzl
 * @date: 2020-12-22 19:33
 * 根据项目紧急级别统计
 */
    List<Myproject> countevel();

    /**
     * @Description:该方法名称(xmtype)
     * @param: []
     * @return: java.util.List<com.demo.pojo.Myproject>
     * @auther: zzl
     * @date: 2020-12-23 9:10
     */
    List<Myproject> xmtype();

    /**
     * @Description:该方法名称(getdname)
     * @param: []
     * @return: com.demo.pojo.Dept
     * @auther: zzl
     * @date: 2020-12-23 9:57
     */
    Emp getdname(Integer eid);

    /**
     * @Description:该方法名称(listemp)
     * @param: []
     * @return: java.util.List<com.demo.pojo.Emp>
     * @auther: zzl
     * @date: 2020-12-23 21:22
     */
    List<Emp> listemp();
/**
 * @Description:该方法名称(listrisk)
 * @param: [xid]
 * @return: java.util.List<com.demo.pojo.Myrisk>
 * @auther: zzl
 * @date: 2020-12-24 9:50
 */
    List<Myrisk> listrisk(Integer xid);

    /**
     * @Description:该方法名称(listjilu)
     * @param: [xid]
     * @return: java.util.List<com.demo.pojo.Mydynamic>
     * @auther: zzl
     * @date: 2020-12-24 10:00
     */
    List<Mydynamic> listjilu(Integer xid);

    /**
     * @Description:该方法名称(listrisktype)
     * @param: []
     * @return: java.util.List<com.demo.pojo.Myrisk>
     * @auther: zzl
     * @date: 2020-12-24 13:14
     */
    List<Myrisk> listrisktype();

    /**
     * @Description:该方法名称(getByxid)
     * @param: [xid]
     * @return: com.demo.pojo.Myproject
     * @auther: zzl
     * @date: 2020-12-24 14:13
     */
    Myproject getByxid(Integer xid);


    /**
     * @Description:该方法名称(listcanyu)
     * @param: [xid]
     * @return: java.util.List<com.demo.pojo.Emp>
     * @auther: zzl
     * @date: 2020-12-24 16:47
     */
    List<Emp> listcanyu(Integer xid);

    /**
     * @Description:该方法名称(updatejindu)
     * @param: [jindu, zidping, xid]
     * @return: java.lang.Integer
     * @auther: zzl
     * @date: 2020-12-24 19:04
     */
    Integer updatejindu(@Param("jindu")Integer jindu,@Param("ziping")Integer zidping,@Param("xid") Integer xid);
//    fname,empno,btype,content,xid,cdate,level
    /**
     * @Description:该方法名称(addrisk)
     * @param: [fname, empno, btype, content, xid, cdate, level]
     * @return: java.lang.Integer
     * @auther: zzl
     * @date: 2020-12-24 19:32
     */
    Integer addrisk(@Param("fname")String fname,@Param("empno")Integer empno,@Param("btype")String btype,@Param("content")String content,@Param("xid")Integer xid,@Param("cdate")Timestamp cdate,@Param("level")Integer level);

    /**
     * @Description:该方法名称(delectcanyu)
     * @param: [cid]
     * @return: java.lang.Integer
     * @auther: zzl
     * @date: 2020-12-24 19:55
     */
    Integer delectcanyu(Integer cid);

    Integer wancheng(Integer xid);

    /*左增源  查询项目待审批*/
    List<Myproject> listxmall();

    /*左增源  修改项目表状态*/
    Integer updatexiangmu(Integer state,Integer xid);


}
