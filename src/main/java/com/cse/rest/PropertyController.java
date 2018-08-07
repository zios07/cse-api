package com.cse.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cse.domain.Property;
import com.cse.service.api.IPropertyService;
import com.cse.service.exception.NotFoundException;

@RestController
@RequestMapping("api/properties")
public class PropertyController {

	@Autowired
	private IPropertyService service;

	@GetMapping
	public ResponseEntity<List<Property>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Property> findById(@PathVariable Long id) throws NotFoundException {
		return ResponseEntity.ok(service.findOne(id));
	}

	@PostMapping
	public ResponseEntity<Property> create(@RequestBody Property property) {
		return ResponseEntity.ok(service.save(property));
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
