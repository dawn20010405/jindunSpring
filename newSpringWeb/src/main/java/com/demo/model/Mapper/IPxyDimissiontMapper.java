package com.demo.model.Mapper;

import com.demo.pojo.Dimission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020-12-24 10:15
 * @Description:
 */
@Mapper
@Repository
public interface IPxyDimissiontMapper {
    List<Dimission> listselectdimission(Integer eid, Integer dimid);
    Integer Insertdimission(Timestamp dimissiontime, String dzong, Integer eid);
    Dimission selectDimissionzui();

    /*左增源  离职表待审批查询*/
    List<Dimission> listselecetlzall();
    /*左增源  根据ID修改离职表*/
    Integer updatelizhiId(Integer dshenpi,Integer dimid);
}
