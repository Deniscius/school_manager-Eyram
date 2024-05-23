package org.example.schoolmanager.models;

import org.example.schoolmanager.dbconfig.IDBConfig;
import org.example.schoolmanager.interfaces.StudentInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Student implements StudentInterface {
    private int id;
    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private String placeOfBirthday;
    private int state;
    private Connection connection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public java.sql.Date getDateOfBirth() {
        return (java.sql.Date) dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirthday() {
        return placeOfBirthday;
    }

    public void setPlaceOfBirthday(String placeOfBirthday) {
        this.placeOfBirthday = placeOfBirthday;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Student student) throws SQLException {
        connection = IDBConfig.getConnection();
        if (connection != null) {
            String req = "(INSERT INTO student(firstname, lastname, dateOfBirth, placeOfBirth, ) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement =
                    this.connection.prepareStatement(req);

            preparedStatement.setString(1, student.getFirstname());
            preparedStatement.setString(2, student.getLastname());
            preparedStatement.setDate(3, student.getDateOfBirth());
            preparedStatement.setString(4, student.getPlaceOfBirthday());

            int row = preparedStatement.executeUpdate();

            preparedStatement.close();
            this.connection.close();


        }
    }
}




