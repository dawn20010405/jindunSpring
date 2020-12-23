package com.demo.Controller;

import com.demo.Services.DgPositionService;
import com.demo.pojo.Dept;
import com.demo.pojo.MyResult;
import com.demo.pojo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: diga
 * <p>
 * Description: 岗位控制层
 * date: 2020/12/22 9:11
 */
@CrossOrigin
@RestController
@RequestMapping("/posi")
public class DgPositionController {
    @Autowired
    DgPositionService ps;

    /*
     * @Author diga
     * @Date 2020/12/22 11:22
     * @Description 根据部门编号查询该部门下的所有岗位
     */
    @RequestMapping("/finbydid/{did}")
    public MyResult listByDid(@PathVariable Integer did){
        List<Position> list=ps.listByDid(did);
        System.out.println("进来了");
        return MyResult.returnObjs(list);
    }
   /*
     * @Author Administrator
     * @Description //TODO  Positionselectbydid 根据部门did 查询岗位信息
     * @Date 15:13 2020-12-23
     * @Param [did]
     * @return java.util.List<com.demo.pojo.Position>
     **/
    @RequestMapping("/Positionselectbydid")
    public List<Position> Positionselectbydid( Integer did){
        List<Position> list=ps.listByDid(did);
        System.out.println("Positionselectbydid");
        return list;
    }
    /*
     * @Author diga
     * @Date 2020/12/22 12:01
     * @Description 查询所有岗位
     */
    @RequestMapping("/finall")
    public MyResult listPosiAll(){
        List<Position> list=ps.listPosiAll();
        return MyResult.returnObjs(list);
    }

    /*
     * @Author diga
     * @Date 2020/12/22 15:41
     * @Description 岗位新增
     */
    @RequestMapping("/insert")
    public MyResult insertPosi(@RequestParam("poname") String poname,
                               @RequestParam("did") Integer did){
        try {
            Position p=ps.getPoname(did, poname);
            if (p!=null){
                return new MyResult(-1,"该岗位名称已存在");
            }else {
                System.out.println("PoName："+poname+" did："+did);
                Integer a=ps.insertPosi(poname, did);
                if (a>0){
                    return new MyResult(1,"新增成功");
                }else{
                    return new MyResult(1,"新增失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MyResult.ERROR("新增失败");
        }
    }
}
