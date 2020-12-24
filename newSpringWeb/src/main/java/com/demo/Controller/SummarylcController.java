package com.demo.Controller;/**
 * @Auther: Length
 * @Date: 2020/12/24 16:45
 * @Description:
 */

import com.demo.Services.SummarylcService;
import com.demo.pojo.AppealFormLc;
import com.demo.pojo.AssessmentTeamLc;
import com.demo.pojo.Summarylc;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 *@description: 总结Controller
 *@author: larry
 *@create: 2020-12-24 16:45
 */
@RestController
@RequestMapping("/suCrud")
public class SummarylcController {
    @Autowired
    SummarylcService ss;
    /*
     * @Author lichao
     * @Description //新增一个总计表
     * @Date 19:52 2020/12/24
     * @Param [s, atid]
     * @return java.lang.Integer
            **/
    @PostMapping("/insetsu/{atid}")
    public Integer addSummarylc(@RequestBody Summarylc s, @PathVariable("atid") Integer atid){

        Date date=new Date(System.currentTimeMillis());
        AssessmentTeamLc a=new AssessmentTeamLc();
        a.setAtid(atid);

        s.setSummarylcatone(a);
        s.setSutime(date);
        s.setSuother("暂无");
        System.out.println(s);
        return ss.addSummarylc(s);
    }
    /*
     * @Author lichao
     * @Description //新增一个申诉比啊
     * @Date 19:52 2020/12/24
     * @Param
     * @return
            **/
    @PostMapping("/insetaf/{atid}")
    public Integer addAppealFormLc(@RequestBody AppealFormLc af, @PathVariable("atid") Integer atid){
        Date date=new Date(System.currentTimeMillis());
        AssessmentTeamLc a=new AssessmentTeamLc();
        a.setAtid(atid);
        af.setAfadopt("0");
        af.setAftime(date);
        af.setAflclone(a);
        System.out.println(af);
        return ss.addAppealFormLc(af);
    }
    /*
     * @Author lichao
     * @Description //查询申诉表
     * @Date 20:34 2020/12/24
     * @Param
     * @return
            **/
    @RequestMapping("/tu")
    public List<AppealFormLc> tu(){
        return ss.tu();
    }

    /*
     * @Author lichao
     * @Description //查询统计表
     * @Date 20:36 2020/12/24
     * @Param
     * @return
            **/
    @RequestMapping("/selectsu")
    public List<Summarylc> selectsu(){
        return ss.selectsu();
    }
    /*
     * @Author lichao
     * @Description //查询申诉表分页
     * @Date 21:32 2020/12/24
     * @Param
     * @return
            **/
    @RequestMapping("/tu2")
    public PageInfo<AppealFormLc> tu2(Integer no){
        return ss.tu2(no);
    }
    /*
     * @Author lichao
     * @Description //查询总结分页
     * @Date 21:33 2020/12/24
     * @Param
     * @return
            **/
    @RequestMapping("/selectsu2")
    public PageInfo<Summarylc> selectsu2(Integer no){
        return ss.selectsu2(no);
    }
}
