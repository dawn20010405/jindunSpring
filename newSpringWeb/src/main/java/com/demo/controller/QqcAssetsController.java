package com.demo.controller;

import com.demo.services.QqcAssetsService;
import com.demo.pojo.Assets;
import com.demo.pojo.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    /**
     * @Author: qqc on 2020/12/24 14:38
     * @param : [assets]
     * @return : com.demo.pojo.MyResult
     * @Description :根据资产类别，是否关联物品新增
     */
    @RequestMapping("/add")
    public MyResult insertAssets(@RequestBody Assets assets){

        try{
            //根据资产分类分别新增资产
            int i=1;
            int x=assets.getAssetsquantity();
            if (assets.getAssetstype().equals("非低值消耗类")){
                //非低值消耗类需要单个添加
                assets.setAssetsquantity(1);
                //根据资产状态分类判断是否为新增
                if (assets.getAssetsstatus() !=null){
                    i=qqcAssetsService.countByStatus(assets.getAssetsstatus())+1;
                }else{
                    //新物品名称为资产分类
                    assets.setAssetsstatus(assets.getAssetsname());
                }
                //根据数量单个添加资产
                for(int m=0;m<x;m++){
                    //根据总数更改名字
                    assets.setAssetsname(assets.getAssetsstatus()+i);
                    qqcAssetsService.insertAssets(assets);
                    i++;
                }
            //低值消耗类一起添加，新物品不与老物品叠加
            }else{
                assets.setAssetsstatus("固定资产");
                qqcAssetsService.insertAssets(assets);
            }
            return MyResult.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return MyResult.ERROR("新增失败！");
        }

    }

    /**
     * @Author: qqc on 2020/12/24 20:38
     * @param : [assetstype]
     * @return : com.demo.pojo.MyResult
     * @Description : 根据方式查询不同种类的物资
     */
    @RequestMapping("/loadtype")
    public MyResult listSelectByType(@RequestParam("assetstype")String assetstype){


        try{
            return MyResult.returnObjs(qqcAssetsService.listSelectByType(assetstype));
        }catch (Exception e){
            e.printStackTrace();
            return MyResult.ERROR("查询失败！");
        }
    }
}
