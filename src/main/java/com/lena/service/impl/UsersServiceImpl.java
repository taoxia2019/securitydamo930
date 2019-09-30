package com.lena.service.impl;

import com.lena.base.result.Myresult;
import com.lena.dao.UsersMapper;
import com.lena.entity.Users;
import com.lena.service.UsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public Myresult<Users> getAllUsersByPage(Integer offset, Integer limit) {
        Myresult<Users> myresult =new Myresult<>();
        myresult.setCount(usersMapper.countAllUsers().intValue());
        myresult.setData(usersMapper.getallUsersByPage(offset,limit));

        return myresult;
    }
}
