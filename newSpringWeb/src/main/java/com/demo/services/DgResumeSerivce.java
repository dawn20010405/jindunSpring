package com.demo.services;

import com.demo.model.Mapper.IDgResumeMapper;
import com.demo.pojo.Resume;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * @author: diga
 * <p>
 * Description: 简历业务层
 * date: 2020/12/22 9:01
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class DgResumeSerivce {
    @Autowired
    IDgResumeMapper mapper;

    /*
    * @Author diga
    * @Date 2020/12/23 16:21
    * @Description 根据招聘信息查询所有简历信息
    */
    public PageInfo<Resume> listResumeAll(Integer rid,int size,int num){
        PageHelper.startPage(num,size);
        List<Resume> list=mapper.listResumeAll(rid);
        for (Resume rs:list) {
            System.out.println("集合的值："+rs);
        }
        PageInfo<Resume> page=new PageInfo<>(list);
        return page;
    }

    /*
     * @Author diga
     * @Date 2020/12/23 16:17
     * @Description 根据招聘信息新增简历
     */
    public Integer insertResume(String rname, Integer rsex, Date rbirthday, String workyear, String education, Date createdate, Integer rid){
        try {
            Integer a=mapper.insertResume(rname, rsex, rbirthday, workyear, education, createdate, rid);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /*
     * @Author diga
     * @Date 2020/12/23 16:18
     * @Description 根据姓名、性别、生日、工作年限、学历查询
     */
    public Resume getResumeExist(String rname, Integer rsex, String rbirthday,String workyear,String education){
        return mapper.getResumeExist(rname, rsex, rbirthday, workyear, education);
    }

    /*
     * @Author diga
     * @Date 2020/12/24 16:01
     * @Description 修改简历状态
     */
    public Integer updateRstype(Integer rsid){
        try {
            Integer a=mapper.updateRstype(rsid);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /*
     * @Author diga
     * @Date 2020/12/24 21:54
     * @Description 根据简历编号查询
     */
    public Resume getRsid(Integer rsid){
       return mapper.getRsid(rsid);
    }
}
