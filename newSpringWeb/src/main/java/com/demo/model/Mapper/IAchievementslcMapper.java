package com.demo.model.Mapper;

import com.demo.pojo.Achievementslc;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @Author lichao
 * @Description //TODO 
 * @Date 10:39 2020/12/22
 * @Param  
 * @return 
        **/
@Repository
@Mapper
public interface IAchievementslcMapper {
    /*
     * @Author lichao
     * @Description //查询绩效表
     * @Date 16:37 2020/12/22
     * @Param []
     * @return java.util.List<com.demo.pojo.Achievementslc>
            **/
    List<Achievementslc> selectAc();
    /*
     * @Author lichao
     * @Description //like 查询
     * @Date 16:37 2020/12/22
     * @Param
     * @return
            **/
    List<Achievementslc> likeAc(String acname);
}
