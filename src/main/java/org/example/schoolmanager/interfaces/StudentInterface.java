package org.example.schoolmanager.interfaces;

import org.example.schoolmanager.models.Student;

import java.sql.SQLException;

public interface StudentInterface {
    void create(Student student) throws SQLException;


}
