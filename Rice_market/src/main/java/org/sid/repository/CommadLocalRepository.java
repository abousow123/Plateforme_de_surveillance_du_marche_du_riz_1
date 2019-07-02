package org.sid.repository;

import java.util.ArrayList;

import org.sid.entity.CommandeLocal;
import org.sid.entity.Compte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommadLocalRepository extends JpaRepository<CommandeLocal, Long> {
//	@Query("select c from CommandeImport c where c.stockImportation.importateurs.utilisateur.nom like :x ")
//	public Page<Compte> chercher(@Param("x")String nom, Pageable pageable) ;
	@Query("select c from CommandeLocal c where c.statut=1 and c.stockLocal.usineTransformation.idUsine = :x")
	public ArrayList<CommandeLocal> commandsatisfaite(@Param("x")Long idUusine) ;
	
	@Query("select c from CommandeLocal c where c.statut=0 and c.stockLocal.usineTransformation.idUsine = :x ")
	public ArrayList<CommandeLocal> commandnonsatisfaite(@Param("x")Long idUusine) ;


}
