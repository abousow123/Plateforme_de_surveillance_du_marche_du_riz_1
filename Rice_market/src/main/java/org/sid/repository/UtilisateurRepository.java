package org.sid.repository;

import org.sid.entity.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	@Query("select u from Utilisateur u where u.nom like :x ")
	public Page<Utilisateur> chercher(@Param("x")String nom, Pageable pageable) ;


}
