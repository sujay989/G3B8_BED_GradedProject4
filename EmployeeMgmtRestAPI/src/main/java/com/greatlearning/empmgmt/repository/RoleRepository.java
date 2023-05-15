package com.greatlearning.empmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.empmgmt.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);
}