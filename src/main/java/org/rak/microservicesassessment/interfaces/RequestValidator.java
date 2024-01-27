package org.rak.microservicesassessment.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Usman
 * @created 1/23/2024 - 1:24 AM
 * @project Microservices-assessment
 */
public interface RequestValidator<D> {
	boolean validateUniqueness(D dto);
}
