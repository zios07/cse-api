package com.cse.service;

import static com.cse.service.utils.UtilContants.NOT_FOUND_CODE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cse.domain.Property;
import com.cse.domain.dto.PropertySearchDto;
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
	public Page<Property> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		if (repo.existsById(id))
			throw new NotFoundException(NOT_FOUND_CODE, "Property not found with id : " + id);
		repo.deleteById(id);
	}

	@Override
	public Page<Property> search(PropertySearchDto property, int page, int size) {
		return repo.findAll((Root<Property> root, CriteriaQuery<?> arg1, CriteriaBuilder builder) -> {
			final Collection<Predicate> predicates = new ArrayList<>();

			if (!StringUtils.isEmpty(property.getRef())) {
				Predicate predicate = builder.equal(root.get("ref"), property.getRef());
				predicates.add(predicate);
			}

			return builder.and(predicates.toArray(new Predicate[predicates.size()]));
		}, PageRequest.of(page, size));
	}

	@Override
	public Page<Property> findAllDevelopments(Pageable pageable) {
		return repo.findByActiveDateGreaterThan(new Date(), pageable);
	}

}
