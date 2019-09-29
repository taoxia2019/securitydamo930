package com.lena.service.impl;

import com.lena.entity.Users;
import com.lena.dao.UsersMapper;
import com.lena.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author taoxia
 * @since 2019-09-29
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
