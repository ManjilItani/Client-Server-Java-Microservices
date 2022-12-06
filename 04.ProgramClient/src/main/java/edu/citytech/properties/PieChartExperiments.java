package edu.citytech.properties;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PieChartExperiments extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TriState Income");

        PieChart pieChart = new PieChart();

        var data = TriStateDataSource.getData();



        for (var realEstate : data){
            PieChart.Data slice = new PieChart.Data(realEstate.getState(),realEstate.getAmount());
            pieChart.getData().add(slice);
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(slice);

            for (var e: pieChartData) {
                var bind = Bindings.concat(e.getName(), " ", e.pieValueProperty()," ");
                e.nameProperty().bind(bind);
            }
        }


//        data.forEach(realEstate -> {
//
//            PieChart.Data slice = new PieChart.Data(realEstate.getState(),realEstate.getAmount());
//            pieChart.getData().add(slice);
//            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(slice);
//            pieChartData.forEach(e ->
//                    e.nameProperty().bind(
//                            Bindings.concat(
//                                    e.getName(), " ", e.pieValueProperty(), " "
//                            )
//                    )
//            );
//
//        });




//        PieChart.Data slice1 = new PieChart.Data("Desktop", 213);
//        PieChart.Data slice2 = new PieChart.Data("Phone"  , 67);
//        PieChart.Data slice3 = new PieChart.Data("Tablet" , 36);
//
//        pieChart.getData().add(slice1);
//        pieChart.getData().add(slice2);
//        pieChart.getData().add(slice3);

        VBox vbox = new VBox(pieChart);

        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(1200);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}