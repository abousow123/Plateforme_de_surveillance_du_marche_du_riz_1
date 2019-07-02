package org.sid.repository;



import org.sid.entity.AgentGouv;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AgentGouvRepository extends JpaRepository<AgentGouv, String>{

	
//	@Query("select ag from AgentGouv c where ag.idGouv like :x ")
//	public Page<AgentGouv> chercher(@Param("x")String nom,Pageable pageable) ;

}
