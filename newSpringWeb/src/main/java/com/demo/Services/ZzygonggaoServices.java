package com.demo.Services;

import com.demo.model.Mapper.IZzygonggaoMapper;
import com.demo.pojo.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ZzygonggaoServices
 * @Author: 左增源
 * @create: 2020-12-22 17:03
 * @program: demo
 * @description: 公告
 */
@Service
public class ZzygonggaoServices {
    @Autowired
    IZzygonggaoMapper zzygonggaoMapper;

    /*查询所有公告*/
    public List<Notification> selectggAll(){
        return zzygonggaoMapper.selectggAll();
    }
}
