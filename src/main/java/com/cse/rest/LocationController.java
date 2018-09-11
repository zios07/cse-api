package com.cse.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import com.cse.domain.Location;
import com.cse.service.api.ILocationService;
import com.cse.service.exception.NotFoundException;

@RestController
@RequestMapping("api/locations")
public class LocationController {

	@Autowired
	private ILocationService service;

	@GetMapping
	public ResponseEntity<Page<Location>> findAll(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int size) {
		return ResponseEntity.ok(service.findAll(PageRequest.of(page, size)));
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Location> findById(@PathVariable Long id) throws NotFoundException {
		return ResponseEntity.ok(service.findOne(id));
	}

	@PostMapping
	public ResponseEntity<Location> create(@RequestBody Location location) {
		return ResponseEntity.ok(service.save(location));
	}

	@PutMapping
	public ResponseEntity<Location> update(@RequestBody Location location) {
		return ResponseEntity.ok(service.save(location));
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) throws NotFoundException {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
