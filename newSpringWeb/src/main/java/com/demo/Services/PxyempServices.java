/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 16:35 2020-12-21
 * @ Description：emp员工表 PxyempServices
 */
package com.demo.Services;

import com.demo.model.Mapper.IPxyempMapper;
import com.demo.pojo.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<Emp> listselectemp(Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<Emp> list = mapper.listselectemp();
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Emp> info= new PageInfo<>(list);
        return info;
    }
}
