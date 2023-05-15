package com.greatlearning.empmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.greatlearning.empmgmt.entity.Role;
import com.greatlearning.empmgmt.entity.User;
import com.greatlearning.empmgmt.service.RoleService;
import com.greatlearning.empmgmt.service.UserService;
import com.greatlearning.empmgmt.serviceImpl.UserDetailsServiceImpl;

@Controller
public class AuthRESTController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserDetailsServiceImpl userService;

	@PostMapping("/addroles")
	public Role createRole(@RequestBody Role role) {
		return roleService.createRole(role);
	}

	@PostMapping("/addusers")
	public User createUser(@RequestBody User user) {
		User usr = userService.createUser(user.getUsername(), user.getPassword());
		for (Role roleName : user.getRoles()) {
			userService.addRoleToUser(usr, roleName.getName());
		}
		return usr;
	}
}
