/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.dao.AccountRepository;
import com.bank.dao.TransactionRepository;
import com.bank.entities.Account;
import com.bank.entities.Transaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ghazi.guerriche
 */
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Account> getAllAccount() {
        List<Account> accounts = new ArrayList<Account>();
        Iterator<Account> iterator = accountRepository.findAll().iterator();
        while (iterator.hasNext()) {
            accounts.add(iterator.next());
        }
        return accounts;
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public boolean isValidAccount(Long id) {
        return accountRepository.findById(id).isPresent();
    }

    @Override
    public float getAmmountAccount(Account account) {
        List<Transaction> transaction = transactionRepository.findTransactionByAccount(account);
        float ammount = 0;
        for (Transaction t : transaction) {
            ammount += t.getDeposit();
            ammount -= t.getWithdrawal();
        }
        return ammount;
    }

}
