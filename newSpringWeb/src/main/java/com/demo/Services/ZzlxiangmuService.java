package com.demo.Services;

import com.demo.model.Mapper.IZzlxiangmuMapper;
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

}
