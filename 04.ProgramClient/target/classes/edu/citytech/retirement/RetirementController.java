package edu.citytech.retirement;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.MainController;
import edu.citytech.retirement.model.Retirement;
import edu.citytech.retirement.model.Year;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class RetirementController extends MainController implements Initializable {

    @FXML
    private TableView<Year> tvRetirement;

    @FXML
    private TableColumn<Year, Float> tcStartingBalance;

    @FXML
    private TableColumn<Year, Float> tcInterestEarned;

    @FXML
    private TableColumn<Year, Float> tcYearlyDeposit;

    @FXML
    private TableColumn<Year, Float>tcEndingBalance;

    @FXML
    private TextField txtYears;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    void changeYears(MouseEvent event) {

        ObservableList<Year> tableItems = tvRetirement.getItems();
        tableItems.clear();

        var year = txtYears.getText();
        var newYears = RetirementDataLayer.getRetirement(year).getYears();
        tableItems.addAll(newYears);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        var years= RetirementDataLayer.getRetirement().getYears();
        System.out.println(years);
        ObservableList<Year> tableItems = tvRetirement.getItems();
        tableItems.addAll(years);
//        tcStartingBalance.setCellFactory(e -> {
//            var cell = new CustomTableCell();
//            return cell;
//        });
//        tcInterestEarned.setCellFactory(e -> {
//            var cell = new CustomTableCell();
//            return cell;
//        });
//        tcYearlyDeposit.setCellFactory(e -> {
//            var cell = new CustomTableCell();
//            return cell;
//        });
//        tcEndingBalance.setCellFactory(e -> {
//            var cell = new CustomTableCell();
//            return cell;
//        });




    }


}
