package com.cse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cse.domain.Subarea;
import com.cse.repository.SubareaRepository;
import com.cse.service.api.ISubareaService;
import com.cse.service.exception.NotFoundException;

@Service
public class SubareaService implements ISubareaService {

	@Autowired
	private SubareaRepository repo;

	@Override
	public Subarea save(Subarea subarea) {
		return repo.save(subarea);
	}

	@Override
	public Subarea findOne(Long id) throws NotFoundException {
		Optional<Subarea> optional = repo.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}


	@Override
	public void delete(Long id) throws NotFoundException {
		repo.deleteById(id);
	}

	@Override
	public Page<Subarea> findAll(PageRequest pageRequest) {
		return repo.findAll(pageRequest);
	}

	@Override
	public List<Subarea> findAll() {
		return repo.findAll();
	}

}
