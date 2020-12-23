package com.demo.Services;

import com.demo.model.Mapper.IDgRecruitmentMapper;
import com.demo.pojo.Recruitment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

/**
 * @author: diga
 * <p>
 * Description: 招聘业务层
 * date: 2020/12/22 18:49
 */
@Service
public class DgRecruitmentService {
    @Autowired
    IDgRecruitmentMapper mapper;

    /*
    * @Author diga
    * @Date 2020/12/22 19:10
    * @Description 查询所有招聘信息
    */
    public List<Recruitment> listRecruAll(@RequestParam(value = "retype",required = false) Integer retype,
                                          @RequestParam(value = "poname",required = false)String poname,
                                          @RequestParam(value = "dname",required = false)String dname,
                                          @RequestParam(value = "recrudemand",required = false)String recrudemand,
                                          @RequestParam(value = "peopcout",required = false)Integer peopcout,
                                          @RequestParam(value = "hopetime1",required = false)String hopetime1,
                                          @RequestParam(value = "hopetime2",required = false)String hopetime2,
                                          @RequestParam(value = "rcreate",required = false)String rcreate){
        return mapper.listRecruAll(retype, poname, dname, recrudemand, peopcout, hopetime1, hopetime2,rcreate);
    }

    /*
    * @Author diga
    * @Date 2020/12/23 11:07
    * @Description 新增招聘需求
    */
    public Integer insertRecru(Integer pid,Date hopetime,Integer peopcout,String recrudemand,Date rcreate, Integer retype){
        try {
            Integer a=mapper.insertRecru(pid, hopetime, peopcout, recrudemand, rcreate, retype);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    /*
     * @Author diga
     * @Date 2020/12/23 19:28
     * @Description 修改招聘需求
     */
    public Integer updateRecru(Integer peopcout,Date hopetime,Integer rid){
        try {
            Integer a=mapper.updateRecru(peopcout, hopetime, rid);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /*
     * @Author diga
     * @Date 2020/12/23 19:28
     * @Description 修改招聘状态(取消)
     */
    public Integer updateRetype(Integer rid){
        try {
            Integer a=mapper.updateRetype(rid);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
