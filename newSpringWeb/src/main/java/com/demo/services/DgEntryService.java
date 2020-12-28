package com.demo.services;

import com.demo.model.Mapper.IDgEntryMapper;
import com.demo.pojo.Entry;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * @author: diga
 * <p>
 * Description: 入职业务层
 * date: 2020/12/22 8:57
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class DgEntryService {
    @Autowired
    IDgEntryMapper mapper;

    /*
     * @Author diga
     * @Date 2020/12/24 20:03
     * @Description 查询所有入职信息
     */
    public PageInfo<Entry> listEntryAll(int pagesize,int pagenum){
        PageHelper.startPage(pagenum, pagesize);
        List<Entry> list=mapper.listEntryAll();
        PageInfo<Entry> page=new PageInfo<>(list);
        return page;
    }

    /*
     * @Author diga
     * @Date 2020/12/24 20:04
     * @Description 新增入职信息
     */
    public Integer insertEntry(Integer rsid, BigDecimal emoney, Date gotime, String eniphone, Date creatime){
        try {
            Integer a=mapper.insertEntry(rsid, emoney, gotime, eniphone, creatime);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
