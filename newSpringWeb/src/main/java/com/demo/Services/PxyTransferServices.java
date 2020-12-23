/**
 * @ Author     ：彭欣雨
 * @ Date       ：Created in 19:46 2020-12-23
 * @ Description：TransferServices
 */
package com.demo.Services;

import com.demo.model.Mapper.IPxyTransferMapper;
import com.demo.pojo.Just;
import com.demo.pojo.Transfer;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020-12-23 19:46
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PxyTransferServices {
    @Autowired
    IPxyTransferMapper mapper;
    public PageInfo<Transfer> listselectTransfer(Integer pageNo, Integer pageSize, Integer eid, Integer tids){
        //查询方法
        List<Transfer> list = mapper.listselectTransfer(eid,tids);
        //将结果封装到pageInfo中。这个对象中包含了很多分页的信息（如总页数、总页码、当前第几页、是否有前一页等等）
        PageInfo<Transfer> info= new PageInfo<>(list);
        return info;

    }
    public Integer InsertTransfer(Integer eid,Timestamp transfertime,String tzong,Integer did,Integer pid){
        return mapper.InsertTransfer(eid,transfertime,tzong,did,pid);
    }
    public Transfer selectTransferzui(){
        return mapper.selectTransferzui();
    }
}
