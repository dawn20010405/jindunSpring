package com.demo.model.Mapper;

import com.demo.pojo.Myproject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: IZzlxiangmuMapper
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-22 16:03
 * @Version: v1.0
 */
@Repository
@Mapper
public interface IZzlxiangmuMapper {

    List<Myproject> listxiangmu();

    Integer addxiangmu();
}
