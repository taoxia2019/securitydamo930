package com.lena;

import com.lena.dao.UsersMapper;
import com.lena.entity.Users;
import com.lena.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Securitydemo930ApplicationTests {

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private UsersService usersService;
	@Test
	public void contextLoads() {
		List<Users> users = usersMapper.selectList(null);
		users.forEach(u-> System.out.println(u.getUsername()));
		System.out.println("---------");
		List<Users> list = usersService.list();
		list.forEach(u-> System.out.println(u.getUsername()));

	}

}
