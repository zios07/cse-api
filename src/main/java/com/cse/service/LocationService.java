package com.cse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cse.domain.Location;
import com.cse.repository.LocationRepository;
import com.cse.service.api.ILocationService;
import com.cse.service.exception.NotFoundException;

@Service
public class LocationService implements ILocationService {

	@Autowired
	private LocationRepository repo;

	@Override
	public Location save(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location findOne(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Location> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		// TODO Auto-generated method stub

	}

}
