package org.rak.transaction.unit.transaction;

import org.rak.transaction.exception.ApplicationException;
import org.rak.transaction.interfaces.BusinessService;
import org.rak.transaction.interfaces.Mapper;
import org.rak.transaction.interfaces.RequestValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService implements BusinessService<TransactionDto> {

    private final RequestValidator<TransactionDto> validator;
    private final Mapper<TransactionDto, Transaction> mapper;
    private final TransactionRepository repository;


    public TransactionService(RequestValidator<TransactionDto> validator, Mapper<TransactionDto, Transaction> mapper, TransactionRepository repository) {
        this.validator = validator;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public TransactionDto getByUuid(String uuid) {
        return null;
    }

    @Override
    public TransactionDto create(TransactionDto dto) {
        return Optional.ofNullable(dto)
                .filter(validator::validateRequest)
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::toDto)
                .orElseThrow(() -> new ApplicationException("100-001", "Unable to create"));
    }

    @Override
    public TransactionDto update(TransactionDto dto, String id) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    public List<TransactionDto> getAllByStudentId(String studentId) {
        return repository.findAllByStudentId(studentId).stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
