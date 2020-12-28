package com.demo.services;

import com.demo.model.Mapper.IZzlLoginMapper;
import com.demo.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: ZzlLoginService
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-21 20:28
 * @Version: v1.0
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class ZzlLoginService {
    @Autowired
    IZzlLoginMapper l;

    public Emp getLogin(@Param("phone") String phone, @Param("pass") String pass){
        return l.getLogin(phone, pass);
    }

}
