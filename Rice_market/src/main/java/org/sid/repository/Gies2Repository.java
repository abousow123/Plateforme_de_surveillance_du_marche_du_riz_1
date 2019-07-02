package org.sid.repository;

import org.sid.entity.Gie2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Gies2Repository extends JpaRepository<Gie2, Long> {
	@Query("select gie from Gie2 gie where gie.nomGie like :x ")
	public Page<Gie2> chercher(@Param("x")String nom, Pageable pageable) ;


}
