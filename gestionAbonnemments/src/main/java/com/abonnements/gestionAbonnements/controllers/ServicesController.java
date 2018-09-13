package com.abonnements.gestionAbonnements.controllers;

import com.abonnements.gestionAbonnements.exceptions.ResourceNotFoundException;
import com.abonnements.gestionAbonnements.model.Services;
import com.abonnements.gestionAbonnements.model.Structures;
import com.abonnements.gestionAbonnements.repository.AbonnementsRepository;
import com.abonnements.gestionAbonnements.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class ServicesController {
	@Autowired
	ServicesRepository servicesRepository;

	@GetMapping
	public List<Services> getAllServices() {
	    return servicesRepository.findAll();
	}


	@PostMapping
	public Services createService(@Valid @RequestBody Services service) {
	    return servicesRepository.save(service);
	}


	@GetMapping("/{id}")
	public Services getServiceById(@PathVariable(value = "id") Long id_Service) {
	    return servicesRepository.findById(id_Service)
	            .orElseThrow(() -> new ResourceNotFoundException("Services", "id", id_Service));
	}


	@PutMapping
	public Services updateServices(@Valid @RequestBody Services service) {

	    return servicesRepository.save(service);
	}


	@DeleteMapping("/{id}")
	public Services deleteService(@PathVariable(value = "id") Long id_Service) {
		Services service=servicesRepository.getOne(id_Service);
		service.setEtat(false);
	    return servicesRepository.save(service);
	}
	
}
