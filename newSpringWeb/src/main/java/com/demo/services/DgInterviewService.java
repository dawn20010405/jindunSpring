package com.demo.services;

import com.demo.model.Mapper.IDgInterviewMapper;
import com.demo.pojo.Interview;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author: diga
 * <p>
 * Description: 面试业务层
 * date: 2020/12/22 8:58
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class DgInterviewService {
    @Autowired
    IDgInterviewMapper mapper;

    /*
     * @Author diga
     * @Date 2020/12/24 13:59
     * @Description 查询所有面试
     */
    public PageInfo<Interview> listInterViewAll(int pagesize,int pagenum){
        PageHelper.startPage(pagenum, pagesize);
        List<Interview> list=mapper.listInterViewAll();
        PageInfo<Interview> page=new PageInfo<>(list);
        return page;
    }

    /*
     * @Author diga
     * @Date 2020/12/24 14:01
     * @Description 新增面试
     */
    public Integer insertInterView(@RequestParam("intype") Integer intype,
                                   @RequestParam("intime") Timestamp intime,
                                   @RequestParam("inaddress") String inaddress,
                                   @RequestParam("rsid")Integer rsid){
        try {
            System.out.println("所有参数s："+intype+" "+intime+" "+inaddress+" "+rsid);
            Integer a=mapper.insertInterView(intype, intime, inaddress, rsid);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
