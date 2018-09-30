package com.cse.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cse.domain.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>, JpaSpecificationExecutor<Property> {

	Page<Property> findByActiveDateGreaterThan(Date date, Pageable pageable);

	List<Property> findByMainTrue();

	List<Property> findByMainTrueAndActiveDateGreaterThan(Date date);

}
