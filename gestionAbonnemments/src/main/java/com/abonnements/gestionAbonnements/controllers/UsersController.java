package com.abonnements.gestionAbonnements.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abonnements.gestionAbonnements.exceptions.ResourceNotFoundException;
import com.abonnements.gestionAbonnements.model.Users;
import com.abonnements.gestionAbonnements.repository.UsersRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class UsersController {
	
	@Autowired
    UsersRepository usersRepository;

	@GetMapping
	public List<Users> getAllUsers() {		
	    return usersRepository.findAll();
	}
	
	@PostMapping
	public Users createUser(@Valid @RequestBody Users user) {
	    return usersRepository.save(user);
	}
	
	@PostMapping("/login")
	public Users login(@Valid @RequestBody Users user) {
		Users user2=usersRepository.login(user.getLogin(), user.getMdp()) ;
	    return usersRepository.save(user2);
	}


	@GetMapping("/{id}")
	public Users getUserById(@PathVariable(value = "id") Long id_User) {
	    return usersRepository.findById(id_User)
	            .orElseThrow(() -> new ResourceNotFoundException("Users", "id", id_User));
	}

	@PutMapping
	public Users updateUser(@Valid @RequestBody Users user) {

	    return usersRepository.save(user);
	}

	@DeleteMapping("/{id}")
	public Users deleteUser(@PathVariable(value = "id") Long id_User) {
	   Users user=usersRepository.getOne(id_User);
		user.setEtat(false);
	    return usersRepository.save(user);
	
	}

	
}
