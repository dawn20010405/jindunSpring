package com.demo.services;

import com.demo.model.Mapper.IQqcNumsetMapper;
import com.demo.pojo.Numset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

/**
 * @Title: QqcNumsetService
 * Created by qqc on 2020/12/22
 */
@Repository
@Transactional(rollbackFor=RuntimeException.class)
public class QqcNumsetService {

    @Autowired
    IQqcNumsetMapper iQqcNumsetMapper;

    /**
     * @Author: qqc on 2020/12/23 10:03
     * @param : []
     * @return : java.lang.StringBuffer
     * @Description :编号更新
     */
    public StringBuffer updateone(){

        Numset numset=iQqcNumsetMapper.getone();
        Date now=new Date();
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DATE);
        int hour=calendar.get(Calendar.HOUR);
        int minute=calendar.get(Calendar.MINUTE);
        if (year==numset.getYear() && month ==numset.getMonth() && day==numset.getDay()){
            int id=numset.getNum()+1;
            numset.setNum(id);
        }else{
            numset.setYear(year);
            numset.setMonth(month);
            numset.setDay(day);
            numset.setNid(100001);
        }
        iQqcNumsetMapper.updateone(numset);
        StringBuffer m=new StringBuffer();
        /*String x=String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+
        String.valueOf(minute)+String.valueOf(numset.getNum());*/
        StringBuffer n=m.append(year).append(month).append(day).append(hour).append(minute).append(numset.getNum());
        System.out.println(n);
        return n;
    }
}
