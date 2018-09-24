package com.cse.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cse.domain.Property;
import com.cse.domain.dto.PropertySearchDto;
import com.cse.service.api.IPropertyService;
import com.cse.service.exception.NotFoundException;

@RestController
@RequestMapping("api/properties")
public class PropertyController {

	@Autowired
	private IPropertyService service;

	@GetMapping
	public ResponseEntity<Page<Property>> findAllProperties(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int size) {
		return ResponseEntity.ok(service.findAll(PageRequest.of(page, size)));
	}

	@GetMapping(value = "developments/all")
	public ResponseEntity<Page<Property>> findAllDevelopments(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int size) {
		return ResponseEntity.ok(service.findAllDevelopments(PageRequest.of(page, size)));
	}
	
	@GetMapping(value = "main")
	public ResponseEntity<List<Property>> loadMainProperties() {
		return ResponseEntity.ok(service.loadMainProperties());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Property> findById(@PathVariable Long id) throws NotFoundException {
		return ResponseEntity.ok(service.findOne(id));
	}
	
	@PostMapping(value = "photo-upload")
	public ResponseEntity<?> uploadProductPhotos(@RequestParam("photos") MultipartFile[] photos,
			@RequestParam("uuid") String uuid) throws IOException {
		service.savePropertyPhotos(photos, uuid);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}


	@PostMapping
	public ResponseEntity<Property> create(@RequestBody Property property) {
		return ResponseEntity.ok(service.save(property));
	}

	@PostMapping(value = "search")
	public ResponseEntity<Page<Property>> search(@RequestBody PropertySearchDto property, @RequestParam int page,
			@RequestParam int size) {
		return ResponseEntity.ok(service.search(property, page, size));
	}

	@PutMapping
	public ResponseEntity<Property> update(@RequestBody Property property) {
		return ResponseEntity.ok(service.save(property));
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) throws NotFoundException {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
