package com.demo.model.Mapper;

import com.demo.pojo.Intrecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description: 面试记录dao层
 * date: 2020/12/22 8:45
 *
 * @author: diga
 */
@Mapper
public interface IDgIntrecordMapper {
    /*
    * @Author diga
    * @Date 2020/12/24 17:00
    * @Description 根据面试新增面试记录
    */
    Integer insertIntrecord(Integer iresult,String iremark,Integer iid);

    /*
    * @Author diga
    * @Date 2020/12/24 18:31
    * @Description 根据面试信息编号查询面试记录
    */
    Intrecord getIntrecord(Integer iid);
}
