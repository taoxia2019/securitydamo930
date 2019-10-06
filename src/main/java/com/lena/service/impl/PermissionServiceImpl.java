package com.lena.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.lena.base.result.Results;
import com.lena.entity.Permission;
import com.lena.dao.PermissionMapper;
import com.lena.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lena.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author taoxia
 * @since 2019-10-04
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public Results<Permission> listAllPermission() {
        List<Permission> datas=permissionMapper.selectList(null);
        Integer integer = permissionMapper.selectCount(null);
        /*JSONArray array=new JSONArray();

        TreeUtils.setPermissionsTree(0,datas,array);*/


        return Results.success(integer,datas);
    }
}