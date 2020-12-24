package com.demo.model.Mapper;

import com.demo.pojo.Contracts;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020-12-24 14:25
 * @Description:
 */
@Mapper
@Repository
public interface IPxyContractsMapper {
    Integer InsertContracts(Timestamp ckaitime,Timestamp cjietime,Integer cqixian,Integer eid,String cleixing);
    List<Contracts> listselectcontracts();
}
