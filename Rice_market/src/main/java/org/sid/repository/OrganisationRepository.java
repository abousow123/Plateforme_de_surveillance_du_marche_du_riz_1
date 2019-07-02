package org.sid.repository;

import org.sid.entity.OrganisationInterprofessionel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrganisationRepository extends JpaRepository<OrganisationInterprofessionel, Long> {
	@Query("select org from OrganisationInterprofessionel org where org.nomOrganisation like :x ")
	public Page<OrganisationInterprofessionel> chercher(@Param("x")String nom, Pageable pageable) ;


}
