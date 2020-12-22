package com.demo.model.Mapper;

import com.demo.pojo.Notification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: IZzygonggaoMapper
 * @Author: 左增源
 * @create: 2020-12-22 13:32
 * @program: demo
 * @description: 公司公告
 */
@Mapper
@Repository
public interface IZzygonggaoMapper {
    /*查询所有公告表*/
    List<Notification> selectggAll();
}
