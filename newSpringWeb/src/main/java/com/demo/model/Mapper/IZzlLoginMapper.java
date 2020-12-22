package com.demo.model.Mapper;

import com.demo.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: IZzlLoginMapper
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-21 20:25
 * @Version: v1.0
 */
@Mapper
@Repository
public interface IZzlLoginMapper {
    Emp getLogin(@Param("phone") String phone,@Param("pass") String pass);

    /*zuo 查询所有Emp表*/
    List<Emp> selectempAll();
}
