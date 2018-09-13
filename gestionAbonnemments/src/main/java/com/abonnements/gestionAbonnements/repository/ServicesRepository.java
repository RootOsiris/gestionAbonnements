package com.abonnements.gestionAbonnements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abonnements.gestionAbonnements.model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long>{

	@Modifying
	@Query(value = "update services s set s.etat = ? where s.id_service = ?", 
	  nativeQuery = true)
	int deleteService(Long id_service);
	
}
