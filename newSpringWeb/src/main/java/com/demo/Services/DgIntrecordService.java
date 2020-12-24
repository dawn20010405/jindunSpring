package com.demo.Services;

import com.demo.model.Mapper.IDgIntrecordMapper;
import com.demo.pojo.Intrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: diga
 * <p>
 * Description: 面试记录业务层
 * date: 2020/12/22 9:00
 */
@Service
public class DgIntrecordService {
    @Autowired
    IDgIntrecordMapper mapper;

    /*
     * @Author diga
     * @Date 2020/12/24 17:00
     * @Description 根据面试新增面试记录
     */
    public Integer insertIntrecord(Integer iresult,String iremark,Integer iid){
        try {
            Integer a=mapper.insertIntrecord(iresult, iremark, iid);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /*
     * @Author diga
     * @Date 2020/12/24 18:31
     * @Description 根据面试信息编号查询面试记录
     */
    public Intrecord getIntrecord(Integer iid){
        return mapper.getIntrecord(iid);
    }
}
