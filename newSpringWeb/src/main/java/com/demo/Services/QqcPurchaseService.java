package com.demo.Services;

import com.demo.model.Mapper.IQqcPurchaseMapper;
import com.demo.pojo.Purchase;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

/**
 * @Title: QqcPurchaseService
 * Created by qqc on 2020/12/24
 */
@Repository
public class QqcPurchaseService {

    @Autowired
    IQqcPurchaseMapper iQqcPurchaseMapper;

    /**
     * @Author: qqc on 2020/12/24 11:17
     * @param : [pageNum, pageSize, start, end, pname, empid]
     * @return : com.github.pagehelper.PageInfo<com.demo.pojo.Purchase>
     * @Description :复合条件查询并分页
     */
    public PageInfo<Purchase> pagerSelectAll(Integer pageNum, Integer pageSize,
                                             String start,String end,
                                             String pname,Integer empid,String purchasetype){
        try {
            PageHelper.startPage(pageNum, pageSize);
            return new PageInfo<>(iQqcPurchaseMapper.listSelectAll(start, end, pname, empid, purchasetype));
        }catch (Exception e){
            e.printStackTrace();
            return new PageInfo<>();
        }
    }
}
