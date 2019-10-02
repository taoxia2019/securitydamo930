package com.lena;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lena.dao.RoleMapper;
import com.lena.dao.UserRoleMapper;
import com.lena.dao.UsersMapper;
import com.lena.entity.UserRole;
import com.lena.entity.Users;
import com.lena.service.RoleService;
import com.lena.service.UserRoleService;
import com.lena.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Securitydemo930ApplicationTests {
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private  UserRoleMapper userRoleMapper;



	@Test
	public void contextLoads() {
		UserRole ur = userRoleService.getOne(new QueryWrapper<UserRole>().eq("userid", 18));
		System.out.println(ur.getRoleid());
		System.out.println("-----------");
		UserRole userRole = userRoleMapper.selectOne(new QueryWrapper<UserRole>().eq("userid", 18));
		System.out.println(userRole.getRoleid());
		System.out.println("---0000000000---");
	}

}
