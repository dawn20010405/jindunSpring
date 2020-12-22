package com.demo.Services;

import com.demo.model.Mapper.IQqcNumsetMapper;
import com.demo.pojo.Numset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;

/**
 * @Title: QqcNumsetService
 * Created by qqc on 2020/12/22
 */
@Repository
public class QqcNumsetService {

    @Autowired
    IQqcNumsetMapper iQqcNumsetMapper;


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
        StringBuffer m=new StringBuffer(year);
        /*String x=String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+
        String.valueOf(minute)+String.valueOf(numset.getNum());*/
        StringBuffer n=m.append(month).append(day).append(hour).append(minute).append(numset.getNum());
        System.out.println(n);
        return n;
    }
}
