package org.sid.repository;

import org.sid.entity.Compte;
import org.sid.entity.Distributeurs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistributeurRepository extends JpaRepository<Distributeurs, Long>{

	@Query("select d from Distributeurs d where d.ncCommercant like :x ")
	public Page<Compte> chercher(@Param("x")String nom, Pageable pageable) ;
}
