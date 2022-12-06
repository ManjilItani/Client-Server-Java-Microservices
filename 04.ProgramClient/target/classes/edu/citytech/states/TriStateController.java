package edu.citytech.states;

import edu.citytech.MainController;
import edu.citytech.states.model.Property;
import edu.citytech.states.model.TriState;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TriStateController extends MainController implements Initializable {

    @FXML
    private PieChart pieTriState;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<Property> tvStateInfo;

    @FXML
    private Label txtPrompt;

    @FXML
    private Button btnRefresh;

    @FXML
    private Label lblTitle;

    @FXML
    private FlowPane fpStates;


    TriState[] gList = TriStateDataLayer.getData();
    List<String> selectedStates = new ArrayList<String>();


    Predicate<TriState> nyTriState = x -> false;

    int counter = 0;

    @FXML
    void onClick(ActionEvent event) {

        lblTitle.setText("TriState Income");


        counter++;


        Predicate<TriState> clickedStates = x -> false;

            for (String i:selectedStates ) {

                clickedStates = clickedStates.or(x->x.getState().equals(i));
            }

        this.refreshData(e -> true, clickedStates);
        this.pieTriState.getData().forEach(this::clickOnPie);


    }


    void refreshData(Predicate<Property> predicate, Predicate<TriState> states)
    {

        var list = Arrays.stream(gList).filter(states).toList();

        var isPopulated = pieTriState.getData().size() > 0;

        if(!isPopulated) {
            for (var property : list) {
                PieChart.Data slice = new PieChart.Data(property.getState(), property.getSumOfNetIncome());
                pieTriState.getData().add(slice);
            }
        }else {

            if (selectedStates.size() > 0 && counter >= 1) {
                pieTriState.getData().clear();

                for (var property : list) {
                    PieChart.Data slice = new PieChart.Data(property.getState(), property.getSumOfNetIncome());
                    pieTriState.getData().add(slice);
                }
                counter = 0;
            }
        }
            tvStateInfo.getItems().clear();

            var properties = TriStateDataLayer.getProperties();
            var listOfProperties = Arrays.stream(properties).filter(predicate)
                    .toList();
            ObservableList<Property> tableItems = tvStateInfo.getItems();
            tableItems.addAll(listOfProperties);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       if(selectedStates.size() == 0) {
           nyTriState = x -> x.getState().equals("CT")
                   || x.getState().equals("NY") || x.getState().equals("NJ");
           this.refreshData(e -> true, nyTriState);
       }


        this.pieTriState.getData().forEach(this::clickOnPie);

        Arrays.stream(gList).forEach(e -> {
            var checkBox = new CheckBox(e.getState());
            checkBox.setPrefSize(60,15);
            this.fpStates.getChildren().add(checkBox);


        });

        this.fpStates.getChildren().forEach(this::boxSelected);

    }


    private void boxSelected(Node node) {


        EventHandler<MouseEvent> eventHandler = evt ->{


            var source = evt.getSource();
            var stringSource =source.toString().split("'");


            if( selectedStates.contains(stringSource[1])){

                var position = selectedStates.contains(stringSource[1]);
                System.out.println(position);
               selectedStates.remove( selectedStates.indexOf(stringSource[1]));
            }
            else{
                selectedStates.add(stringSource[1]);
            }
            if (selectedStates.size() > 4)
            {
                txtPrompt.setText("Too many states selected, limit is 4");
                btnRefresh.setVisible(false);
            }
            else if( selectedStates.size() < 3){

                txtPrompt.setText("More than 2 states need to be selected");
                btnRefresh.setVisible(false);
            }
            else {
                txtPrompt.setText(null);
                btnRefresh.setVisible(true);
            }


        };
        node.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
    }


    void clickOnPie(PieChart.Data data){

        EventHandler<MouseEvent> eventHandler = evt -> {

            data.getName();
            System.out.println(data.getName());
            Predicate <Property> predicate = e -> e.getState().equals(data.getName());

               lblTitle.setText("");
               lblTitle.setText("TriState Income "+ data.getName());
                this.refreshData(predicate, nyTriState);


        };
        data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
    }




}
