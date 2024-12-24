package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Details;
import com.example.demo.repository.DetailsRepository;

@Service
public class DetailsService {
	
	@Autowired
	private DetailsRepository detailsRepository;
	
	public Details createDetails(Details details) {
        return detailsRepository.save(details);
    }
	
	public Optional<Details> find(String Fname,String Lname) {
		return detailsRepository.findByName(Fname,Lname);
	}
	
	public Optional<Details> findId(int Id) {
		return detailsRepository.findById(Id);
	}
	
}
