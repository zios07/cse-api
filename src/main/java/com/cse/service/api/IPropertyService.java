package com.cse.service.api;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

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

	void savePropertyPhotos(MultipartFile[] photos, String uuid) throws IOException;

	List<Property> loadMainProperties();

	List<Property> findMainDevelopments();

	Page<Property> findAllWithPhotos(Pageable pageable);

}
	