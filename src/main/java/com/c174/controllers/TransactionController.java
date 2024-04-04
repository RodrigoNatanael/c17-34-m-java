package com.c174.controllers;

import com.c174.models.transaction.TransactionRequest;
import com.c174.models.transaction.TransactionResponse;
import com.c174.services.abstraccion.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable Long id){
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<List<TransactionResponse>> getTransactionsByProfile(@PathVariable Long id){
        return ResponseEntity.ok(transactionService.getTransactionsByProfile(id));
    }

    @PostMapping("/newTransaction")
    public ResponseEntity<TransactionResponse> saveTransaction(@RequestBody TransactionRequest transaction){
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id){
        return ResponseEntity.ok(transactionService.deleteTransaction(id));
    }
}
