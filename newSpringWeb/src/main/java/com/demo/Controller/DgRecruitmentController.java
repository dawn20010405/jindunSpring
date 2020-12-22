package com.demo.Controller;

import com.demo.Services.DgRecruitmentService;
import com.demo.pojo.MyResult;
import com.demo.pojo.Recruitment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

/**
 * @author: diga
 * <p>
 * Description: 招聘控制层
 * date: 2020/12/22 18:50
 */
@CrossOrigin
@RestController
@RequestMapping("/recru")
public class DgRecruitmentController {
    @Autowired
    DgRecruitmentService rs;

    /*
    * @Author diga
    * @Date 2020/12/22 19:11
    * @Description 查询所有招聘信息
    */
    @RequestMapping("/finall")
    public MyResult listRecruAll(@RequestParam(value = "retype",required = false) Integer retype,
                                 @RequestParam(value = "poname",required = false)String poname,
                                 @RequestParam(value = "dname",required = false)String dname,
                                 @RequestParam(value = "recrudemand",required = false)String recrudemand,
                                 @RequestParam(value = "peopcout",required = false)Integer peopcout,
                                 @RequestParam(value = "hopetime1",required = false)Date hopetime1,
                                 @RequestParam(value = "hopetime2",required = false)Date hopetime2){
        List<Recruitment> list=rs.listRecruAll(retype, poname, dname, recrudemand, peopcout, hopetime1, hopetime2);
        return MyResult.returnObjs(list);
    }
}
