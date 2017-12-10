/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.dao.TransactionRepository;
import com.bank.entities.Account;
import com.bank.entities.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ghazi.guerriche
 */
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountService accountService;

    @Override
    public List<Transaction> getAllTransaction() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        Iterator<Transaction> iterator = transactionRepository.findAll().iterator();
        while (iterator.hasNext()) {
            transactions.add(iterator.next());
        }
        return transactions;
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        transaction.setBalance(transaction.getDeposit() + transaction.getAccount().getBalance() - transaction.getWithdrawal());
        transaction.getAccount().setBalance(transaction.getBalance());
        accountService.updateAccount(transaction.getAccount());
        return transactionRepository.save(transaction);

    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Boolean isValidTransaction(Long AccountNumber, float withdrawal) {
        Account account = accountService.getAccount(AccountNumber);
        if (account.getBalance() >= withdrawal) {
            return true;
        }
        return false;
    }

    @Override
    public List<Transaction> findTransactionByAccountAndDate(Account account, Date starDate, Date endDate) {
        return transactionRepository.findTransactionByAccountAndDate(account, starDate, endDate);
    }

    @Override
    public List<Transaction> findTransactionByAccount(Account account) {
        return transactionRepository.findTransactionByAccount(account);
    }

}
