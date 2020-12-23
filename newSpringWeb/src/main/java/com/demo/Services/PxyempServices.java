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
 * @Auther: 彭欣雨
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
    public PageInfo<Emp> listselectemppage(Integer pageNo, Integer pageSize, Integer eid,String ename,String eiphone){
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<Emp> list = mapper.listselectemppage(eid,ename,eiphone);
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Emp> info= new PageInfo<>(list);
        return info;
    }
    public List<Emp> listempselect(){
        return mapper.listempselect();
    }
    public List<Emp> listempselect2(){
        return mapper.listempselect2();
    }

    public Emp listempselectByeid(Integer eid){
        return mapper.listempselectByeid(eid);
    }
    /*
      * @Author Administrator
      * @Description //TODO  转正申请后 改变员工状态为转正审核中
      * @Date 16:10 2020-12-23
      * @Param [eid]
      * @return java.lang.Integer
      **/
    public Integer updateempbyeid(Integer eid){
        return mapper.updateempbyeid(eid);
    }
    public Integer updateempPidbyeid(Integer pid,Integer eid){
        return mapper.updateempPidbyeid(pid,eid);
    }
}
