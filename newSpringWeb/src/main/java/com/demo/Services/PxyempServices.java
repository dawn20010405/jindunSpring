/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 16:35 2020-12-21
 * @ Description：emp员工表 PxyempServices
 */
package com.demo.Services;

import com.demo.model.Mapper.IPxyempMapper;
import com.demo.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020-12-21 16:35
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PxyempServices {
    @Autowired
    IPxyempMapper mapper;
    /*
     * @Author 彭欣雨
     * @Description //TODO 员工表查询全部
     * @Date 20:42 2020-12-21
     * @Param []
     * @return java.util.List<com.demo.pojo.Emp>
     **/
    public List<Emp> listselectemp(){
        return mapper.listselectemp();
    }
}
