package com.abonnements.gestionAbonnements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abonnements.gestionAbonnements.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	
}
