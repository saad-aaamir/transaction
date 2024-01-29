package org.rak.transaction.unit.fee;

import org.rak.transaction.exception.ApplicationException;
import org.rak.transaction.interfaces.BusinessService;
import org.rak.transaction.interfaces.Mapper;
import org.rak.transaction.interfaces.RequestValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeeServiceImpl implements BusinessService<FeeDto> {

	private RequestValidator<FeeDto> validator;
	private Mapper<FeeDto, Fee> mapper;
	private FeeRepository repository;

	public FeeServiceImpl(RequestValidator<FeeDto> validator, Mapper<FeeDto, Fee> mapper, FeeRepository repository) {
		this.validator = validator;
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public FeeDto getByUuid(String uuid) {
		return null;
	}

	@Override
	public FeeDto create(FeeDto dto){
		return Optional.ofNullable(dto)
			.filter(dto1 -> validator.validateRequest(dto1))
			.map(dto1 -> mapper.toEntity(dto1))
			.map(entity -> repository.save(entity) )
			.map(entity -> mapper.toDto(entity))
			.orElseThrow(() -> new ApplicationException("100-001", "Unable to create"));
	}

	@Override
	public FeeDto update(FeeDto dto, String id) {
		return null;
	}

	@Override
	public void delete(String uuid) {

	}

	public FeeDto getByTypeAndSubType(String type, String subType) {
		return repository.findByTypeAndSubType(type, subType)
				.map(entity -> mapper.toDto(entity))
				.orElseThrow(() -> new ApplicationException("", ""));
	}
}
