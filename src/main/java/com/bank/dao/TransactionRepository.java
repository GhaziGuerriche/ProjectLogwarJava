/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dao;
import com.bank.entities.Account;
import com.bank.entities.Transaction;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ghazi.guerriche
 */
public interface TransactionRepository extends CrudRepository <Transaction, Long> {
       @Query("SELECT p FROM Transaction p WHERE p.account = :account and p.date >= :starDate and p.date<= :endDate")
    List<Transaction> findTransactionByAccountAndDate(@Param("account") Account account,@Param("starDate")Date starDate,@Param("endDate") Date endDate);
       @Query("SELECT p FROM Transaction p WHERE p.account = :account")
    List<Transaction> findTransactionByAccount(@Param("account") Account account);

}
