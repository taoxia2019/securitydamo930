package com.lena.controller;


import com.lena.base.result.Myresult;
import com.lena.base.result.Results;
import com.lena.entity.Role;
import com.lena.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author taoxia
 * @since 2019-09-30
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/all")
    public Results<Role> getRoleAll(){

        return roleService.selectRoleAll();
    }

}

