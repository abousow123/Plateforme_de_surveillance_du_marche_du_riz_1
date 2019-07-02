package org.sid.repository;


import org.sid.entity.Compte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompteRepository extends JpaRepository<Compte, Long > {
	@Query("select c from Compte c where c.login like :x ")
	public Page<Compte> chercher(@Param("x")String nom, Pageable pageable) ;
	
	@Query("select c from Compte c where c.login like :x and c.pwd like :y ")
	public Compte compteByusername(@Param("x")String login,@Param("y")String pwd) ;
}
