package com.demo.Services;/**
 * @Auther: Length
 * @Date: 2020/12/23 10:53
 * @Description:
 */

import com.demo.model.Mapper.IAssessmentTeamLcMapper;
import com.demo.pojo.Achievementslc;
import com.demo.pojo.AssessmentTeamLc;
import com.demo.pojo.QualitativeLc;
import com.demo.pojo.RationLc;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@description: 被考核人
 *@author: larry
 *@create: 2020-12-23 10:53
 */
@Service
public class AssessmentTeamLcService {
    @Autowired
    IAssessmentTeamLcMapper am;
    /*
     * @Author lichao
     * @Description //新增一个被考核人
     * @Date 10:54 2020/12/23
     * @Param
     * @return
            **/
    public Integer addatlc(AssessmentTeamLc ass){
        try {
            am.atlcadd(ass);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }
    /*
     * @Author lichao
     * @Description //新增一个考核组
     * @Date 14:48 2020/12/23
     * @Param
     * @return
            **/
    public PageInfo<AssessmentTeamLc> onetomanyac(Integer no,Integer acid){
        PageHelper.startPage(no,3);
        List<AssessmentTeamLc> list=am.onetomanyac(acid);
        PageInfo<AssessmentTeamLc> info=new PageInfo<>(list);
        return info;
    }
    /*
     * @Author lichao
     * @Description //查询定量表
     * @Date 17:10 2020/12/23
     * @Param  
     * @return 
            **/
    public List<RationLc> aa(Integer atid){
        return am.aa(atid);
    }
    /*
     * @Author lichao
     * @Description //询定性表
     * @Date 17:12 2020/12/23
     * @Param
     * @return
            **/
    public List<QualitativeLc> bb(Integer atid){
        return am.bb(atid);
    }

    /*
     * @Author lichao
     * @Description //新增定量表
     * @Date 21:27 2020/12/23
     * @Param
     * @return
            **/
    public Integer addration(RationLc ra){
        try {
            am.addration(ra);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }
    /*
     * @Author lichao
     * @Description //新增定性表
     * @Date 21:28 2020/12/23
     * @Param
     * @return
            **/
    public Integer addqualitative(QualitativeLc qu){
        try {
            am.addqualitative(qu);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }
}
