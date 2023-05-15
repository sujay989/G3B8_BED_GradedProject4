package com.greatlearning.empmgmt.service;

import com.greatlearning.empmgmt.entity.Role;

public interface RoleService {

	public Role createRole(Role role);

	public Role findRole(String roleName);

}
