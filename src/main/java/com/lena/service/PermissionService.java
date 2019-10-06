package com.lena.service;

import com.alibaba.fastjson.JSONArray;
import com.lena.base.result.Results;
import com.lena.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author taoxia
 * @since 2019-10-04
 */
public interface PermissionService extends IService<Permission> {

    Results<Permission> listAllPermission();
}
