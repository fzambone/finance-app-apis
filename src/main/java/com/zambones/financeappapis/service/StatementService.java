package com.zambones.financeappapis.service;

import com.zambones.financeappapis.model.Statement;
import com.zambones.financeappapis.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementService {

    private final StatementRepository statementRepository;

    @Autowired
    public StatementService(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }

    public List<Statement> getAllStatements() {
        return statementRepository.findAll();
    }

    public Statement getStatementById(Long id) {
        return statementRepository.findById(id).orElseThrow(() -> new StatementNotFoundException("Statement not found."));
    }
}

class StatementNotFoundException extends RuntimeException {
    public StatementNotFoundException(String message) {
        super(message);
    }
}