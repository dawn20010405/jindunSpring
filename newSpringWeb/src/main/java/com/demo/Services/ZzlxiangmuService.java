package com.demo.Services;

import com.demo.model.Mapper.IZzlxiangmuMapper;
import com.demo.pojo.Just;
import com.demo.pojo.Myproject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ZzlxiangmuService
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-22 16:24
 * @Version: v1.0
 */
@Service
public class ZzlxiangmuService {

    @Autowired
    IZzlxiangmuMapper z;

    public PageInfo<Myproject> listxiangmu(Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Myproject> list = z.listxiangmu();
        PageInfo<Myproject> info = new PageInfo<>(list);
        return info;
    }

    public Integer addxiangmu(){
        return z.addxiangmu();
    }

//    左增源  查询项目待审批 List<Myproject> listxmall();
public PageInfo<Myproject> selectxmall(Integer pageNo, Integer pageSize) {
    //配置分页信息
    PageHelper.startPage(pageNo, pageSize);
    //调用Mapper的查询方法
    List<Myproject> list = z.listxmall();
    //将结果集封装到分页对象中
    PageInfo<Myproject> info = new PageInfo<>(list);
    //返回
    return info;
}

//    左增源  修改项目表状态 Integer updatexiangmu(Integer state,Integer xid);
    public Integer updatexiangmu(Integer state,Integer xid){
        return z.updatexiangmu(state,xid);
    }

}
