package com.lena.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lena.base.result.Myresult;
import com.lena.base.result.Results;
import com.lena.dao.RoleMapper;
import com.lena.dao.UserRoleMapper;
import com.lena.dao.UsersMapper;
import com.lena.dto.UsersDTO;
import com.lena.entity.UserRole;
import com.lena.entity.Users;
import com.lena.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author taoxia
 * @since 2019-09-30
 */
@Service
@Transactional
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public Results<Users> getAllUsersByPage(Integer offset, Integer limit) {

        return Results.success(usersMapper.countAllUsers().intValue(),usersMapper.getallUsersByPage(offset,limit));
    }

    @Override
    public Results<Users> saveUsers(UsersDTO usersDTO, Integer roleid) {

        if (roleid != null) {
            usersDTO.setCreatetime(LocalDateTime.now());
            usersDTO.setUpdatetime(LocalDateTime.now());
            usersMapper.insert(usersDTO);

            UserRole userRole = new UserRole();
            userRole.setRoleid(roleid);
            userRole.setUserid(usersDTO.getId());
            userRoleMapper.insert(userRole);
            return Results.success();
        } else {
            return Results.failure();
        }

    }



    @Override
    public Results<Users> updateUsers(UsersDTO usersDTO, Integer roleid) {
        if (roleid != null) {
            //更新用户表
            usersMapper.updateById(usersDTO);
            //更新用户角色表
            UserRole userRole = new UserRole();
            userRole.setUserid(usersDTO.getId());
            userRole.setRoleid(roleid);

            if((userRoleMapper.selectOne(new QueryWrapper<UserRole>().eq("userid", usersDTO.getId())))!=null){
                userRoleMapper.update(userRole,new QueryWrapper<UserRole>().eq("userid", usersDTO.getId()));
            }else {
                userRoleMapper.insert(userRole);
            }
            return Results.success();
        } else {
            return Results.failure();
        }
    }

    @Override
    public Users getUserByPhone(String phone) {
        return usersMapper.getUserByPhone(phone);
    }


    public int deleteUserByid(Integer id){

        int id1 = userRoleMapper.delete(new QueryWrapper<UserRole>().eq("userid", id));
        return usersMapper.deleteById(id);
    }
}
