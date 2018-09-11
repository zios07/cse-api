package com.cse.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cse.domain.Location;
import com.cse.service.exception.NotFoundException;

public interface ILocationService {

	Location save(Location location);

	Location findOne(Long id) throws NotFoundException;

	Page<Location> findAll(Pageable pageRequest);

	void delete(Long id) throws NotFoundException;

}
