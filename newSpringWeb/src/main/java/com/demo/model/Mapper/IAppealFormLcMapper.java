package com.demo.model.Mapper;/**
 * @Auther: Length
 * @Date: 2020/12/24 16:13
 * @Description:
 */

import com.demo.pojo.AppealFormLc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@description: 申诉表接口
 *@author: larry
 *@create: 2020-12-24 16:13
 */
@Repository
@Mapper
public interface IAppealFormLcMapper {
    /*
     * @Author lichao
     * @Description //提交申诉
     * @Date 19:49 2020/12/24
     * @Param
     * @return
            **/
    Integer addAppealFormLc(@Param("af") AppealFormLc af);
    /*
     * @Author lichao
     * @Description //查询所有的申诉表
     * @Date 20:30 2020/12/24
     * @Param
     * @return
            **/
    List<AppealFormLc> tu();
}
