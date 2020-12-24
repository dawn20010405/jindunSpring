package com.demo.model.Mapper;

import com.demo.pojo.Exchangeassets;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: IQqcExchangeassetsMapper
 * Created by qqc on 2020/12/23
 */
@Mapper
@Repository
public interface IQqcExchangeassetsMapper {
    /**
     * @Author: qqc on 2020/12/23 15:43
     * @param : [exastype, exasnum, empid]
     * @return : java.util.List<com.demo.pojo.Exchangeassets>
     * @Description :复合条件查询所有的领用归还记录
     */
    List<Exchangeassets> listSelectAll(@Param("exastype")String exastype,
                                       @Param("exasnum")String exasnum,
                                       @Param("empid")Integer empid);

    /**
     * @Author: qqc on 2020/12/23 15:48
     * @param : [exid]
     * @return : com.demo.pojo.Exchangeassets
     * @Description :查询单条领用归还记录详细信息
     */
    Exchangeassets getSelectByPk(Integer exid);

    int insertone(Exchangeassets record);
}
