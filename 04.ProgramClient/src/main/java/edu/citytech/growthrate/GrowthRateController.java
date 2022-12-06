package edu.citytech.growthrate;


import edu.citytech.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Formatter;
import java.util.ResourceBundle;

public class GrowthRateController extends MainController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label lblRate;

    @FXML
    private TextField txtYears;

    @FXML
    private TextField txtBegin;

    @FXML
    private TextField txtEnd;

    @FXML
    private TextField txtTotal;

    @FXML
    void Calculate(ActionEvent event) {


        var years = Double.parseDouble(txtYears.getText());
        var beginingValue = Double.parseDouble(txtBegin.getText());
        var endingValue = Double.parseDouble(txtEnd.getText());
        var total = Double.parseDouble(txtTotal.getText());

        Formatter formatter = new Formatter();
        double x = ((endingValue + total) / beginingValue);
        double y = (1 / years);
        double x1 = Math.pow(x , y);
        double cagr = (x1 - 1) * 100;
        double roundOff = (double) Math.round(cagr * 100) / 100;
        String result =  String.format("%.2f",(roundOff / 100) * 100);


        lblRate.setText("Your rate of return is " + result + "%" );



    }

}