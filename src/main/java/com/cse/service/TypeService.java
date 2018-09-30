package com.cse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		return repo.save(type);
	}

	@Override
	public Type findOne(Long id) throws NotFoundException {
		Optional<Type> optional = repo.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		repo.deleteById(id);
	}

	@Override
	public Page<Type> findAll(PageRequest pageRequest) {
		return repo.findAll(pageRequest);
	}

	@Override
	public List<Type> findAll() {
		return repo.findAll();
	}

}
