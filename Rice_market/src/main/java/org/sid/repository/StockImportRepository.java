package org.sid.repository;

import org.sid.entity.StockImportation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockImportRepository extends JpaRepository<StockImportation, Long>{
	@Query("select stock from StockImportation stock where stock.departement.nomDepartement like :x ")
	public Page<StockImportation> chercher(@Param("x")String nom, Pageable pageable) ;

}
