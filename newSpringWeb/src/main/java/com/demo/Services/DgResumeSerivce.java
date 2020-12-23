package com.demo.Services;

import com.demo.model.Mapper.IDgResumeMapper;
import com.demo.pojo.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @author: diga
 * <p>
 * Description: 简历业务层
 * date: 2020/12/22 9:01
 */
@Service
public class DgResumeSerivce {
    @Autowired
    IDgResumeMapper mapper;

    /*
    * @Author diga
    * @Date 2020/12/23 16:21
    * @Description 根据招聘信息查询所有简历信息
    */
    public List<Resume> listResumeAll(Integer rid){
        return mapper.listResumeAll(rid);
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
}
