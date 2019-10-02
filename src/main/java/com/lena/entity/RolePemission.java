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
@TableName("sys_role_pemission")
public class RolePemission implements Serializable {

private static final long serialVersionUID=1L;

    private Integer roleid;

    private Integer pemissionid;


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getPemissionid() {
        return pemissionid;
    }

    public void setPemissionid(Integer pemissionid) {
        this.pemissionid = pemissionid;
    }

    @Override
    public String toString() {
        return "RolePemission{" +
        "roleid=" + roleid +
        ", pemissionid=" + pemissionid +
        "}";
    }
}
