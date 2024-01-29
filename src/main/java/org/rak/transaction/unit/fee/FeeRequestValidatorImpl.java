package org.rak.transaction.unit.fee;

import org.apache.logging.log4j.util.Strings;
import org.rak.transaction.annotation.Validator;
import org.rak.transaction.interfaces.RequestValidator;

import java.util.Optional;

@Validator
public class FeeRequestValidatorImpl implements RequestValidator<FeeDto> {

	private final FeeRepository repository;

	public FeeRequestValidatorImpl(FeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean validateRequest(FeeDto dto) {
		return Optional.ofNullable(dto)
				.filter(dto1 -> Strings.isNotBlank(dto1.getType()))
				.filter(dto1 -> Strings.isNotBlank(dto1.getSubType()))
				.filter(dto1 -> FeeType.isValid(dto1.getType()))
				.filter(dto1 -> validateSubTypeBasedOnType(dto1.getType(), dto1.getSubType()))
				.filter(dto1 ->  !repository.existsByTypeAndSubType(dto1.getType(), dto1.getSubType()))
				.isPresent();
	}

	private boolean validateSubTypeBasedOnType(String type, String subType) {
		return true;
	}
}
