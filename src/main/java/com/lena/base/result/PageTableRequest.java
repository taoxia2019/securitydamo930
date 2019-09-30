package com.lena.base.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName PageTableRequest
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/30 9:59
 * @Version 1.0
 */
@Data
public class PageTableRequest implements Serializable {
    private Integer page;
    private Integer limit;
    private Integer offset;
    public void countOffset(){
        if(null==this.page||null==this.limit){
            this.offset=0;
            return;
        }
        this.offset=(this.page-1)*this.limit;
    }

}
