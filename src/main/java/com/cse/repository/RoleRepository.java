package com.cse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cse.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleCode(String roleCode);
}
