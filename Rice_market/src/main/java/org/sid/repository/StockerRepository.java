package org.sid.repository;

import org.sid.entity.Stocke;
import org.sid.entity.StockeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockerRepository extends JpaRepository<Stocke, StockeId> {

}
