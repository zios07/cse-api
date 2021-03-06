package com.cse.service;

import static com.cse.service.utils.UtilContants.NOT_FOUND_CODE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;

import com.cse.domain.Gallery;
import com.cse.domain.Image;
import com.cse.domain.Property;
import com.cse.domain.dto.PropertySearchDto;
import com.cse.repository.GallertyRepository;
import com.cse.repository.PropertyRepository;
import com.cse.service.api.IPropertyService;
import com.cse.service.exception.NotFoundException;
import com.cse.service.utils.UtilContants;

@Service
public class PropertyService implements IPropertyService {

	@Autowired
	private PropertyRepository repo;

	@Autowired
	private GallertyRepository galleryRepository;

	@Override
	public Property save(Property property) {
		Property p = repo.save(property);
		this.updateEntityIdForPhoto(p.getUuid(), String.valueOf(p.getId()));
		return property;
	}

	@Override
	public Property findOne(Long id) throws NotFoundException {
		Optional<Property> optional = repo.findById(id);
		if (optional.isPresent()) {
			Property property = optional.get();
			Gallery gallery = galleryRepository.findByEntityId(String.valueOf(property.getId()));
			property.setGallery(gallery);
			return property;
		} else {
			throw new NotFoundException(NOT_FOUND_CODE, "Property not found with id : " + id);
		}
	}

	@Override
	public Page<Property> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public Page<Property> findAllWithPhotos(Pageable pageable) {
		Page<Property> result = repo.findAll(pageable);
		List<Property> properties = result != null ? result.getContent() : new ArrayList<>();
		properties.forEach(property -> {
			Gallery gallery = galleryRepository.findByEntityId(String.valueOf(property.getId()));
			if (gallery != null && gallery.getImages() != null && !gallery.getImages().isEmpty()) {
				gallery.setImages(Arrays.asList(gallery.getImages().get(0)));
				property.setGallery(gallery);
			}
		});
		return result;
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

	@Override
	public void savePropertyPhotos(MultipartFile[] photos, String uuid) throws IOException {
		Gallery gallery = new Gallery();
		gallery.setEntityId(uuid);
		List<Image> images = new ArrayList<>();
		if (photos != null && photos.length > 0) {
			for (MultipartFile photo : photos) {
				images.add(
						new Image(photo.getBytes(), UtilContants.PROPERTY_ENTITY_NAME, null, null, null, null, null));
			}
		}
		gallery.setImages(images);
		galleryRepository.save(gallery);
	}

	private void updateEntityIdForPhoto(String uuid, String propertyId) {
		galleryRepository.updateEntityId(uuid, propertyId);
	}

	@Override
	public List<Property> loadMainProperties() {
		List<Property> properties = repo.findByMainTrue();
		properties.forEach(property -> {
			Gallery gallery = galleryRepository.findByEntityId(String.valueOf(property.getId()));
			if (gallery != null && gallery.getImages() != null && !gallery.getImages().isEmpty()) {
				gallery.setImages(Arrays.asList(gallery.getImages().get(0)));
				property.setGallery(gallery);
			}
		});
		return properties;
	}

	@Override
	public List<Property> findMainDevelopments() {
		List<Property> developments = repo.findByMainTrueAndActiveDateGreaterThan(new Date());
		developments.forEach(development -> {
			Gallery gallery = galleryRepository.findByEntityId(String.valueOf(development.getId()));
			if (gallery != null && gallery.getImages() != null && !gallery.getImages().isEmpty()) {
				gallery.setImages(Arrays.asList(gallery.getImages().get(0)));
				development.setGallery(gallery);
			}
		});
		return developments;
	}

}
