package com.greatlearning.empmgmt.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.empmgmt.config.MyUserDetails;
import com.greatlearning.empmgmt.entity.Role;
import com.greatlearning.empmgmt.entity.User;
import com.greatlearning.empmgmt.repository.UserRepository;
import com.greatlearning.empmgmt.service.RoleService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		System.out.println("user --> " + user);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(user);
	}

	public User createUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return userRepository.save(user);
	}

	public void addRoleToUser(User user, String roleName) {
		Role role = roleService.findRole(roleName);
		if (role != null) {
			user.getRoles().add(role);
			userRepository.save(user);
		}
	}

}
