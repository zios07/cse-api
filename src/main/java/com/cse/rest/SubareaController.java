package com.cse.rest;

import java.util.List;

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

import com.cse.domain.Subarea;
import com.cse.service.api.ISubareaService;
import com.cse.service.exception.NotFoundException;

@RestController
@RequestMapping("api/subareas")
public class SubareaController {

	@Autowired
	private ISubareaService service;

	@GetMapping
	public ResponseEntity<Page<Subarea>> findAll(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int size) {
		return ResponseEntity.ok(service.findAll(PageRequest.of(page, size)));
	}

	@GetMapping(value = "all")
	public ResponseEntity<List<Subarea>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Subarea> findById(@PathVariable Long id) throws NotFoundException {
		return ResponseEntity.ok(service.findOne(id));
	}

	@PostMapping
	public ResponseEntity<Subarea> create(@RequestBody Subarea subarea) {
		return ResponseEntity.ok(service.save(subarea));
	}

	@PutMapping
	public ResponseEntity<Subarea> update(@RequestBody Subarea subarea) {
		return ResponseEntity.ok(service.save(subarea));
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) throws NotFoundException {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
