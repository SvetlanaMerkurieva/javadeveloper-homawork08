package org.example;

import org.example.config.DatabaseH2;
import org.example.data.daos.ClientDao;

import java.sql.Connection;

public class MainStart {
    public static void main(String[] args) {
        Connection conn = DatabaseH2.getInstance().getConnection();
    }
}
