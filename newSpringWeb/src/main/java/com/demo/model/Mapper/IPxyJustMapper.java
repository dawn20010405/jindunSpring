package com.demo.model.Mapper;

import com.demo.pojo.Just;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020-12-22 15:17
 * @Description:
 */
@Mapper
@Repository
public interface IPxyJustMapper {
     List<Just> listselectJust(Integer eid, Integer jid);
     List<Just> selectJustByjsehngpi();
     /*
      * @Author Administrator
      * @Description //TODO 转正表新增
      * @Date 14:30 2020-12-23
      * @Param [justtime, jzong, jsex]
      * @return java.lang.Integer
      **/
     Integer InsertJust(Timestamp justtime, String jzong, Integer eid, Integer pid);
     Just selectJustzui();

     /*左增源  转正表待审批查询*/
     List<Just> listselectdsAll();
     /*左增源  根据ID修改转正表*/
     Integer updatezhuanzhenId(Integer jsehngpi,Integer jid);
}
