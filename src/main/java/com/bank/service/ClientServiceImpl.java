/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service;

import com.bank.dao.ClientRepository;
import com.bank.entities.Client;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ghazi.guerriche
 */
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClient() {
        List<Client> clients = new ArrayList<Client>();
        Iterator<Client> iterator = clientRepository.findAll().iterator();
        while (iterator.hasNext()) {
            clients.add(iterator.next());
        }
        return clients;
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
         clientRepository.deleteById(id);
    }

}
