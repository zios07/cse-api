package com.cse.service.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.cse.domain.Type;
import com.cse.service.exception.NotFoundException;

public interface ITypeService {

	Type save(Type type);

	Type findOne(Long id) throws NotFoundException;

	Page<Type> findAll(PageRequest pageRequest);

	void delete(Long id) throws NotFoundException;

	List<Type> findAll();

}
