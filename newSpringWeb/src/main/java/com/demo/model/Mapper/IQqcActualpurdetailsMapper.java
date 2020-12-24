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

    int insertOne(Actualpurdetails actualpurdetails);
}
