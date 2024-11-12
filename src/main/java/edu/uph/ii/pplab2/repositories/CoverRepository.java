package edu.uph.ii.pplab2.repositories;

import edu.uph.ii.pplab2.domain.CoverType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverRepository extends JpaRepository<CoverType, Long> {
}
