package com.demo.model.Mapper;

import com.demo.pojo.Entry;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Description: 入职dao层
 * date: 2020/12/22 8:44
 *
 * @author: diga
 */
@Mapper
@Repository
public interface IDgEntryMapper {
    /*
    * @Author diga
    * @Date 2020/12/24 20:03
    * @Description 查询所有入职信息
    */
    List<Entry> listEntryAll();

    /*
    * @Author diga
    * @Date 2020/12/24 20:04
    * @Description 新增入职信息
    */
    Integer insertEntry(Integer rsid, BigDecimal emoney, Date gotime,String eniphone,Date creatime);
}
