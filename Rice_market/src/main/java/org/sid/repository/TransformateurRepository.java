package org.sid.repository;

import org.sid.entity.Transformateurs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransformateurRepository extends JpaRepository<Transformateurs, Long> {
	@Query("select trans from Transformateurs trans where trans.nom like :x ")
	public Page<Transformateurs> chercher(@Param("x")String nom, Pageable pageable) ;
}
