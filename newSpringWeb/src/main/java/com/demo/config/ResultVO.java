package com.demo.config;
import java.io.Serializable;
import java.util.List;

public class ResultVO implements Serializable {
    private boolean code;
    private String msg;
    private Object obg;
    private List list;

    private ResultVO() {
    }

    private ResultVO(boolean code) {
        this.code = code;
    }

    private ResultVO(boolean code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResultVO(boolean code, String msg,Object obg) {
        this.code = code;
        this.msg = msg;
        this.obg = obg;
    }

    private ResultVO(boolean code, String msg, List list) {
        this.code = code;
        this.msg = msg;
        this.list = list;
    }

    public static ResultVO ok(String msg){
        return new ResultVO(true,msg);
    }

    public static ResultVO no(String msg){
        return new ResultVO(false,msg);
    }
    public static ResultVO okAndOb(String msg,Object obg){
        return new ResultVO(true,msg,obg);
    }

    public static ResultVO okAndList(String msg,List list){
        return new ResultVO(true,msg,list);
    }

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObg() {
        return obg;
    }

    public void setObg(Object obg) {
        this.obg = obg;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
