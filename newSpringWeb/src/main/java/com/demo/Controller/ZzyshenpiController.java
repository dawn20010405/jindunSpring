package com.demo.Controller;

import com.demo.model.Mapper.IZzyexamineMapper;
import com.demo.pojo.Examine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: ZzyshenpiController
 * @Author: 左增源
 * @create: 2020-12-22 12:04
 * @program: demo
 * @description: 审批
 */
@RestController
@RequestMapping("/shenpi")
public class ZzyshenpiController {
    @Autowired
    IZzyexamineMapper zzyshenpiMapper;

    @RequestMapping("/dsall")
    public List<Examine> selectdsAll(){
        return zzyshenpiMapper.selectdsAll();
    }
    @RequestMapping("/ysall")
    public List<Examine> selectysAll(){
        return zzyshenpiMapper.selectysAll();
    }

}
