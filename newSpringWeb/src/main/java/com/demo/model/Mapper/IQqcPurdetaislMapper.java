package com.demo.model.Mapper;

import com.demo.pojo.Purdetaisl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Title: IQqcPurdetaislMapper
 * Created by qqc on 2020/12/24
 */
@Mapper
@Repository
public interface IQqcPurdetaislMapper {
    int insertOne(Purdetaisl purdetaisl);
}
