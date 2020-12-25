package com.demo.model.Mapper;

import com.demo.pojo.Transfer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020-12-23 19:48
 * @Description:
 */
@Mapper
@Repository
public interface IPxyTransferMapper {
   List<Transfer> listselectTransfer(Integer eid, Integer tids);
   Integer InsertTransfer(Integer eid,Timestamp transfertime,String tzong,Integer did,Integer pid);
   Transfer selectTransferzui();

   /*左增源  调岗表待审批查询*/
   List<Transfer> listselectdgll();
   /*左增源  根据ID修改调岗表*/
   Integer updatediaogangId(Integer tsehngpi,Integer tids);
}
