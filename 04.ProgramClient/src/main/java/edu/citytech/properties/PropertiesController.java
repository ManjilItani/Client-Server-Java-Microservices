package edu.citytech.properties;

import edu.citytech.MainController;
import edu.citytech.properties.model.Investment;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PropertiesController extends MainController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<Investment> tvProperties;

    @FXML
    private TableColumn<Investment, Integer> tcId;

    @FXML
    private TableColumn<Investment, Float> tcCost;

    @FXML
    private TableColumn<Investment, Float> tcGrossIncome;

    @FXML
    private TableColumn<Investment, Float> tcExpenses;

    @FXML
    private TableColumn<Investment, Float> tcNetIncome;

    @FXML
    private TableColumn<Investment, Integer> tcOccupancy;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        var investments = PropertiesDataLayer.getProperties().getInvestments();
        ObservableList<Investment> tableItems = tvProperties.getItems();
        tableItems.addAll(investments);

    }
}
