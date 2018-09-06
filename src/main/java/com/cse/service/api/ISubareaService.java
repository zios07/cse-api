package com.cse.service.api;

import java.util.List;

import com.cse.domain.Subarea;
import com.cse.service.exception.NotFoundException;

public interface ISubareaService {

	Subarea save(Subarea subarea);

	Subarea findOne(Long id) throws NotFoundException;

	List<Subarea> findAll();

	void delete(Long id) throws NotFoundException;

}
