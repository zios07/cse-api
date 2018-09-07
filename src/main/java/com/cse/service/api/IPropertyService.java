package com.cse.service.api;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cse.domain.Property;
import com.cse.domain.dto.PropertySearchDto;
import com.cse.service.exception.NotFoundException;

public interface IPropertyService {

	Property save(Property property);

	Property findOne(Long id) throws NotFoundException;

	List<Property> findAll();

	void delete(Long id) throws NotFoundException;

	Page<Property> search(PropertySearchDto property, int page, int size);

}
