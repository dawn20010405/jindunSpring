package com.demo.Services;

import com.demo.model.Mapper.IDgPositionMapper;
import com.demo.pojo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: diga
 * <p>
 * Description: 岗位业务层
 * date: 2020/12/22 9:00
 */
@Service
public class DgPositionService {
    @Autowired
    IDgPositionMapper mapper;

    /*
    * @Author diga
    * @Date 2020/12/22 11:20
    * @Description 根据部门编号查询该部门下的所有岗位
    */
    public List<Position> listByDid(Integer did){
        return mapper.listByDid(did);
    }

    /*
    * @Author diga
    * @Date 2020/12/22 12:00
    * @Description 查询所有岗位
    */
    public List<Position> listPosiAll(){
        return mapper.listPosiAll();
    }

    /*
    * @Author diga
    * @Date 2020/12/22 15:39
    * @Description 岗位新增
    */
    public Integer insertPosi(String poname,Integer did){
        try {
            Integer a=mapper.insertPosi(poname, did);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /*
    * @Author diga
    * @Date 2020/12/22 18:38
    * @Description 根据部门编号、岗位名称查询
    */
    public Position getPoname(Integer did,String poname){
        return mapper.getPoname(did, poname);
    }
}
