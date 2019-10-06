package com.lena;


import com.lena.dao.RoleMapper;
import com.lena.dao.RolePermissionMapper;
import com.lena.dao.UserRoleMapper;
import com.lena.dao.UsersMapper;
import com.lena.dto.RoleDTO;
import com.lena.entity.RolePermission;
import com.lena.service.RoleService;
import com.lena.service.UserRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

	@Autowired
	private UsersMapper usersMapper;


	@Autowired
	private RolePermissionMapper rolePermissionMapper;





	@Test
	public void contextLoads() {

		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(1);

		List<Integer> permissionIds=new ArrayList<>();
		for(int i=1;i<26;i++){
			permissionIds.add(i);
		}


		permissionIds.forEach(l->{
			RolePermission rolePermission = new RolePermission();
			rolePermission.setRoleid(roleDTO.getId());
			rolePermission.setPermissionid(l);

			rolePermissionMapper.insert(rolePermission);
		});

		//rolePermissionMapper.save(1,permissionIds);



	}

}
