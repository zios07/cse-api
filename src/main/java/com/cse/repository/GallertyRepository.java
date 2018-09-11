package com.cse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cse.domain.Gallery;

@Repository
public interface GallertyRepository extends JpaRepository<Gallery, Long> {

}
