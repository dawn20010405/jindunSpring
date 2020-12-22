package com.demo.Controller;

import com.demo.Services.ZzlLoginService;
import com.demo.pojo.Emp;
import com.demo.pojo.MyResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ZzlLoginController
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-21 20:32
 * @Version: v1.0
 */
@RestController()
@RequestMapping("/login")
@CrossOrigin
public class ZzlLoginController {

    @Autowired
    ZzlLoginService z;
/**
 * @Description:该方法名称(getLogin)
 * @param: [phone, pass]
 * @return: com.demo.pojo.Emp
 * @auther: zzl
 * @date: 2020-12-21 20:35
 */
    @RequestMapping("/denglu")
    public MyResult getLogin(String phone,String pass) throws JsonProcessingException {
        return MyResult.returnObj(z.getLogin(phone,pass));
    }

}
