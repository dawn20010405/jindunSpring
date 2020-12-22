package com.demo.model.Mapper;

import com.demo.pojo.Recruitment;
import org.apache.ibatis.annotations.Mapper;
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
                                   @RequestParam(value = "hopetime1",required = false)Date hopetime1,
                                   @RequestParam(value = "hopetime2",required = false)Date hopetime2);
}
