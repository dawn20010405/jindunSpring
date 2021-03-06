package com.demo.model.Mapper;/**
 * @Auther: Length
 * @Date: 2020/12/23 09:45
 * @Description:
 */

import com.demo.pojo.AssessmentTeamLc;
import com.demo.pojo.QualitativeLc;
import com.demo.pojo.RationLc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@description: 被考核人
 *@author: larry
 *@create: 2020-12-23 09:45
 */
@Mapper
@Repository
public interface IAssessmentTeamLcMapper {
    /*
     * @Author lichao
     * @Description //新增一个被考核人
     * @Date 10:48 2020/12/23
     * @Param
     * @return
            **/
    Integer atlcadd(@Param("ass") AssessmentTeamLc ass);
    /*
     * @Author lichao
     * @Description //查询考核组
     * @Date 14:47 2020/12/23
     * @Param
     * @return
            **/
    List<AssessmentTeamLc> onetomanyac(Integer acid);
    /*
     * @Author lichao
     * @Description //新增定量表
     * @Date 21:25 2020/12/23
     * @Param
     * @return
            **/
    Integer addration(@Param("ra") RationLc ra);
    /*
     * @Author lichao
     * @Description //新增定性表
     * @Date 21:26 2020/12/23
     * @Param
     * @return
            **/
    Integer addqualitative(@Param("qu") QualitativeLc qu);
    /*
     * @Author lichao
     * @Description //修改总分
     * @Date 9:49 2020/12/24
     * @Param
     * @return
            **/
    Integer updataat(Integer scoreeid,String acopinion,Integer actotal,Integer atid);
    /*
     * @Author lichao
     * @Description //查询我参与的绩效活动
     * @Date 16:05 2020/12/24
     * @Param  
     * @return 
            **/
    List<AssessmentTeamLc> byatid(Integer ateid);
}
