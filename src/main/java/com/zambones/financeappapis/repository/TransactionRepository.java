package com.zambones.financeappapis.repository;

import com.zambones.financeappapis.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, Long> {
}
