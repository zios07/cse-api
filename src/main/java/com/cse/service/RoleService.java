package com.cse.service;

import static com.cse.service.utils.UtilContants.ROLE_CODE_ADMIN;
import static com.cse.service.utils.UtilContants.ROLE_CODE_USER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cse.domain.Role;
import com.cse.domain.User;
import com.cse.repository.RoleRepository;
import com.cse.repository.UserRepository;
import com.cse.service.api.IRoleService;
import com.cse.service.exception.ServiceException;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository repo;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Role findRoleByUsername(String username) throws ServiceException {
		User user = userRepository.findByAccountUsername(username);
		if (user == null)
			throw new ServiceException("INVALID.USERNAME", "Invalid username");

		return user.getRole();
	}

	@Override
	public Role findById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Role> findAll() {
		return repo.findAll();
	}

	@Override
	public Role getRoleUser() {
		return repo.findByRoleCode(ROLE_CODE_USER);
	}

	@Override
	public Role getRoleAdmin() {
		return repo.findByRoleCode(ROLE_CODE_ADMIN);
	}

}
