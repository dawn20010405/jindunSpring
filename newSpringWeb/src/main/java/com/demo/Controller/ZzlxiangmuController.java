package com.demo.Controller;

import com.demo.Services.ZzlxiangmuService;
import com.demo.pojo.Just;
import com.demo.pojo.MyResult;
import com.demo.pojo.Myproject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: ZzlxiangmuController
 * @Description: TODO
 * @Author: zzl
 * @Date: 2020-12-22 16:28
 * @Version: v1.0
 */
@RestController()
@RequestMapping("/xm")
@CrossOrigin
public class ZzlxiangmuController {
    
    @Autowired
    ZzlxiangmuService x;

    /**
     * @Description:该方法名称(listxiangmu)
     * @param: [no, size]
     * @return: com.demo.pojo.MyResult
     * @auther: zzl
     * @date: 2020-12-22 16:29
     */
    @RequestMapping("/all")
    public MyResult listxiangmu(Integer no, Integer size){
        PageInfo<Myproject> pager=x.listxiangmu(no,size);
        return MyResult.returnObj(pager);
    }

    @RequestMapping("/add")
    public MyResult addxiangmu(){
        return MyResult.returnObj(x.addxiangmu());
    }

//    左增源  查询项目待审批 List<Myproject> listxmall();
    @RequestMapping("/xmall")
    public PageInfo<Myproject> selectggAll(@RequestParam(value = "no", required = false) Integer pageNo,
                                      @RequestParam(value = "size", required = false) Integer pageSize) {
        Integer no = (pageNo != null && pageNo >= 1) ? pageNo : 1;
        Integer size = (pageSize != null) ? pageSize : 1;
        return x.selectxmall(no,size);
    }

//    左增源  修改项目表状态 Integer updatexiangmu(Integer state,Integer xid);
    @RequestMapping("/xmupdt")
    public Integer updatezhuanzheng(@RequestParam("state")Integer state,
                                    @RequestParam("xid")Integer xid){
        return x.updatexiangmu(state,xid);
    }

}
