package org.example.schoolmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.example.schoolmanager.models.Student;

import java.sql.SQLException;
import java.time.LocalDate;

public class StudentController {
    @FXML
    private TextField classe;

    @FXML
    private DatePicker datePickerBirth;

    @FXML
    private TextField lieudenaissance;

    @FXML
    private TextField nomDeFamille;

    @FXML
    private TextField prenom;

    @FXML
    void submit() throws SQLException{
        String firstname = this.nomDeFamille.getText().trim();
        String lastname = this.prenom.getText().trim().trim();
        LocalDate dateOfBirth = this.datePickerBirth.getValue();
        String placeOfBirth = this.lieudenaissance.getText().trim();
        int classroom = Integer.parseInt(this.classe.getText().trim());


        Student student = new Student();

        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setClassroom(classroom);
        try {
            student.setDateOfBirth(dateOfBirth);
        }catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText("Date format non valide");
            alert.showAndWait();
            return;
        }
        student.setPlaceOfBirthday(placeOfBirth);
        student.setState(student.getState());

        student.create(student);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFO");
        alert.setContentText("Elève enregistré avec succès");
        alert.showAndWait();


    }

}