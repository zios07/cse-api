package com.cse.service;

import static com.cse.service.utils.UtilContants.NOT_FOUND_CODE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cse.domain.Property;
import com.cse.repository.PropertyRepository;
import com.cse.service.api.IPropertyService;
import com.cse.service.exception.NotFoundException;

@Service
public class PropertyService implements IPropertyService {

	@Autowired
	private PropertyRepository repo;

	@Override
	public Property save(Property property) {
		return repo.save(property);
	}

	@Override
	public Property findOne(Long id) throws NotFoundException {
		Optional<Property> optional = repo.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			throw new NotFoundException(NOT_FOUND_CODE, "Property not found with id : " + id);
	}

	@Override
	public List<Property> findAll() {
		return repo.findAll();
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		if (repo.existsById(id))
			throw new NotFoundException(NOT_FOUND_CODE, "Property not found with id : " + id);
		repo.deleteById(id);
	}

}
