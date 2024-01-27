package org.rak.microservicesassessment.unit.student;

import org.apache.logging.log4j.util.Strings;
import org.rak.microservicesassessment.annotation.Validator;
import org.rak.microservicesassessment.interfaces.RequestValidator;

import java.util.Optional;

/**
 * @author Usman
 * @created 1/23/2024 - 1:26 AM
 * @project Microservices-assessment
 */
@Validator
public class StudentRequestValidatorImpl implements RequestValidator<StudentDto> {

	private final StudentRepository repository;

	public StudentRequestValidatorImpl(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean validateUniqueness(StudentDto dto) {
		return Optional.ofNullable(dto)
			.filter(dto1 -> Strings.isNotBlank(dto1.getStudentId()))
			.filter(dto1 -> Strings.isNotBlank(dto1.getStudentId()))
			.filter(dto1 ->  repository.existsByGradeAndStudentId(dto1.getGrade(), dto1.getStudentId()))
			.isPresent();
	}
}
