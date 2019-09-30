package com.lena;


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


	@Test
	public void contextLoads() {
		//usersService.list().forEach(u-> System.out.println(u.getStatus()));
		roleService.list().forEach(r-> System.out.println(r.getName()));
	}

}
