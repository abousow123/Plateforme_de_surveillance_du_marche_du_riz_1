package org.sid.repository;

import org.sid.entity.StockLocal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockLocalRepository extends JpaRepository<StockLocal, Long> {
	@Query("select stock from StockLocal stock where stock.usineTransformation.departement.nomDepartement like :x ")
	public Page<StockLocal> chercher(@Param("x")String nom, Pageable pageable) ;
	
	
	
	@Query("select stock from StockLocal stock where stock.usineTransformation.departement.region.nomRegion like :x ")
	public Page<StockLocal> searchregion(@Param("x")String nom, Pageable pageable) ;
	
}

