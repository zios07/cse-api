package com.cse.service.api;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.cse.domain.Location;
import com.cse.service.exception.NotFoundException;

public interface ILocationService {

	Location save(Location location);

	Location findOne(Long id) throws NotFoundException;

	Page<Location> findAll(Pageable pageRequest);

	void delete(Long id) throws NotFoundException;

	void saveLocationPhoto(MultipartFile photo, String uuid) throws IOException;

	List<Location> loadMainLocations();

}
