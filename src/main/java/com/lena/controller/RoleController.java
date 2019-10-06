package com.lena.controller;



import com.lena.base.result.PageTableRequest;
import com.lena.base.result.Results;
import com.lena.dto.RoleDTO;
import com.lena.entity.Role;

import com.lena.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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

    @GetMapping("/list")
    @ResponseBody
    public Results<Role> getRole(PageTableRequest page){
        page.countOffset();

        return roleService.getAllRolesByPage(page.getOffset(),page.getLimit());
    }

    @GetMapping("/findByFuzzyRoleName")
    @ResponseBody
    public Results<Role> findByFuzzyRoleName(PageTableRequest page,String rolename){
        page.countOffset();

        return roleService.findByFuzzyRoleName(rolename,page.getOffset(),page.getLimit());
    }

    @GetMapping("/add")
    public String addRole(Model model){
        model.addAttribute("role",new Role());
        return "role/role-add2";
    }

    @PostMapping("/add")
    @ResponseBody
    public Results<Role> saveRole(@RequestBody RoleDTO roleDTO){
        System.out.println("1111111111");
        System.out.println(roleDTO.getPermissionIds()+"--"+roleDTO.getName()+"--"+roleDTO.getDescirption());
        System.out.println("222222222");
        return roleService.saveRole(roleDTO);
    }

    //跳转编辑页面
    @GetMapping("/edit")
    public String editUser(Model model,RoleDTO roleDTO){
        Role role1 = roleService.getById(roleDTO.getId());
        model.addAttribute(role1);
        return "role/role-edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public Results<Role> updateRole(RoleDTO roleDTO,Integer roleid){

        return roleService.updateRole(roleDTO,roleid);
    }

    //删除
    @GetMapping("/delete")
    @ResponseBody
    public Results deleteUser(Role role){
        int count = roleService.deleteRoleByid(role.getId());
        if(count>0){
            return Results.success();
        }else {
            return Results.failure();
        }
    }


}

