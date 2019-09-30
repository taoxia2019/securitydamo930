package com.lena.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author taoxia
 * @since 2019-09-30
 */
@TableName("sys_pemission")
public class Pemission implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer parentid;

    private String name;

    private String css;

    private String href;

    private Integer type;

    private String pemission;

    private Integer sort;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPemission() {
        return pemission;
    }

    public void setPemission(String pemission) {
        this.pemission = pemission;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Pemission{" +
        "id=" + id +
        ", parentid=" + parentid +
        ", name=" + name +
        ", css=" + css +
        ", href=" + href +
        ", type=" + type +
        ", pemission=" + pemission +
        ", sort=" + sort +
        "}";
    }
}
