package org.rak.microservicesassessment.unit.student;

import org.rak.microservicesassessment.exception.ApplicationException;
import org.rak.microservicesassessment.interfaces.BusinessService;
import org.rak.microservicesassessment.interfaces.Mapper;
import org.rak.microservicesassessment.interfaces.RequestValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Usman
 * @created 1/23/2024 - 1:18 AM
 * @project Microservices-assessment
 */

@Service
public class ServiceImpl implements BusinessService<StudentDto> {

	private RequestValidator<StudentDto> validator;
	private Mapper<StudentDto, Student> mapper;
	private StudentRepository repository;

	public ServiceImpl(RequestValidator<StudentDto> validator, Mapper<StudentDto, Student> mapper, StudentRepository repository) {
		this.validator = validator;
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public StudentDto getbyUuid(String uuid) {
		return null;
	}

	@Override
	public StudentDto create(StudentDto dto){
		return Optional.ofNullable(dto)
			.filter(dto1 -> validator.validateUniqueness(dto1))
			.map(dto1 -> mapper.toEntity(dto1))
			.map(entity -> repository.save(entity) )
			.map(entity -> mapper.toDto(entity))
			.orElseThrow(() -> new ApplicationException("100-001", "Unable to create"));
	}

	@Override
	public StudentDto update(StudentDto dto, String id) {
		return null;
	}

	@Override
	public void delete(String Uuid) {

	}
}
