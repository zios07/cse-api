package com.cse.service.api;

import java.util.List;

import com.cse.domain.Location;
import com.cse.service.exception.NotFoundException;

public interface ILocationService {

	Location save(Location location);

	Location findOne(Long id) throws NotFoundException;

	List<Location> findAll();

	void delete(Long id) throws NotFoundException;

}
