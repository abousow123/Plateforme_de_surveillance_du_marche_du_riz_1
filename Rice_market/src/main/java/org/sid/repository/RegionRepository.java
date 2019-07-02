package org.sid.repository;

import org.sid.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegionRepository extends JpaRepository<Region, Long> {
	@Query("select r from Region r where r.nomRegion like :x ")
	public Page<Region> chercher(@Param("x")String nom, Pageable pageable) ;

}
