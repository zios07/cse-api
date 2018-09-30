package com.cse.service.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.cse.domain.Subarea;
import com.cse.service.exception.NotFoundException;

public interface ISubareaService {

	Subarea save(Subarea subarea);

	Subarea findOne(Long id) throws NotFoundException;

	Page<Subarea> findAll(PageRequest pageRequest);

	void delete(Long id) throws NotFoundException;

	List<Subarea> findAll();

}
