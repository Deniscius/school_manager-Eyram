package org.example.schoolmanager.models;

import org.example.schoolmanager.dbconfig.IDBConfig;
import org.example.schoolmanager.interfaces.StudentInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Student implements StudentInterface {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String placeOfBirthday;
    private int state = 0;
    private int classroom;

    public void setClassroom(int classroom) {this.classroom = classroom;}

    private Connection connection;

    public int getId() {
        return id;
    }

    public LocalDate getDateOfBirth() {return dateOfBirth;}

    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

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

    public int getClassroom() {return classroom;}

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
            String req = "INSERT INTO student(firstname, lastname, dateOfBirth, placeOfBirth, state ) VALUES (?, ?, ?, ?, ?);";

            PreparedStatement preparedStatement =
                    this.connection.prepareStatement(req);

            preparedStatement.setString(1, getFirstname());
            preparedStatement.setString(2, getLastname());
            preparedStatement.setDate(3, Date.valueOf(getDateOfBirth()));
            preparedStatement.setString(4, getPlaceOfBirthday());
            preparedStatement.setInt(5, getState());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            this.connection.close();


        }
    }
    private void dateOfBirth() {

    }
}




