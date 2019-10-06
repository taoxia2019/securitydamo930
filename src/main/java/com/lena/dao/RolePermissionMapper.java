package com.lena.dao;

import com.lena.entity.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author taoxia
 * @since 2019-10-04
 */
@Repository
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    int save(@Param("roleid")Integer id, @Param("permissionIds")List<Integer> permissionIds);
}
