package com.demo.services;

import com.demo.model.Mapper.IZzygonggaoMapper;
import com.demo.pojo.Notification;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: ZzygonggaoServices
 * @Author: 左增源
 * @create: 2020-12-22 17:03
 * @program: demo
 * @description: 公告
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class ZzygonggaoServices {
    @Autowired
    IZzygonggaoMapper zzygonggaoMapper;

    /*查询所有公告*/
    public PageInfo<Notification> selectggAll(Integer pageNo, Integer pageSize) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper的查询方法
        List<Notification> list = zzygonggaoMapper.selectggAll();
        //将结果集封装到分页对象中
        PageInfo<Notification> info = new PageInfo<>(list);
        //返回
        return info;
    }

    /*根据ID查询*/
    public Notification getselectid(Integer noid){
        return zzygonggaoMapper.getselectid(noid);
    }

    /*根据ID修改状态*/
    public Integer updategonggao(Integer notype,Integer noid){
        return zzygonggaoMapper.updategonggao(notype,noid);
    }
}
