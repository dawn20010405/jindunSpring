package com.demo.model.Mapper;

import com.demo.pojo.Numset;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Title: IQqcNumset
 * Created by qqc on 2020/12/22
 */
@Mapper
@Repository
public interface IQqcNumsetMapper {

    /**
     * @Author: qqc on 2020/12/22 15:45
     * @param : []
     * @return : com.demo.pojo.Numset
     * @Description :查询当前编号表
     */
    Numset getone();
    Numset updateone(Numset numset);
}
