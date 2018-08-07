package com.cse.service.api;

import java.util.List;

import com.cse.domain.Property;
import com.cse.service.exception.NotFoundException;

public interface IPropertyService {

	Property save(Property property);

	Property findOne(Long id) throws NotFoundException;

	List<Property> findAll();

	void delete(Long id) throws NotFoundException;

}
