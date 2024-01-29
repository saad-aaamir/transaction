package org.rak.transaction.unit.fee;

import org.rak.transaction.interfaces.Mapper;

import java.util.UUID;

@org.rak.transaction.annotation.Mapper
public class FeeMapperImpl implements Mapper<FeeDto, Fee> {
	@Override
	public FeeDto toDto(Fee entity) {
		return FeeDto.builder()
	    		.uuid(entity.getUuid())
	    		.type(entity.getType())
				.subType(entity.getSubType())
				.description(entity.getDescription())
				.amount(entity.getAmount())
	    		.build();

	}

	@Override
	public Fee toEntity(FeeDto dto) {
		return Fee.builder()
	    		.uuid(UUID.randomUUID().toString())
				.uuid(dto.getUuid())
				.type(dto.getType())
				.subType(dto.getSubType())
				.description(dto.getDescription())
				.amount(dto.getAmount())
	    		.build();

	}
}
