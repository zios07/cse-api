package com.cse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cse.domain.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
