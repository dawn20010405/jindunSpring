/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 14:24 2020-12-24
 * @ Description：
 */
package com.demo.services;

import com.demo.model.Mapper.IPxyContractsMapper;
import com.demo.pojo.Contracts;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020-12-24 14:24
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PxyContractsServices {
    @Autowired
    IPxyContractsMapper mapper;
    public Integer InsertContracts(Timestamp ckaitime, Timestamp cjietime, Integer cqixian, Integer eid, String cleixing){
        return mapper.InsertContracts(ckaitime,cjietime,cqixian,eid,cleixing);
    }
    public PageInfo<Contracts> listselectcontracts(Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        //查询方法
        List<Contracts> list = mapper.listselectcontracts();
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Contracts> info= new PageInfo<>(list);
        return info;
    }
}
