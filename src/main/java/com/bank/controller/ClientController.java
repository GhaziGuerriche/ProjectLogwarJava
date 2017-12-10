/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.entities.Client;
import com.bank.service.ClientService;
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
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/client", method = RequestMethod.GET, produces = "application/json")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public Client getClient(@PathVariable("id") Long id) {
        return clientService.getClient(id);
    }

    @RequestMapping(value = "/createClient", method = RequestMethod.POST)
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @RequestMapping(value = "/updateClient", method = RequestMethod.POST)
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @RequestMapping(value = "/deleteClient/{id}", method = RequestMethod.GET)
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
    }
}
