package org.sid.repository;

import org.sid.entity.CommandeImport;
import org.sid.entity.Compte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommandeImportRepository extends JpaRepository<CommandeImport, Long> {
	@Query("select c from CommandeImport c where c.stockImportation.importateurs.utilisateur.nom like :x ")
	public Page<Compte> chercher(@Param("x")String nom, Pageable pageable) ;

}
