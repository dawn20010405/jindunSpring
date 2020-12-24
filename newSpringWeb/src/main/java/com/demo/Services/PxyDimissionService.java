/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 10:12 2020-12-24
 * @ Description：离职表
 */
package com.demo.Services;

import com.demo.model.Mapper.IPxyDimissiontMapper;
import com.demo.model.Mapper.IPxyJustMapper;
import com.demo.pojo.Dimission;
import com.demo.pojo.Just;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020-12-24 10:12
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PxyDimissionService {
    @Autowired
    IPxyDimissiontMapper mapper;
    public PageInfo<Dimission> listselectdimission(Integer pageNo, Integer pageSize, Integer eid, Integer dimid){
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<Dimission> list = mapper.listselectdimission(eid,dimid);
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Dimission> info= new PageInfo<>(list);
        return info;
    }

    public Integer Insertdimission(Timestamp dimissiontime, String dzong, Integer eid){
        return mapper.Insertdimission(dimissiontime,dzong,eid);
    }
    public Dimission selectDimissionzui(){
        return mapper.selectDimissionzui();
    }

    //    左增源  离职表待审批查询List<Dimission> listselecetlzall();
    public PageInfo<Dimission> selectlzall(Integer pageNo, Integer pageSize) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper的查询方法
        List<Dimission> list = mapper.listselecetlzall();
        //将结果集封装到分页对象中
        PageInfo<Dimission> info = new PageInfo<>(list);
        //返回
        return info;
    }
    //    左增源  根据ID修改离职表Integer updatelizhiId(Integer dshenpi,Integer dimid);
    public Integer updatelizhi(Integer dshenpi, Integer dimid){
        return mapper.updatelizhiId(dshenpi,dimid);
    }

}
