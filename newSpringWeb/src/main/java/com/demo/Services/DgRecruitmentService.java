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
                                          @RequestParam(value = "hopetime1",required = false)Date hopetime1,
                                          @RequestParam(value = "hopetime2",required = false)Date hopetime2){
        return mapper.listRecruAll(retype, poname, dname, recrudemand, peopcout, hopetime1, hopetime2);
    }
}
