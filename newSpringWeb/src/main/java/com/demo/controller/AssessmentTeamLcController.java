package com.demo.controller;/**
 * @Auther: Length
 * @Date: 2020/12/23 10:57
 * @Description:
 */

import com.demo.services.AssessmentTeamLcService;
import com.demo.pojo.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *@description: 被考核人
 *@author: larry
 *@create: 2020-12-23 10:57
 */
@RestController
@RequestMapping("/atlcontroller")
public class AssessmentTeamLcController {
    @Autowired
    AssessmentTeamLcService as;

    /*
     * @Author lichao
     * @Description //循环新增多个被考核人
     * @Date 10:58 2020/12/23
     * @Param
     * @return
            **/
    @PostMapping("/addatlc/{acid}")
    public Integer addatlc(@RequestBody Integer data[],@PathVariable("acid") Integer acid){
       AssessmentTeamLc ass=new AssessmentTeamLc();
        for(int x:data){
           Emp emp=new Emp();
           emp.setEid(x);
           Achievementslc ac=new Achievementslc();
           ac.setAcid(acid);
           ass.setAclcone(ac);
           ass.setAtlempone(emp);
           as.addatlc(ass);
        }
        return 1;
    }
    /*
     * @Author lichao
     * @Description //查看考核组
     * @Date 14:50 2020/12/23
     * @Param
     * @return
            **/
    @RequestMapping("/allatlc")
    public PageInfo<AssessmentTeamLc> onetomanyac(Integer no,Integer acid){
        return as.onetomanyac(no,acid);
    }
    /*
     * @Author lichao
     * @Description //查询定量表
     * @Date 17:12 2020/12/23
     * @Param
     * @return
            **/
    @RequestMapping("/aa")
    public List<RationLc> a1(Integer atid){
        return as.aa(atid);
    }
    /*
     * @Author lichao
     * @Description //查定性id
     * @Date 17:14 2020/12/23
     * @Param
     * @return
            **/
    @RequestMapping("/bb")
    public List<QualitativeLc> a2(Integer atid){
        return as.bb(atid);
    }
    /*
     * @Author lichao
     * @Description //新增定量表
     * @Date 21:30 2020/12/23
     * @Param
     * @return
            **/
    @PostMapping("/addration/{atid}")
    public Integer addration(@RequestBody Integer init[],@PathVariable("atid") Integer atid){
        RationLc ra=new RationLc();
        String data[] = new String[3]; /*开辟了一个长度为3的数组*/
        data[0] = "月度绩效计划完成率"; // 第一个元素
        data[1] = "月度工作量"; // 第二个元素
        data[2] = "上级交办其他事项"; // 第三个元素

        for (int i=0;i<init.length;i++){
        AssessmentTeamLc assessmentTeamLc=new AssessmentTeamLc();
        assessmentTeamLc.setAtid(atid);
        ra.setAtlcraone(assessmentTeamLc);
        ra.setRaname(data[i]);
        ra.setRaothr("暂无");
        ra.setRascore(init[i]);
        as.addration(ra);
        }
        return  1;
    }
    /*
     * @Author lichao
     * @Description //新增定性表
     * @Date 21:45 2020/12/23
     * @Param
     * @return
            **/
    @PostMapping("/addqualitative/{atid}")
    public Integer addqualitative(@RequestBody Integer init2[],@PathVariable("atid") Integer atid){
        QualitativeLc qu=new QualitativeLc();
        String data[] = new String[3]; /*开辟了一个长度为3的数组*/
        data[0] = "业务拓展情况"; // 第一个元素
        data[1] = "团队协作性"; // 第二个元素
        data[2] = "工作态度"; // 第三个元素

        for (int i=0;i<init2.length;i++){
         AssessmentTeamLc assessmentTeamLc=new AssessmentTeamLc();
         assessmentTeamLc.setAtid(atid);
         qu.setQuaclcone(assessmentTeamLc);
         qu.setQuscore(init2[i]);
         qu.setQuname(data[i]);
         qu.setQuother("暂无");
         as.addqualitative(qu);
        }

        return  1;
    }
    /*
     * @Author lichao
     * @Description //修改总分
     * @Date 9:53 2020/12/24
     * @Param
     * @return
            **/
    @RequestMapping("/updaatlc")
    public Integer updaatlc(Integer scoreeid,String acopinion,Integer actotal,Integer atid){
        return as.updataat(scoreeid, acopinion, actotal, atid);
    }
    /*
     * @Author lichao
     * @Description //查询我参与的绩效活动
     * @Date 16:07 2020/12/24
     * @Param
     * @return
            **/
    @RequestMapping("/byatid")
    public PageInfo<AssessmentTeamLc> byatid(Integer no,Integer ateid){
        return as.byatid(no,ateid);
    }
}
