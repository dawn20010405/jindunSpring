package com.demo.services;

import com.demo.model.Mapper.IZzyexamineMapper;
import com.demo.pojo.Examine;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: IZzyshenpiServices
 * @Author: 左增源
 * @create: 2020-12-22 12:00
 * @program: demo
 * @description: 审批
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class ZzyexamineServices {
    @Autowired
    IZzyexamineMapper zzyshenpiMapper;

    /*查询待审批*/
    public PageInfo<Examine> selectdsAll(Integer pageNo, Integer pageSize) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper的查询方法
        List<Examine> list = zzyshenpiMapper.selectdsAll();
        //将结果集封装到分页对象中
        PageInfo<Examine> info = new PageInfo<>(list);
        //返回
        return info;
    }
    /*查询已审批*/
    public PageInfo<Examine> selectysAll(Integer pageNo, Integer pageSize) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper的查询方法
        List<Examine> list = zzyshenpiMapper.selectysAll();
        //将结果集封装到分页对象中
        PageInfo<Examine> info = new PageInfo<>(list);
        //返回
        return info;
    }
    /*查询未通过*/
    public PageInfo<Examine> selectwtgAll(Integer pageNo, Integer pageSize) {
        //配置分页信息
        PageHelper.startPage(pageNo, pageSize);
        //调用Mapper的查询方法
        List<Examine> list = zzyshenpiMapper.selectwtgAll();
        //将结果集封装到分页对象中
        PageInfo<Examine> info = new PageInfo<>(list);
        //返回
        return info;
    }

    /*跟据ID进行审批 Integer updategonggao(Date exdate,String exyijian,Integer extype,Integer wxwid);*/
    public Integer updategonggao(Date exdate, String exyijian, Integer extype,String exstate, Integer wxwid){
        return zzyshenpiMapper.updategonggao(exdate,exyijian,extype,exstate,wxwid);
    }

    //    查询待审批数量 Integer Countdsselect();
    public Integer selectdsCount(){
        return zzyshenpiMapper.Countdsselect();
    }

    //    查询已审批数量 Integer Countysselect();
    public Integer selectysCount(){
        return zzyshenpiMapper.Countysselect();
    }

    /*新增审批表*/
    public Integer insertExamine(String exstate,Integer wxwid){
        return zzyshenpiMapper.insertExamine(exstate,wxwid);
    }

    //    查询已审批数量 Integer Countwtgselect();
    public Integer cuountwtgselect(){
        return zzyshenpiMapper.Countwtgselect();
    }
}
