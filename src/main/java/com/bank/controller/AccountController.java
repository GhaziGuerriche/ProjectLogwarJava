/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.entities.Account;
import com.bank.service.AccountService;
import com.bank.service.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AccountController {
    
    @Autowired
    AccountService accountService;
    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "/account", method = RequestMethod.GET, produces = "application/json")
    public List<Account> getAllAccount() {
        return accountService.getAllAccount();
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable("id") Long id) {
        return accountService.getAccount(id);
    }

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
    public Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }

    @RequestMapping(value = "/deleteAccount/{id}", method = RequestMethod.GET)
    public void deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
    }

@RequestMapping(value = "/account/isValid/{accountNumber}", method = RequestMethod.GET)
    public boolean isValid(@PathVariable("accountNumber") Long accountNumber) {
       return accountService.isValidAccount(accountNumber);
    }
    public float getAmountByAccount(Long accountNumber)
    {
     Account account=   this.getAccount(accountNumber);
            return accountService.getAmmountAccount(account);
    }
}
