package com.demo.model.Mapper;

import com.demo.pojo.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Description: 简历dao层
 * date: 2020/12/22 8:45
 *
 * @author: diga
 */
@Mapper
@Repository
public interface IDgResumeMapper {
    /*
    * @Author diga
    * @Date 2020/12/23 16:17
    * @Description 根据招聘信息查询所有简历
    */
    List<Resume> listResumeAll(Integer rid);

    /*
    * @Author diga
    * @Date 2020/12/23 16:17
    * @Description 根据招聘信息新增简历
    */
    Integer insertResume(String rname, Integer rsex, Date rbirthday,String workyear,String education,Date createdate,Integer rid);

    /*
    * @Author diga
    * @Date 2020/12/23 16:18
    * @Description 根据姓名、性别、生日、工作年限、学历查询
    */
    Resume getResumeExist(String rname, Integer rsex, String rbirthday,String workyear,String education);

    /*
    * @Author diga
    * @Date 2020/12/24 16:01
    * @Description 修改简历状态
    */
    Integer updateRstype(Integer rsid);

    /*
    * @Author diga
    * @Date 2020/12/24 21:54
    * @Description 根据简历编号查询
    */
    Resume getRsid(Integer rsid);
}
