package com.zambones.financeappapis.controller;

import com.zambones.financeappapis.model.Statement;
import com.zambones.financeappapis.service.StatementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statements")
public class StatementController {

    private final StatementService statementService;

    @Autowired
    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }

    @Operation(summary = "Get all statements", responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operation")
    })
    @GetMapping
    public List<Statement> getAllStatements() {
        return statementService.getAllStatements();
    }

    @Operation(summary = "Get statement by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operations"),
            @ApiResponse(responseCode = "404", description = "Statement not found")
    })
    @GetMapping("/{id}")
    public Statement getStatementById(@PathVariable Long id) {
        return statementService.getStatementById(id);
    }
}
