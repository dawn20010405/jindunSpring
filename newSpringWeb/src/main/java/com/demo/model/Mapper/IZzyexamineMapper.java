package com.demo.model.Mapper;

import com.demo.pojo.Examine;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

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
}
