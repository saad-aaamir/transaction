package org.rak.microservicesassessment.exception;

/**
 * @author Usman
 * @created 1/23/2024 - 12:26 PM
 * @project Microservices-assessment
 */
public class ApplicationException extends RuntimeException{

	String code;

	public ApplicationException(String code, String message) {
		this(code, message, null);
	}

	public ApplicationException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
}
