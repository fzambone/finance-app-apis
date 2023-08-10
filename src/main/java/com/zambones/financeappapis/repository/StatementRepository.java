package com.zambones.financeappapis.repository;

import com.zambones.financeappapis.model.Statement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatementRepository extends MongoRepository<Statement, Long> {
}