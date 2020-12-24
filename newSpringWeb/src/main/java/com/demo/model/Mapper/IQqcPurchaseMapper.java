package com.demo.model.Mapper;

import com.demo.pojo.Purchase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Title: IQqcPurchaseMapper
 * Created by qqc on 2020/12/24
 */
@Mapper
@Repository
public interface IQqcPurchaseMapper {

    /**
     * @Author: qqc on 2020/12/24 10:49
     * @param : []
     * @return : java.util.List<com.demo.pojo.Purchase>
     * @Description :查询所有的采购申请
     */
    List<Purchase> listSelectAll(@Param("start")String  start,
                                 @Param("end")String end,
                                 @Param("pname")String pname,
                                 @Param("empid")Integer empid,
                                 @Param("purchasetype")String purchasetype);
}
