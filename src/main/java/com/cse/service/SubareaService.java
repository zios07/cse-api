package com.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subarea findOne(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subarea> findAll() {
		return repo.findAll();
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		// TODO Auto-generated method stub

	}

}
