package com.cse.service.api;

import com.cse.domain.Account;
import com.cse.service.exception.BadCredentialsException;
import com.cse.service.exception.NotFoundException;

public interface IAuthenticationService {

	Account authenticate(Account account) throws NotFoundException, BadCredentialsException;
}
