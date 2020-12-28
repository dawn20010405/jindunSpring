package com.demo.services;

import com.demo.model.Mapper.IQqcAssetsMapper;
import com.demo.model.Mapper.IQqcConsumingdetailsMapper;
import com.demo.model.Mapper.IQqcExchangeassetsMapper;
import com.demo.pojo.Assets;
import com.demo.pojo.Emp;
import com.demo.pojo.Exchangeassets;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;

/**
 * @Title: QqcExchangeassetsService
 * Created by qqc on 2020/12/23
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class QqcExchangeassetsService {
    @Autowired
    IQqcExchangeassetsMapper iQqcExchangeassetsMapper;

    @Autowired
    IQqcConsumingdetailsMapper iQqcConsumingdetailsMapper;

    @Autowired
    IQqcAssetsMapper iQqcAssetsMapper;

    @Autowired
    QqcNumsetService qqcNumsetService;
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
        Exchangeassets exchangeassets =iQqcExchangeassetsMapper.getSelectByPk(exchangeassetsid);
        exchangeassets.setCodes(iQqcConsumingdetailsMapper.listByExid(exchangeassetsid));
        return exchangeassets;
    }

    /**
     * @Author: qqc on 2020/12/24 9:32
     * @param : [exchangeassets]
     * @return : boolean
     * @Description :新增领用归还记录
     *
     */
    public boolean insertOne(Exchangeassets exchangeassets){
        try {
            System.out.println(exchangeassets);
            exchangeassets.setExasstart(new Timestamp(System.currentTimeMillis()));
            StringBuffer x=qqcNumsetService.updateone();
            StringBuffer num=new StringBuffer("LY");
            num=num.append(x);
            exchangeassets.setExasnum(num.toString());
            Emp emp=new Emp();
            emp.setEid(6);
            exchangeassets.setEmp(emp);
            iQqcExchangeassetsMapper.insertone(exchangeassets);
            //详情添加
            for (int m=0;m<exchangeassets.getCodes().size();m++){
                System.out.println(m);
                exchangeassets.getCodes().get(m).setCodedept("财务部");
                exchangeassets.getCodes().get(m).setCodename(exchangeassets.getExchassetsname());
                exchangeassets.getCodes().get(m).setCodestart(new Timestamp(System.currentTimeMillis()));
                exchangeassets.getCodes().get(m).setEmp(exchangeassets.getEmp());
                exchangeassets.getCodes().get(m).setExassets(exchangeassets);
                iQqcConsumingdetailsMapper.insertOne(exchangeassets.getCodes().get(m));
                //物资改变
                Assets assets=iQqcAssetsMapper.getByPk(exchangeassets.getCodes().get(m).getAssets().getAssetsid());
                if (assets.getAssetstype().equals("非低值消耗类")){
                    assets.setAssetsstatus("已领用");
                }else {
                    /*Assets assets1=assets;
                    assets1.setAssetsquantity(exchangeassets.getCodes().get(m).getCodesquantity());
                    assets1.setAssetsstatus("已领用");
                    iQqcAssetsMapper.insert(assets1);*/
                    assets.setAssetsquantity(assets.getAssetsquantity()-exchangeassets.getCodes().get(m).getCodesquantity());
                }
                iQqcAssetsMapper.updateone(assets);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }
}
