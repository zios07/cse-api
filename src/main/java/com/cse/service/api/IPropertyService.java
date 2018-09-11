package com.cse.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cse.domain.Property;
import com.cse.domain.dto.PropertySearchDto;
import com.cse.service.exception.NotFoundException;

public interface IPropertyService {

	Property save(Property property);

	Property findOne(Long id) throws NotFoundException;

	Page<Property> findAll(Pageable pageable);

	void delete(Long id) throws NotFoundException;

	Page<Property> search(PropertySearchDto property, int page, int size);

	Page<Property> findAllDevelopments(Pageable pageable);

}
	