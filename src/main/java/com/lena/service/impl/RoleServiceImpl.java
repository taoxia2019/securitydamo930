package com.lena.service.impl;

import com.lena.base.result.Results;
import com.lena.entity.Role;
import com.lena.dao.RoleMapper;
import com.lena.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author taoxia
 * @since 2019-09-30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Results<Role> getRoleAll() {
        return Results.success(roleMapper.selectCount(null),roleMapper.selectList(null));
    }
}
