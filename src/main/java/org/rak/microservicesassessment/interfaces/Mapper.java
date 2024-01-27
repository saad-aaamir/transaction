package org.rak.microservicesassessment.interfaces;

/**
 * @author Usman
 * @created 1/23/2024 - 12:49 AM
 * @project Microservices-assessment
 */
public interface Mapper<D, E> {

	D toDto(E entity);

	E toEntity(D dto);

}
