package com.lena.service;

import com.lena.base.result.Myresult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lena.entity.Users;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author taoxia
 * @since 2019-09-30
 */
public interface UsersService extends IService<Users> {


    Myresult<Users> getAllUsersByPage(Integer offset, Integer limit);
}
