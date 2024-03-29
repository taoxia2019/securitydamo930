package com.lena.base.result;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Results
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/29 15:11
 * @Version 1.0
 */
@Data
public class Results<T> implements Serializable {
    int count;//数据数量
    Integer code=0;//代码
    String msg="";//信息
    List<T> datas;//返回数据类型
    T data;//任何数据类型

    public Results(){

    }
    public Results(Integer code,String msg){
        super();
        this.code=code;
        this.msg=msg;
    }

    public Results(Integer code,String msg, T data, int count, List<T> datas) {
        this.count = count;
        this.code = code;
        this.msg = msg;
        this.datas = datas;
        this.data = data;
    }

    public static <T> Results <T> success(T data){
        return new Results<T>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),data,0,null);
    }

    public static <T> Results <T> success(String msg,T data) {
        return new Results<T>(ResponseCode.SUCCESS.getCode(),msg,data,0,null);
    }

    public static <T> Results <T> success(ResponseCode resultCode,T data) {
        return new Results<T>(resultCode.getCode(),resultCode.getMessage(),data,0,null);
    }

    //分页数据传输时，成功返回
    public static <T> Results <T> success(Integer count,List<T> datas) {
        return new Results<T>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),null,count,datas);
    }

    public static <T> Results <T> success(String msg,Integer count,List<T> datas) {
        return new Results<T>(ResponseCode.SUCCESS.getCode(),msg,null,count,datas);
    }

    public static <T> Results <T> success(ResponseCode resultCode,Integer count,List<T> datas) {
        return new Results<T>(resultCode.getCode(),resultCode.getMessage(),null,count,datas);
    }

    public static <T> Results <T> failure(){
        return new Results<T>(ResponseCode.FAIL.getCode(),ResponseCode.FAIL.getMessage());
    }

    public static <T> Results <T> failure(ResponseCode responseCode){
        return new Results<T>(responseCode.getCode(),responseCode.getMessage());
    }

    public static <T> Results <T> failure(Integer code,String msg){
        return new Results<T>(code,msg);
    }

    public static Results ok(){
        return new Results();
    }


}
