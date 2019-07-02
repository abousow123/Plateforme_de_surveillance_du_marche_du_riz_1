package org.sid.repository;

import org.sid.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Rolerepository extends JpaRepository<Role, Long > {
	@Query("select r from Role r where r.nomRole like :x ")
	public Page<Role> chercher(@Param("x")String nom, Pageable pageable) ;

}
