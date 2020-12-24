package com.demo.model.Mapper;


import com.demo.pojo.Emp;
import com.demo.pojo.Myproject;
import com.demo.pojo.Myrisk;
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

    List<Myrisk> listrisk(Integer xid);
}
