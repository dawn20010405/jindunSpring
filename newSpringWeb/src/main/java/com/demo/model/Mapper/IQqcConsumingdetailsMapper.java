package com.demo.model.Mapper;

import com.demo.pojo.Consumingdetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: IQqcConsumingdetailsMapper
 * Created by qqc on 2020/12/23
 */
@Repository
@Mapper
public interface IQqcConsumingdetailsMapper {

    /**
     * @Author: qqc on 2020/12/24 17:15
     * @param : [consumingdetails]
     * @return : int
     * @Description :新增领用详情记录
     */
    int  insertOne(Consumingdetails consumingdetails);
    List<Consumingdetails> listByExid(Integer exid);
}
