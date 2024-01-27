package org.rak.microservicesassessment.interfaces;

/**
 * @author Usman
 * @created 1/23/2024 - 12:47 AM
 * @project Microservices-assessment
 */
public interface BusinessService<D> {
	D getbyUuid(String uuid);
	D create(D dto);
	D update(D dto, String id);
	void delete(String Uuid);

}
