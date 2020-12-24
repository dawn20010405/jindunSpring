/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 15:12 2020-12-22
 * @ Description：转正表 JustServices
 */
package com.demo.Services;

import com.demo.model.Mapper.IPxyJustMapper;
import com.demo.pojo.Examine;
import com.demo.pojo.Just;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020-12-22 15:12
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PxyjustServices {
    @Autowired
    IPxyJustMapper mapper;
    public PageInfo<Just> listselectJust(Integer pageNo, Integer pageSize, Integer eid, Integer jid){
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<Just> list = mapper.listselectJust(eid,jid);
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Just> info= new PageInfo<>(list);
        return info;
    }

    /*左增源  转正表待审批查询*/
    public PageInfo<Just> selectzzAll(Integer pageNo, Integer pageSize) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper的查询方法
        List<Just> list = mapper.listselectdsAll();
        //将结果集封装到分页对象中
        PageInfo<Just> info = new PageInfo<>(list);
        //返回
        return info;
    }
    /*左增源  根据ID修改转正表*/
    public Integer updatezhuanzheng( Integer jsehngpi, Integer jid){
        return mapper.updatezhuanzhenId(jsehngpi,jid);
    }

}
