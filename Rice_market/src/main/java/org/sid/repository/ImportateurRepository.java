package org.sid.repository;

import org.sid.entity.Compte;
import org.sid.entity.Importateurs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImportateurRepository extends JpaRepository<Importateurs, Long>{
	
	@Query("select import from Importateurs import where import.ncImport like :x ")
	public Page<Compte> chercher(@Param("x")String nom, Pageable pageable) ;

}
