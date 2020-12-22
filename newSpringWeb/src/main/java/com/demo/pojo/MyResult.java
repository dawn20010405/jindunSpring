package com.demo.pojo;

import java.io.Serializable;
import java.util.List;

/* 封装的 统一的响应对象
   1、controller的返回类型，全部要变成MyResult
   2、给所有属性加getter和setter方法
   3、实现Serializable序列化接口
* @author SMILE.Huang
* @date 2020-09-21 9:39
*/
public class MyResult implements Serializable {
  private Integer code; // 表示返回的结果（1表示正常，非1表示其他的意思）
  private String msg; // 表示返回的问题提示（一般用于错误信息提示）
  private Object obj; // 表示返回到前台的是一个实体对象
  private List<?> objs; // 表示返回到前台的是一个集合对象

  public MyResult() {
    code = 1;
  }
  // 有code值和信息需要返回。
  public MyResult(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
  // 有实体类的数据需要返回。code默认是1
  public MyResult(Object obj) {
    this.code = 1;
    this.obj = obj;
  }
  // 有集合类型的数据需要返回。code默认是1
  public MyResult(List<?> objs) {
    this.code = 1;
    this.objs = objs;
  }
  // 当代码发生错误时调用
  public static MyResult ERROR(String msg) {
    return new MyResult(-1, msg);
  }
  // 当代码需要返回一个实体类对象时调用
  public static MyResult returnObj(Object obj) {
    return new MyResult(obj);
  }
  // 当代码需要返回集合对象时调用
  public static MyResult returnObjs(List<?> objs) {
    return new MyResult(objs);
  }
  // 当代码成功的时候调用
  public static MyResult SUCCESS = new MyResult(); // code默认=1

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getObj() {
    return obj;
  }

  public void setObj(Object obj) {
    this.obj = obj;
  }

  public List<?> getObjs() {
    return objs;
  }

  public void setObjs(List<?> objs) {
    this.objs = objs;
  }
  /*1、分页查询 返回实体类对象   obj=PageInfo   code=1
    2、新增、修改                             code=1
    3、新增失败               code=-1         msg=失败的原因
    4、根据主键查询            obj=查询的结果   code=1
    5、查询所有的类型          data=查询的多条结果 code=1
    6、查询所有失败            code=-1        msg=失败的原因
  *
  * */

  @Override
  public String toString() {
    return "MyResult{"
        + "code="
        + code
        + ", msg='"
        + msg
        + '\''
        + ", obj="
        + obj
        + ", objs="
        + objs
        + '}';
  }
}
