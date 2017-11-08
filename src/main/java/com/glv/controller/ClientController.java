/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glv.Model.Client;
import com.glv.service.ClientService;
import com.glv.service.ClientServiceImpl;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private List<Client> clients = new ArrayList<>();
    @Autowired
    private ClientService clientService;

    @RequestMapping("clientlist.json")
    public @ResponseBody
    List<Client> getClientsList() {
        System.out.println("  " + clients.size());
        if (clients.isEmpty()) {
            long id = 1;
        clients=clientService.findAll();
            System.out.println(" n'est pas vide " + clients.size());
        } else {
            System.out.println("est vide " + clients.size());
        }

        return clients;
    }

    @RequestMapping("/layout")
    public String getTrainPartialPage(ModelMap modelMap) {
        return "clients/layout";
    }
}
