/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.entities.Account;
import com.bank.entities.Transaction;
import com.bank.service.AccountService;
import com.bank.service.TransactionService;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ghazi.guerriche
 */
@RestController
@RequestMapping("/api")
public class TransactionController {
    
    @Autowired
    TransactionService transactionService;
    @Autowired
    AccountService accountService;
    @RequestMapping(value = "/transaction", method = RequestMethod.GET, produces = "application/json")
    public List<Transaction> getAllTransaction() {
        return transactionService.getAllTransaction();
    }

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET)
    public Transaction getTransaction(@PathVariable("id") Long id) {
        return transactionService.getTransaction(id);
    }

    @RequestMapping(value = "/transaction/create", method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON})
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
        
    }

    @RequestMapping(value = "/getTransactions/{account}/{starDate}/{endDate}", method = RequestMethod.GET)
    public List<Transaction> findTransactionByAccountAndDate(@PathVariable("account") Long accountId,@PathVariable("starDate")  @DateTimeFormat(pattern="yyyy-MM-dd")  Date starDate,@PathVariable("endDate")  @DateTimeFormat(pattern="yyyy-MM-dd")  Date endDate) {
        Account account = accountService.getAccount(accountId);
        //assign hour to 23 to get transaction of today
         endDate.setHours(24);
      return  transactionService.findTransactionByAccountAndDate(account, starDate, endDate);
    }
    @RequestMapping(value = "/checkTransaction/{accountNumber}/{withdrawal}", method = RequestMethod.GET)
    public boolean deleteTransaction(@PathVariable("accountNumber") Long accountNumber,@PathVariable("withdrawal")float withdrawal) {
       return transactionService.isValidTransaction(accountNumber, withdrawal);
    }
    
}
