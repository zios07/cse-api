package com.cse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cse.domain.Account;
import com.cse.repository.AccountRepository;
import com.cse.service.api.IAuthenticationService;
import com.cse.service.exception.BadCredentialsException;
import com.cse.service.exception.NotFoundException;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	private AccountRepository accountRepo;

	@Override
	public Account authenticate(Account credentials) throws NotFoundException, BadCredentialsException {
		Account account = accountRepo.findByUsername(credentials.getUsername());
		if (account == null
				|| (account.getPassword() != null && !account.getPassword().equals(credentials.getPassword())))
			throw new BadCredentialsException("AUTHENTICATION.ERROR", "Bad credentials");
		return account;
	}

}
