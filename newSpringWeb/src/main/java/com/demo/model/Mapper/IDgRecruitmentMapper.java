package com.demo.model.Mapper;

import com.demo.pojo.Recruitment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

/**
 * @author: diga
 * <p>
 * Description: 招聘dao层
 * date: 2020/12/22 16:57
 */
@Mapper
@Repository
public interface IDgRecruitmentMapper {
    /*
    * @Author diga
    * @Date 2020/12/22 19:09
    * @Description 查询所有招聘信息
    */
    List<Recruitment> listRecruAll(@RequestParam(value = "retype",required = false) Integer retype,
                                   @RequestParam(value = "poname",required = false)String poname,
                                   @RequestParam(value = "dname",required = false)String dname,
                                   @RequestParam(value = "recrudemand",required = false)String recrudemand,
                                   @RequestParam(value = "peopcout",required = false)Integer peopcout,
                                   @RequestParam(value = "hopetime1",required = false)String hopetime1,
                                   @RequestParam(value = "hopetime2",required = false)String hopetime2,
                                   @RequestParam(value = "rcreate",required = false)String rcreate);

    /*
    * @Author diga
    * @Date 2020/12/23 11:06
    * @Description 新增招聘需求
    */
    Integer insertRecru(Integer pid,Date hopetime,Integer peopcout,String recrudemand, Date rcreate, Integer retype);

    /*
    * @Author diga
    * @Date 2020/12/23 19:28
    * @Description 修改招聘需求
    */
    Integer updateRecru(Integer peopcout,Date hopetime,Integer rid);

    /*
     * @Author diga
     * @Date 2020/12/23 19:28
     * @Description 修改招聘状态(取消)
     */
    Integer updateRetype(Integer rid);
}
