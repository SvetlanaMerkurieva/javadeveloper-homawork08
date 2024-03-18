package org.example;

import org.example.config.DatabaseH2;
import org.example.data.daos.ClientDao;
import org.example.data.entities.Client;
import org.example.service.ClientService;
import org.example.service.impl.ClientServiceImpl;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection conn = DatabaseH2.getInstance().getConnection();
        ClientDao clientDao = new ClientDao(conn);
        ClientService clientService = new ClientServiceImpl(clientDao);
        List<Client> listClients = clientService.listAll();
        System.out.println("List of clients:");
        System.out.println(listClients.toString());
        String name = "OnlyNOW";
        long newClientId =  clientService.create(name);
        System.out.println("Create new client with name " + name + " and id = " + newClientId);
        long id = 4;
        String nameClient = clientService.getById(id);
        System.out.println("Name of client with id = " + id + " - " + nameClient);
        String newNameClient = "WOWdeveloper";
        clientService.setName(id, newNameClient);
        System.out.println("Now name of client with id = " + id + " - " + newNameClient);
        long idForDel = 2;
        clientService.deleteById(idForDel);
        System.out.println("Deleted client with id = " + idForDel);
        List<Client> newListClients = clientService.listAll();
        System.out.println("New list of clients:");
        System.out.println(newListClients.toString());
    }
}