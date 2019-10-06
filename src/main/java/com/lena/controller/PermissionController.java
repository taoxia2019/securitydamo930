package com.lena.controller;



import com.lena.base.DataGridView;
import com.lena.base.TreeNode;

import com.lena.entity.Permission;
import com.lena.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author taoxia
 * @since 2019-10-04
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;


    @RequestMapping("/listAllPermission")
    @ResponseBody
    public DataGridView listAllPermission(){

        List<Permission> list = permissionService.list();
        //构造 List<TreeNode>
        List<TreeNode> nodes=new ArrayList<>();
        for (Permission p1 : list) {
            String checkArr="0";
            Boolean spread= true;
            nodes.add(new TreeNode(p1.getId(), p1.getParentid(), p1.getName(), spread, checkArr));
        }
        return new DataGridView(nodes);
    }

}

