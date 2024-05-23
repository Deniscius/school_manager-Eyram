package org.example.schoolmanager.models;

import org.example.schoolmanager.dbconfig.IDBConfig;
import org.example.schoolmanager.interfaces.AuthInterce;
import org.example.schoolmanager.interfaces.UserInterface;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;

public class User {
    private int id;
    private String email;
    private String password;
    private Connection connection;

    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
