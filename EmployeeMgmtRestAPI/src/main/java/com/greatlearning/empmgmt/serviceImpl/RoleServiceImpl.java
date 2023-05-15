package com.greatlearning.empmgmt.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.empmgmt.entity.Role;
import com.greatlearning.empmgmt.repository.RoleRepository;
import com.greatlearning.empmgmt.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public Role createRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public Role findRole(String roleName) {
		return roleRepo.findByName(roleName);
	}

}
