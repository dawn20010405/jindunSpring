package com.demo.model.Mapper;/**
 * @Auther: Length
 * @Date: 2020/12/24 14:49
 * @Description:
 */

import com.demo.pojo.QualitativeLc;
import com.demo.pojo.RationLc;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@description: 定量表接口
 *@author: larry
 *@create: 2020-12-24 14:49
 */
@Repository
@Mapper
public interface IRationLcMapper {
    /*
     * @Author lichao
     * @Description //查询定量表
     * @Date 17:09 2020/12/23
     * @Param
     * @return
     **/
    List<RationLc> aa(Integer atid);

}
