package com.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cse.domain.Type;
import com.cse.repository.TypeRepository;
import com.cse.service.api.ITypeService;
import com.cse.service.exception.NotFoundException;

@Service
public class TypeService implements ITypeService {

	@Autowired
	private TypeRepository repo;

	@Override
	public Type save(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type findOne(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Type> findAll() {
		return repo.findAll();
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		// TODO Auto-generated method stub

	}

}
