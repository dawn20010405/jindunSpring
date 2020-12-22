package com.demo.Controller;

import com.demo.Services.QqcAssetsService;
import com.demo.pojo.Assets;
import com.demo.pojo.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: QqcAssetsController
 * Created by qqc on 2020/12/22
 */
@RestController
@CrossOrigin
@RequestMapping("/assets")
@Transactional
public class QqcAssetsController {

    @Autowired
    QqcAssetsService qqcAssetsService;

    /**
     * @Author: qqc on 2020/12/22 11:15
     * @param : [pageNum, pageSize, assetsname, assetstype]
     * @return : com.demo.pojo.MyResult
     * @Description :分页根据名称分类查询返回pager，失败code为-1；
     */
    @RequestMapping("/load")
    public MyResult pageinfoSelectAll(@RequestParam("pageNum")Integer pageNum,
                                      @RequestParam("pageSize")Integer pageSize,
                                      @RequestParam("assetsname")String assetsname,
                                      @RequestParam("assetstype")String assetstype){

        try{
            return MyResult.returnObj(qqcAssetsService.pageInfoSelectAll(pageNum, pageSize, assetsname, assetstype));
        }catch (Exception e){
            return MyResult.ERROR("查询失败！");
        }
    }

    @RequestMapping("/add")
    public MyResult insertAssets(@RequestBody Assets assets){
        try{
            Boolean x=qqcAssetsService.insertAssets(assets);
            if (x){
                return MyResult.SUCCESS;
            }else {
                return MyResult.ERROR("新增失败！");
            }
        }catch (Exception e){

            return MyResult.ERROR("新增失败！");
        }

    }
}
