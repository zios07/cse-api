package com.cse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cse.domain.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}
