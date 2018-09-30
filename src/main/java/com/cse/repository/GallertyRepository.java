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
	@Query("update Gallery g set g.entityId = ?2 where g.entityId = ?1")
	int updateEntityId(String uuid, String newProductId);

	Gallery findByEntityId(String id);

}
