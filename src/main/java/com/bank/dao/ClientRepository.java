/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dao;
import com.bank.entities.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ghazi.guerriche
 */
public interface ClientRepository extends CrudRepository <Client, Long> {
    
}
