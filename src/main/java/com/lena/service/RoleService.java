package com.lena.service;

import com.lena.base.result.Results;
import com.lena.dto.RoleDTO;
import com.lena.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author taoxia
 * @since 2019-09-30
 */
public interface RoleService extends IService<Role> {



    Results<Role> selectRoleAll();

    Results<Role> getAllRolesByPage(Integer offset, Integer limit);

    Results<Role> findByFuzzyRoleName(String rolename, Integer offset, Integer limit);

    int deleteRoleByid(Integer id);

    Results<Role> updateRole(RoleDTO roleDTO, Integer roleid);

    Results<Role> saveRole(RoleDTO roleDTO);
}
