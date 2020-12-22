package com.demo.model.Mapper;

import com.demo.pojo.Assets;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qqc on 2020/12/21
 */
@Mapper
@Repository
public interface IQqcassetsMapper {

    List<Assets> listSelectAll();
}
