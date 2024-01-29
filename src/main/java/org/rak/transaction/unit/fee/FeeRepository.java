package org.rak.transaction.unit.fee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeeRepository extends JpaRepository<Fee, Long> {

	Optional<Fee> findByTypeAndSubType(String type, String subType);

	boolean existsByTypeAndSubType(String type, String subType);
}
