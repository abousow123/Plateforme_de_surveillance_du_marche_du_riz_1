package org.sid.repository;

import org.sid.entity.UsineTransformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsineTransformationRepository extends JpaRepository<UsineTransformation, Long>{
	
	@Query("select usine from UsineTransformation usine where usine.nomUsine like :x ")
	public Page<UsineTransformation> chercher(@Param("x")String nom, Pageable pageable) ;
}
