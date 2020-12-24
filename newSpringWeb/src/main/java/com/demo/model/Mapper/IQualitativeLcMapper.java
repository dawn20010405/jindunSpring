package com.demo.model.Mapper;/**
 * @Auther: Length
 * @Date: 2020/12/24 14:50
 * @Description:
 */

import com.demo.pojo.QualitativeLc;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@description: 定性表接口
 *@author: larry
 *@create: 2020-12-24 14:50
 */
@Mapper
@Repository
public interface IQualitativeLcMapper {
    /*
     * @Author lichao
     * @Description //询定性表
     * @Date 17:09 2020/12/23
     * @Param
     * @return
     **/
    List<QualitativeLc> bb(Integer atid);
}
