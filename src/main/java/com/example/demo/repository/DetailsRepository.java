package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Details;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Integer> {
	
	@Query(value = "SELECT * FROM details WHERE first_name = ?1 and last_name=?2", nativeQuery = true)
    Optional<Details> findByName(String Fname ,String Lname);
	
}
