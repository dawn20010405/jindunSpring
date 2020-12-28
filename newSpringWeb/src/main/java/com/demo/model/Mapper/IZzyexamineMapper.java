package com.demo.model.Mapper;

import com.demo.pojo.Examine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: IZzyshenpiMapper
 * @Author: 左增源
 * @create: 2020-12-22 11:39
 * @program: demo
 * @description: 审批表
 */
@Mapper
@Repository
public interface IZzyexamineMapper {
    /*查询所有待审批*/
    List<Examine> selectdsAll();
    /*查询所有已审批*/
    List<Examine> selectysAll();
    /*查询所有未通过*/
    List<Examine> selectwtgAll();
    /*跟据ID进行审批*/
    Integer updategonggao(Date exdate,String exyijian,Integer extype,String exstate,Integer wxwid);
    /*查询待审批数量*/
    Integer Countdsselect();
    /*查询已审批数量*/
    Integer Countysselect();
    /*新增审批表*/
    Integer insertExamine(@Param("exstate") String exstate, @Param("wxwid") Integer wxwid);
    /*查询已审批数量*/
    Integer Countwtgselect();
}
