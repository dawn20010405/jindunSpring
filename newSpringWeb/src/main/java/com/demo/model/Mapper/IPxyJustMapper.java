package com.demo.model.Mapper;

import com.demo.pojo.Just;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}
