package com.demo.model.Mapper;

import com.demo.pojo.Position;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: 岗位dao层
 * date: 2020/12/22 8:45
 *
 * @author: diga
 */
@Mapper
@Repository
public interface IDgPositionMapper {
    /*
     * @Author diga
     * @Date 2020/12/22 11:21
     * @Description 根据部门编号查询该部门下的所有岗位
     */
    List<Position> listByDid(Integer did);

    /*
     * @Author diga
     * @Date 2020/12/22 11:58
     * @Description 查询所有岗位
     */
    List<Position> listPosiAll();

    /*
     * @Author diga
     * @Date 2020/12/22 15:38
     * @Description 岗位新增
     */
    Integer insertPosi(String poname,Integer did);

    /*
     * @Author diga
     * @Date 2020/12/22 18:37
     * @Description 根据部门编号、岗位名称查询
     */
    Position getPoname(Integer did,String poname);
}
