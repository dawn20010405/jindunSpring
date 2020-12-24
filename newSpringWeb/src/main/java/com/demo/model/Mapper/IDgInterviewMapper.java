package com.demo.model.Mapper;

import com.demo.pojo.Interview;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Description: 面试dao层
 * date: 2020/12/22 8:44
 *
 * @author: diga
 */
@Mapper
public interface IDgInterviewMapper {
    /*
    * @Author diga
    * @Date 2020/12/24 13:59
    * @Description 查询所有面试
    */
    List<Interview> listInterViewAll();

    /*
    * @Author diga
    * @Date 2020/12/24 14:01
    * @Description 新增面试
    */
    Integer insertInterView(@RequestParam("intype") Integer intype,
                            @RequestParam("intime") Timestamp intime,
                            @RequestParam("inaddress") String inaddress,
                            @RequestParam("rsid")Integer rsid);
}
