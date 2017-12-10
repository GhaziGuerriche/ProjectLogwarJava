/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.entities.Client;
import java.util.List;

/**
 *
 * @author ghazi.guerriche
 */
public interface ClientService {

    List<Client> getAllClient();

    Client getClient(Long id);

    Client createClient(Client client);

    Client updateClient(Client client);

    void deleteClient(Long id);
}
