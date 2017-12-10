/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.entities.Account;
import java.util.List;

/**
 *
 * @author ghazi.guerriche
 */
public interface AccountService {

    List<Account> getAllAccount();

    Account getAccount(Long id);

    Account createAccount(Account account);

    Account updateAccount(Account account);

    void deleteAccount(Long id);

    boolean isValidAccount(Long id);
    float getAmmountAccount(Account account);
}
