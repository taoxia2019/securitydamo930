package com.lena.controller;


import com.lena.base.result.Myresult;
import com.lena.base.result.Results;
import com.lena.entity.Users;
import com.lena.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author taoxia
 * @since 2019-09-29
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/list")
    @ResponseBody
    public Myresult<Users> getuserslist(){
        List<Users> list = usersService.list();
        Myresult myresult=new Myresult();
        myresult.setCode(0);
        myresult.setMsg("success....");
        myresult.setCount(list.size());
        myresult.setData(list);

        return myresult;
    }

}

