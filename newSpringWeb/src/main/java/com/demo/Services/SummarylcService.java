package com.demo.Services;/**
 * @Auther: Length
 * @Date: 2020/12/24 16:43
 * @Description:
 */

import com.demo.model.Mapper.IAppealFormLcMapper;
import com.demo.model.Mapper.ISummarylcMapper;
import com.demo.pojo.AppealFormLc;
import com.demo.pojo.Summarylc;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@description: 总结表sevice
 *@author: larry
 *@create: 2020-12-24 16:43
 */
@Service
public class SummarylcService {
    @Autowired
    ISummarylcMapper sm;
    @Autowired
    IAppealFormLcMapper am;
    /*
     * @Author lichao
     * @Description //新增一个总结表
     * @Date 19:51 2020/12/24
     * @Param [s]
     * @return java.lang.Integer
            **/
    public Integer addSummarylc(Summarylc s){
        try {
            sm.addSummarylc(s);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    /*
     * @Author lichao
     * @Description //新增一个申诉表
     * @Date 19:51 2020/12/24
     * @Param
     * @return
            **/
    public Integer addAppealFormLc(AppealFormLc af){
        try {
            am.addAppealFormLc(af);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    /*
     * @Author lichao
     * @Description //查询申诉表
     * @Date 20:33 2020/12/24
     * @Param
     * @return
            **/
    public List<AppealFormLc> tu(){
        return am.tu();
    }
    /*
     * @Author lichao
     * @Description //查询总结表
     * @Date 20:33 2020/12/24
     * @Param
     * @return
            **/
    public List<Summarylc> selectsu(){
        return sm.selectsu();
    }
    /*
     * @Author lichao
     * @Description //查询申诉表分页
     * @Date 21:29 2020/12/24
     * @Param
     * @return
            **/
    public PageInfo<AppealFormLc> tu2(Integer no){
        PageHelper.startPage(no,3);
        List<AppealFormLc> list=am.tu();
        PageInfo<AppealFormLc> info=new PageInfo<>(list);
        return info;
    }
    /*
     * @Author lichao
     * @Description 查询总结分页
     * @Date 21:31 2020/12/24
     * @Param
     * @return
            **/
    public PageInfo<Summarylc> selectsu2(Integer no){
        PageHelper.startPage(no,3);
        List<Summarylc> list=sm.selectsu();
        PageInfo<Summarylc> info=new PageInfo<>(list);
        return info;
    }
}

