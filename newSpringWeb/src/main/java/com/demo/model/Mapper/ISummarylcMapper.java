package com.demo.model.Mapper;/**
 * @Auther: Length
 * @Date: 2020/12/24 15:53
 * @Description:
 */

import com.demo.pojo.Summarylc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@description: 总结表接口
 *@author: larry
 *@create: 2020-12-24 15:53
 */
@Repository
@Mapper
public interface ISummarylcMapper {
    /*
     * @Author lichao
     * @Description //新增一个总结表
     * @Date 16:41 2020/12/24
     * @Param
     * @return
            **/
    Integer addSummarylc(@Param("s") Summarylc s);
    /*
     * @Author lichao
     * @Description //查询总结表
     * @Date 20:32 2020/12/24
     * @Param
     * @return
            **/
    List<Summarylc> selectsu();
}
