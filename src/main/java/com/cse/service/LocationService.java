package com.cse.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cse.domain.Gallery;
import com.cse.domain.Image;
import com.cse.domain.Location;
import com.cse.repository.GallertyRepository;
import com.cse.repository.LocationRepository;
import com.cse.service.api.ILocationService;
import com.cse.service.exception.NotFoundException;
import com.cse.service.utils.UtilContants;

@Service
public class LocationService implements ILocationService {

	@Autowired
	private LocationRepository repo;

	@Autowired
	private GallertyRepository galleryRepository;

	@Override
	public Location save(Location location) {
		Location l = repo.save(location);
		this.updateEntityIdForPhoto(l.getUuid(), String.valueOf(l.getId()));
		return l;
	}

	@Override
	public Location findOne(Long id) throws NotFoundException {
		Optional<Location> optional = repo.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public Page<Location> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		repo.deleteById(id);
	}

	@Override
	public void saveLocationPhoto(MultipartFile photo, String uuid) throws IOException {
		Gallery gallery = new Gallery();
		gallery.setEntityId(uuid);
		Image image = new Image(photo.getBytes(), UtilContants.LOCATION_ENTITY_NAME, null, null, null, null, null);
		gallery.setImages(Arrays.asList(image));
		galleryRepository.save(gallery);
	}
	
	private void updateEntityIdForPhoto(String uuid, String propertyId) {
		galleryRepository.updateEntityId(uuid, propertyId);
	}

	@Override
	public List<Location> loadMainLocations() {
		List<Location> locations = repo.findByMainTrue();
		locations.forEach(location -> {
			Gallery gallery = galleryRepository.findByEntityId(String.valueOf(location.getId()));
			if (gallery != null && gallery.getImages() != null && !gallery.getImages().isEmpty()) {
				gallery.setImages(Arrays.asList(gallery.getImages().get(0)));
				location.setGallery(gallery);
			}
		});
		return locations;
	}

	@Override
	public List<Location> findAll() {
		return repo.findAll();
	}

}
