package com.cse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cse.domain.Image;

@Repository
public interface PropertyImageRepository extends JpaRepository<Image, Long> {

}
