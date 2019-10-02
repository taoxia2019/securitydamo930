package com.lena;


import com.lena.dao.RoleMapper;
import com.lena.service.RoleService;
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


	@Test
	public void contextLoads() {
		//usersService.list().forEach(u-> System.out.println(u.getStatus()));
		roleMapper.selectList(null).forEach(r-> System.out.println(r.getName()));
		System.out.println(roleMapper.selectCount(null));
	}

}
