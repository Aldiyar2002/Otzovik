package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB implements IDB{
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        String connectionUrl = "jdbc:postgresql://localhost:5432/review";
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "123");
            return con;
        } catch(Exception e){
            System.out.println(e);
            throw e;
        }
    }
}
