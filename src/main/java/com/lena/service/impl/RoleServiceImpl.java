package com.lena.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lena.base.result.Results;
import com.lena.dao.RolePermissionMapper;
import com.lena.dto.RoleDTO;
import com.lena.entity.Role;
import com.lena.dao.RoleMapper;
import com.lena.entity.RolePermission;
import com.lena.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author taoxia
 * @since 2019-09-30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;



    @Override
    public Results<Role> selectRoleAll() {
        return Results.success(roleMapper.selectCount(null), roleMapper.selectList(null));
    }

    @Override
    public Results<Role> getAllRolesByPage(Integer offset, Integer limit) {
        return Results.success(roleMapper.countAllRoles().intValue(), roleMapper.getallRolesByPage(offset, limit));
    }

    @Override
    public Results<Role> findByFuzzyRoleName(String rolename, Integer offset, Integer limit) {
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.like("name", rolename);


        Page<Role> page = new Page<>(offset, limit);

        IPage<Role> rolesIPage = roleMapper.selectPage(page, roleQueryWrapper);
        Long total = rolesIPage.getTotal();
        List<Role> records = rolesIPage.getRecords();

        return Results.success(total.intValue(), records);

    }

    @Override
    public int deleteRoleByid(Integer id) {
        //int id1 = userRoleMapper.delete(new QueryWrapper<UserRole>().eq("userid", id));
        return roleMapper.deleteById(id);
    }

    @Override
    public Results<Role> updateRole(RoleDTO roleDTO, Integer roleid) {

        return null;
    }

    @Override
    public Results<Role> saveRole(RoleDTO roleDTO) {
        // 1.save role
        roleMapper.insert(roleDTO);

        List<Integer> permissionIds = roleDTO.getPermissionIds();

        //permissionIds.remove(0L);

        //2.save permission
        if (!CollectionUtils.isEmpty(permissionIds)) {
           //rolePermissionMapper.save(roleDTO.getId(),permissionIds);
            permissionIds.forEach(l->{
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRoleid(roleDTO.getId());
                rolePermission.setPermissionid(l);

                rolePermissionMapper.insert(rolePermission);
            });
        }


        return Results.success();
    }
}
