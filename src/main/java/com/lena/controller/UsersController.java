package com.lena.controller;


import com.lena.base.result.Myresult;
import com.lena.base.result.PageTableRequest;
import com.lena.entity.Users;
import com.lena.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @GetMapping("/list")
    @ResponseBody
    public Myresult<Users> getUsers(PageTableRequest page){
        Myresult<Users> result=new Myresult<>();
        page.countOffset();
        return usersService.getAllUsersByPage(page.getOffset(),page.getLimit());
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute(new Users());
        return "user/user-add";
    }

}

