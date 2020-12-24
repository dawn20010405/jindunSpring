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
    List<Assets> listSelectByType(@Param("assetstype")String assetstype,
                                  @Param("assetsgstatus")String assetsgstatus);
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

    /**
     * @Author: qqc on 2020/12/23 9:47
     * @param : [Status]
     * @return : java.util.List<com.demo.pojo.Assets>
     * @Description :返回某种情况下的list
     */
    List<Assets> countByStatus(String Status);

    /**
     * @Author: qqc on 2020/12/24 17:14
     * @param : [assetsid]
     * @return : com.demo.pojo.Assets
     * @Description :根据主键查询单个物品
     */
    Assets getByPk(Integer assetsid);

}
