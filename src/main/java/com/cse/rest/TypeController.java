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

import com.cse.domain.Type;
import com.cse.service.api.ITypeService;
import com.cse.service.exception.NotFoundException;

@RestController
@RequestMapping("api/types")
public class TypeController {

	@Autowired
	private ITypeService service;

	@GetMapping
	public ResponseEntity<List<Type>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Type> findById(@PathVariable Long id) throws NotFoundException {
		return ResponseEntity.ok(service.findOne(id));
	}

	@PostMapping
	public ResponseEntity<Type> create(@RequestBody Type type) {
		return ResponseEntity.ok(service.save(type));
	}

	@PutMapping
	public ResponseEntity<Type> update(@RequestBody Type type) {
		return ResponseEntity.ok(service.save(type));
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) throws NotFoundException {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
