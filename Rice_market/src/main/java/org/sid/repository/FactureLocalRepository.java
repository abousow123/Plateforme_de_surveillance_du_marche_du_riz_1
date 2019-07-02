package org.sid.repository;

import org.sid.entity.FactureLocal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureLocalRepository extends JpaRepository<FactureLocal, Long> {
//	@Query("select f from FactureImport f where f.stockImportation.importateurs.utilisateur.nom like :x ")
////	public Page<FactureImport> chercher(@Param("x")String nom, Pageable pageable) ;

}
