package edu.citytech.tictactoe;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.MainController;
import edu.citytech.tictactoe.model.Winner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TicTacToeController extends MainController implements Initializable {

    @FXML
    private FlowPane fpGames;

    @FXML
    private Label lblURL;


    @FXML
    private Label lblStatus;

    @FXML
    private Button btnReset;

    private boolean isX = true;

    final String TEMPLATE_URL = "http://localhost:9615/game/tictactoe?moves=";
    @FXML
    void gameMoveClick(MouseEvent event) {

        Object object = event.getSource();
        Label label =  (Label)object;

        lblStatus.setText("");
        if(!label.getText().equals("N"))
        {
            lblStatus.setText("Invalid move, too late to change!! ;)");
            return;
        }

        String currentMove = isX ? "X" : "O";

        label.setText(currentMove);
        isX = !isX;

        var moves = Arrays.stream(labels)
                .map(Label::getText).collect(Collectors.joining());

        var newUrl = TEMPLATE_URL + moves;
        lblURL.setText(newUrl);

        Winner retrieve = JSONGet.submitGet(newUrl, Winner.class);

        boolean winner = retrieve.isWinner();
        int[] wPosition = retrieve.getPosition();

        if(winner)
        {
            Arrays.stream(wPosition)
                            .forEach(e -> {
                                labels[e].getStyleClass().add("winner");
        });
            lblStatus.setText("The winning positions are " + wPosition[0] + ", " + wPosition[1] + " and " + wPosition[2]);

        }







    }

    private Label[]  labels = new Label[9];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        f_initialize();
    }

    public void p_initialize() {

        var children = fpGames.getChildren();

        int count = 0;
        for (Node node: children) {
            Label label = (Label)node;
            labels[count++] = label;
            System.out.println(label);

        }
    }

    public void f_initialize() {

        labels = fpGames.getChildren().stream()
                .map(e -> (Label)e)
                .toArray(Label[]::new);

        var stage = super.anchorPane.getScene();

    }


    @FXML
    void reset(ActionEvent event) {

        this.isX = true;

        for (Label label:labels) {
            label.setText("N");
            label.getStyleClass().remove("winner");

        }



    }


}
