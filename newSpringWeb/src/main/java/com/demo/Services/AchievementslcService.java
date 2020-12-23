package com.demo.Services;

import com.demo.model.Mapper.EmpMapper;
import com.demo.model.Mapper.IAchievementslcMapper;
import com.demo.model.jdao.IAchievementslcDao;
import com.demo.pojo.Achievementslc;
import com.demo.pojo.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Author lichao
 * @Description //TODO 
 * @Date 10:40 2020/12/22
 * @Param  
 * @return 
        **/
@Service
public class AchievementslcService {
    @Autowired
    IAchievementslcMapper am;
    @Autowired
    IAchievementslcDao ad;
    @Autowired
    EmpMapper em;
    /*
     * @Author lichao
     * @Description //查询公开的绩效活动 并分页
     * @Date 11:09 2020/12/22
     * @Param  
     * @return 
            **/
    public PageInfo<Achievementslc> selectAc(Integer no){
        PageHelper.startPage(no,3);
        List<Achievementslc> list=am.selectAc();
        PageInfo<Achievementslc> info=new PageInfo<>(list);
        return info;
    }
    /*
     * @Author lichao
     * @Description //新增一个绩效活动
     * @Date 11:11 2020/12/22
     * @Param
     * @return
            **/
    public Integer addAchievementslc(Achievementslc ac){
        try {
            ad.save(ac);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }
    /*
     * @Author lichao
     * @Description //根据eid查询
     * @Date 11:38 2020/12/22
     * @Param
     * @return
            **/
    public Emp empbyid(Integer eid){
        return em.empbyid(eid);
    }
    /*
     * @Author lichao
     * @Description //查询所有员工
     * @Date 14:46 2020/12/22
     * @Param
     * @return
            **/
    public List<Emp> empall(){
        return em.empall();
    }
    /*
     * @Author lichao
     * @Description //like 查询
     * @Date 16:38 2020/12/22
     * @Param
     * @return
            **/
    public PageInfo<Achievementslc> likename(Integer no,String acname){
        PageHelper.startPage(no,3);
        List<Achievementslc> list=am.likeAc(acname);
        PageInfo<Achievementslc> info=new PageInfo<>(list);
        return info;

    }
}