package com.cse.service.api;

import java.util.List;

import com.cse.domain.Type;
import com.cse.service.exception.NotFoundException;

public interface ITypeService {

	Type save(Type type);

	Type findOne(Long id) throws NotFoundException;

	List<Type> findAll();

	void delete(Long id) throws NotFoundException;

}
