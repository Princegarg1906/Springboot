package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Details;
import com.example.demo.service.DetailsService;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private DetailsService detailsService;
	
	@GetMapping("/view/{id}")
	public ResponseEntity<Details> show(@PathVariable int id) {
		return detailsService.findId(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
	}

}
