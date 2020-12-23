package com.demo.Services;

import com.demo.model.Mapper.IQqcAssetsMapper;
import com.demo.model.Mapper.IQqcNumsetMapper;
import com.demo.pojo.Assets;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Title: QqcAssetsService
 * Created by qqc on 2020/12/22
 */
@Repository
public class QqcAssetsService {

    @Autowired
    IQqcAssetsMapper iQqcAssetsMapper;


    @Autowired
    QqcNumsetService qqcNumsetService;
    /**
     * @Author: qqc on 2020/12/22 10:53
     * @param : [pageNum, pageSize, assetsname, assetstype]
     * @return : com.github.pagehelper.PageInfo<com.demo.pojo.Assets>
     * @Description :分页，根据名称分类复合查询资产
     */
    public PageInfo<Assets> pageInfoSelectAll(Integer pageNum,Integer pageSize,String assetsname,String assetstype){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(iQqcAssetsMapper.listSelectAll(assetsname, assetstype)) ;
    }

    /**
     * @Author: qqc on 2020/12/22 17:14
     * @param : [assets]
     * @return : boolean
     * @Description :新增单个物品
     */
    public boolean insertAssets(Assets assets){

        try {
            //编号确认
            StringBuffer x=qqcNumsetService.updateone();
            StringBuffer num=new StringBuffer("SZ");
            num=num.append(x);
            System.out.println("最后的编号为"+num);
            assets.setAssetsnum(num.toString());
            assets.setAssetsretime(new Timestamp(System.currentTimeMillis()));
            iQqcAssetsMapper.insert(assets);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    public int countByStatus(String status){
        List<Assets> list=iQqcAssetsMapper.countByStatus(status);
        return list.size();
    }
}
