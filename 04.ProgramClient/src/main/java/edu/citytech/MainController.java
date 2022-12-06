package edu.citytech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLOutput;

public class MainController {
    @FXML
    protected AnchorPane anchorPane;

    @FXML
    void abcCounterMode(ActionEvent event) {
         selectMode("ABCView.fxml", "ABC or 123");

    }

    @FXML
    void tictactoeMode(ActionEvent event) {

        selectMode("TicTacToeView.fxml", "Tic Tac Toe game");
    }

    @FXML
    void growthRateMode(ActionEvent event) {
        selectMode("GrowthView.fxml", "Growth calculator");
    }

    @FXML
    void propertiesMode(ActionEvent event) {
        selectMode("PropertiesView.fxml", "Propeties");
    }

    @FXML
    void pieChartMode(ActionEvent event) {
        selectMode("TriStateIncomeView.fxml", "TriState data");
    }

    @FXML
    void retirementMode(ActionEvent event) {
        selectMode("RetirementView.fxml", "Retirement data");
    }
    public void selectMode(String fxml, String title){

        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
            var stage = (Stage) anchorPane.getScene().getWindow();
            stage.setTitle(title);
            stage.setScene( new Scene(root));
            stage.show();
        }
        catch (Exception e) {

            e.printStackTrace();
        }

    }

}
