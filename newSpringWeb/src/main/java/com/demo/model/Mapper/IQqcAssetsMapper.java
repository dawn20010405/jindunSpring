package com.demo.model.Mapper;

import com.demo.pojo.Assets;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qqc on 2020/12/21
 */
@Mapper
@Repository
public interface IQqcAssetsMapper {

    /**
     * @Author: qqc on 2020/12/22 10:45
     * @param : [assetsname, assetstype]
     * @return : java.util.List<com.demo.pojo.Assets>
     * @Description :复合条件查询资产
     */
    List<Assets> listSelectAll(@Param("assetsname")String assetsname,
                               @Param("assetstype")String assetstype
     );

    /**
     * @Author: qqc on 2020/12/22 15:43
     * @param : [record]
     * @return : int
     * @Description :新增资产
     */
    int insert(Assets record);


    /**
     * @Author: qqc on 2020/12/22 15:43
     * @param : [record]
     * @return : int
     * @Description ：资产修改
     */
    int updateone(Assets record);
}
