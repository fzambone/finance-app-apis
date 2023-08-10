package com.zambones.financeappapis.controller;

import com.zambones.financeappapis.model.Transaction;
import com.zambones.financeappapis.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(summary = "Get all transactions", responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operation")
    })
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @Operation(summary = "Get transaction by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
            @ApiResponse(responseCode = "404", description = "Transaction not found")
    })
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }
}
