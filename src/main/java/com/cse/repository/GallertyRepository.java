package com.cse.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cse.domain.Gallery;

@Repository
@Transactional
public interface GallertyRepository extends JpaRepository<Gallery, Long> {

	@Modifying
	@Query("update Gallery g set g.propertyId = ?2 where g.propertyId = ?1")
	int updatePropertyId(String uuid, String newProductId);

	Gallery findByPropertyId(String id);

}
