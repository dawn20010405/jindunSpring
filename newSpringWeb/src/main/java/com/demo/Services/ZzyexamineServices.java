package com.demo.Services;

import com.demo.model.Mapper.IZzyexamineMapper;
import com.demo.pojo.Examine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: IZzyshenpiServices
 * @Author: 左增源
 * @create: 2020-12-22 12:00
 * @program: demo
 * @description: 审批
 */
@Service
public class ZzyexamineServices {
    @Autowired
    IZzyexamineMapper zzyshenpiMapper;

    /*查询待审批*/
    public List<Examine> selectdsAll(){
        return zzyshenpiMapper.selectdsAll();
    }
    /*查询已审批*/
    public List<Examine> selectysAll(){
        return zzyshenpiMapper.selectysAll();
    }
    /*新增审批表*/
    public Integer insertExamine(String exstate,Integer wxwid){
        return zzyshenpiMapper.insertExamine(exstate,wxwid);
    }
}
