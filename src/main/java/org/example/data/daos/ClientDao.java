package org.example.data.daos;

import org.example.data.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    private static final String INSERT_CLIENT = "INSERT INTO client (id, name) VALUES (?, ?)";
    private static final String SELECT_LAST_CLIENT_ID = "SELECT MAX(id) AS id FROM client";
    private static final String SELECT_NAME_BY_ID = "SELECT name FROM client WHERE id = ?";
    private static final String UPDATE_NAME_BY_ID = "UPDATE client SET name = ? WHERE id = ?";
    private static final String DELETE_CLIENT = "UPDATE project SET client_id = null WHERE client_id = ?; DELETE FROM client WHERE id = ?";
    private static final String SELECT_ALL_CLIENTS = "SELECT * FROM client";
    private PreparedStatement insertSt;
    private PreparedStatement selectLastClientIdSt;
    private PreparedStatement selectNameSt;
    private PreparedStatement updateNameSt;
    private PreparedStatement deleteClientSt;
    private PreparedStatement selectAllClientsSt;
    public ClientDao (Connection conn) {
        try {
            this.insertSt = conn.prepareStatement(INSERT_CLIENT);
            this.selectLastClientIdSt = conn.prepareStatement(SELECT_LAST_CLIENT_ID);
            this.selectNameSt = conn.prepareStatement(SELECT_NAME_BY_ID);
            this.updateNameSt = conn.prepareStatement(UPDATE_NAME_BY_ID);
            this.deleteClientSt = conn.prepareStatement(DELETE_CLIENT);
            this.selectAllClientsSt = conn.prepareStatement(SELECT_ALL_CLIENTS);
        } catch (SQLException e) {
            System.out.println("Client service construction exception. Raeson: " + e.getMessage());
        }
    }
    public long saveClient (Client client) {
        try {
            this.insertSt.setLong(1, client.getId());
            this.insertSt.setString(2, client.getName());
            return this.insertSt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert client exception. Reason: " + e.getMessage());
        }
        return -1;
    }
    public int findLastClientId() {
        int id = 0;
        try (ResultSet rs = this.selectLastClientIdSt.executeQuery()) {
            while(rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Select id last client exception. Reason: " + e.getMessage());
        }
        return id;
    }
    public String findNameById (long id) {
        String name = "";
        try {
            this.selectNameSt.setLong(1, id);
            try (ResultSet rs = this.selectNameSt.executeQuery()) {
                while (rs.next()) {
                    name = rs.getString("name");
                }
            } catch (SQLException e) {
                System.out.println("Select name of client exception. Reason: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Select name of client exception. Reason: " + e.getMessage());
        }
        return name;
    }
    public void updateNameById(long id, String name) {
        try {
            this.updateNameSt.setString(1, name);
            this.updateNameSt.setLong(2, id);
            this.updateNameSt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update name of client exception. Reason: " + e.getMessage());
        }
    }
    public void deleteClient (long id) {
        try {
            this.deleteClientSt.setLong(1, id);
            this.deleteClientSt.setLong(2, id);
            this.deleteClientSt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete client exception. Reason: " + e.getMessage());
        }
    }
    public List<Client> findAllClient() {
        List<Client> clients = new ArrayList<>();
        try (ResultSet rs = this.selectAllClientsSt.executeQuery()) {
            while (rs.next()) {
                Client client = new Client(rs.getLong("id"), rs.getString("name"));
                clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Select ALL clients exception. Reason: " + e.getMessage());
        }
        return clients;
    }
}
