package org.sid.repository;

import org.sid.entity.Compte;
import org.sid.entity.FactureImport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FactureImportRepository extends JpaRepository<FactureImport, Long> {
//	@Query("select f from FactureImport f where f.stockImportation.importateurs.utilisateur.nom like :x ")
//	public Page<FactureImport> chercher(@Param("x")String nom, Pageable pageable) ;

}
