package com.demo.Services;

import com.demo.model.Mapper.IQqcExchangeassetsMapper;
import com.demo.pojo.Exchangeassets;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @Title: QqcExchangeassetsService
 * Created by qqc on 2020/12/23
 */
@Service
public class QqcExchangeassetsService {
    @Autowired
    IQqcExchangeassetsMapper iQqcExchangeassetsMapper;

    /**
     * @Author: qqc on 2020/12/23 14:41
     * @param : [pageNum, pageSize, exastype, exasnum, empid]
     * @return : com.github.pagehelper.PageInfo<com.demo.pojo.Exchangeassets>
     * @Description :复合条件分页查询领用归还记录
     */
    public PageInfo<Exchangeassets> listSelectAll(Integer pageNum, Integer pageSize,
                                                  String exastype,String exasnum,
                                                  Integer empid){

        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(iQqcExchangeassetsMapper.listSelectAll(exastype, exasnum, empid));
    }


    public Exchangeassets getSelectByPk(Integer exchangeassetsid){
        return iQqcExchangeassetsMapper.getSelectByPk(exchangeassetsid);
    }

    public boolean insertOne(Exchangeassets exchangeassets){
        try {
            int i=iQqcExchangeassetsMapper.insertone(exchangeassets);
            if (i>0){
                return true;
            }else {
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }
}
