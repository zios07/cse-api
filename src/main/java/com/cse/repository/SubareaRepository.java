package com.cse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cse.domain.Subarea;

@Repository
public interface SubareaRepository extends JpaRepository<Subarea, Long> {

}
