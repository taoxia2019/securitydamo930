package com.lena.controller;



import com.lena.base.result.PageTableRequest;
import com.lena.base.result.Results;
import com.lena.dto.UsersDTO;
import com.lena.entity.Users;
import com.lena.service.UsersService;
import com.lena.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.time.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;


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
    public Results<Users> getUsers(PageTableRequest page){
        page.countOffset();

        return usersService.getAllUsersByPage(page.getOffset(),page.getLimit());
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute(new Users());
        return "user/user-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Results<Users> saveUser(UsersDTO usersDTO,Integer roleid){
        System.out.println(usersDTO.getUsername());
        System.out.println(roleid);
        System.out.println(usersDTO.getPassword());
        System.out.println(usersDTO.getBirthday());
        usersDTO.setStatus(1);
        usersDTO.setPassword(MD5.getMD5(usersDTO.getPassword()));
        System.out.println(usersDTO.getPassword());
        return usersService.saveUsers(usersDTO,roleid);
    }


    String pattern="yyyy-MM-dd";

    @InitBinder
    public void initBinder(WebDataBinder binder,WebRequest request){
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        binder.registerCustomEditor(Date.class,new CustomDateEditor(formatter,true));
    }

}

