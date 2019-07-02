package org.sid.repository;

import org.sid.entity.Compte;
import org.sid.entity.Producteurs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProducteurRepository extends JpaRepository<Producteurs, Long> {
	@Query("select prod from Producteurs prod where prod.idProd like :x ")
	public Page<Compte> chercher(@Param("x")String nom, Pageable pageable) ;


}
