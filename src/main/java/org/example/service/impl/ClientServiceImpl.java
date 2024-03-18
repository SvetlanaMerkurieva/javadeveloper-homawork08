package org.example.service.impl;


import org.example.data.daos.ClientDao;
import org.example.data.entities.Client;
import org.example.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
    @Override
    public long create(String name) {
        Client newClient = new Client(6, name);
        clientDao.saveClient(newClient);
        return clientDao.findLastClientId();
    }
    @Override
    public String getById(long id) {
        return clientDao.findNameById(id);
    }

    @Override
    public void setName(long id, String name) {
        clientDao.updateNameById(id, name);
    }
    @Override
    public void deleteById(long id) {
        clientDao.deleteClient(id);
    }
    @Override
    public List<Client> listAll() {
        return clientDao.findAllClient();
    }
}
