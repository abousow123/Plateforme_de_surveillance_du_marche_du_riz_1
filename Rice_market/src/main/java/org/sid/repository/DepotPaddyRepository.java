package org.sid.repository;

import org.sid.entity.Deposerpaddy;
import org.sid.entity.DeposerpaddyId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepotPaddyRepository extends JpaRepository<Deposerpaddy, DeposerpaddyId>{
	@Query("select d from Deposerpaddy d where d.producteurs.utilisateur.nom like :x ")
	public Page<Deposerpaddy> chercher(@Param("x")String nom, Pageable pageable) ;

}
