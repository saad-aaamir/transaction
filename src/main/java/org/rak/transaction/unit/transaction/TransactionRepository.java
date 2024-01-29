package org.rak.transaction.unit.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByStudentId(String studentId);

    Transaction findFirstByTransRefNum(String tranRefNum);


}
