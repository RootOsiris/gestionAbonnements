package com.abonnements.gestionAbonnements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abonnements.gestionAbonnements.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	@Query("SELECT u FROM Users u WHERE u.login = :log and u.mdp = :pass and etat = 1")
	Users login(
			  @Param("log") String login, 
			  @Param("pass") String mdp			
			);

}
