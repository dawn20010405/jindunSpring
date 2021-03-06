package com.demo.model.Mapper;

import com.demo.pojo.Actualpurdetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Title: IQqcActualpurdetailsMapper
 * Created by qqc on 2020/12/24
 */
@Mapper
@Repository
public interface IQqcActualpurdetailsMapper {

    /**
     * @Author: qqc on 2020/12/24 20:39
     * @param : [actualpurdetails]
     * @return : int
     * @Description :新增采购申请
     */
    int insertOne(Actualpurdetails actualpurdetails);
}
