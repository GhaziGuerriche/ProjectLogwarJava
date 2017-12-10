/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.entities.Account;
import com.bank.entities.Transaction;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ghazi.guerriche
 */
public interface TransactionService {

    List<Transaction> getAllTransaction();

    Transaction getTransaction(Long id);

    Transaction createTransaction(Transaction account);

    Transaction updateTransaction(Transaction account);

    Boolean isValidTransaction(Long AccountNumber, float withdrawal);

    void deleteTransaction(Long id);

    List<Transaction> findTransactionByAccountAndDate(Account account, Date starDate, Date endDate);
    List<Transaction> findTransactionByAccount(Account account);

}
