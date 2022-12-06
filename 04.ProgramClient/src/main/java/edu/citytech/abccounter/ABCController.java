package edu.citytech.abccounter;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.MainController;
import edu.citytech.abccounter.model.Mode;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

public class ABCController extends MainController implements Initializable {

    @FXML
    private GridPane gridABC;
    @FXML
    private Label lblA;
    @FXML
    private Label lblB;

    @FXML
    private Label lblC;

    @FXML
    private ToggleGroup tgMode;

    @FXML
    private ComboBox<Mode> cbHighlight;

    @FXML
    void highlightAction(ActionEvent event) {

        var selectedModel = cbHighlight.getSelectionModel() ;
        var current = selectedModel.getSelectedItem();


        var buttons = gridABC.getChildren().stream().map(e -> (Button)e).toList();

        for (Button b : buttons) {
            b.getStyleClass().removeAll("highlight");
        }

        if (current.getMode().equals("v")) {
            for (Button b : buttons) {
                if (ABCService.isVowel(b.getText()))
                    b.getStyleClass().add("highlight");
            }
        }

        if (current.getMode().equals("c")) {
            for (Button b : buttons) {
                if (ABCService.isConsonant(b.getText()))
                    b.getStyleClass().add("highlight");
            }
        }

        if (current.getMode().equals("e")) {
            for (Button b : buttons) {
                if (ABCService.isEven(b.getText()))
                    b.getStyleClass().add("highlight");

            }
        }
        if (current.getMode().equals("o")) {
            for (Button b : buttons) {
                if (ABCService.isOdd(b.getText()))
                    b.getStyleClass().add("highlight");

            }
        }
        if (current.getMode().equals("6")) {
            for (Button b : buttons) {
                if (ABCService.isEvery6(b.getText()))
                    b.getStyleClass().add("highlight");

            }
        }
        if (current.getMode().equals("4Or9")) {
            for (Button b : buttons) {
                if (ABCService.has4Or9(b.getText()))
                    b.getStyleClass().add("highlight");

            }
        }

        if (current.getMode().equals("n")) {
            for (Button b : buttons) {
                b.getStyleClass().removeAll("highlight");
            }
        }



    }

    @FXML
    void selectorMode(ActionEvent event) {

        Node node = (Node)event.getSource();

        loadABCOptions();

        if (node.getUserData().toString().equals("Z"))
        {
            loadABCOptions(node);
            lblA.setText("C");
            lblB.setText("B");
            lblC.setText("A");
            alphabets(true);
        }
        else if (node.getUserData().toString().equals("A"))
        {
            loadABCOptions(node);
            lblA.setText("A");
            lblB.setText("B");
            lblC.setText("C");
            alphabets(false);
        }
        else if (node.getUserData().toString().equals("1"))
        {
            loadABCOptions(node);
            lblA.setText("1");
            lblB.setText("2");
            lblC.setText("3");
            numbers(false);
        }
        else if(node.getUserData().toString().equals("3"))
        {
            loadABCOptions(node);
            lblA.setText("3");
            lblB.setText("2");
            lblC.setText("1");
            numbers(true);
        }
        else if(node.getUserData().toString().equals("5"))
        {
            loadABCOptions(node);
            lblA.setText("1");
            lblB.setText("2");
            lblC.setText("3");
            numbers5(false);
        }
        else if(node.getUserData().toString().equals("15"))
        {
            loadABCOptions(node);
            lblA.setText("3");
            lblB.setText("2");
            lblC.setText("1");
            numbers5(true);
        }




    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        alphabets(false);
        loadABCOptions( );
    }

    private void loadABCOptions(){
        var list = new ArrayList<Mode>();

           list.add(new Mode("n", "None"));
           list.add(new Mode("v", "Vowel"));
           list.add(new Mode("c", "Consonant"));

        var abcList = FXCollections.observableArrayList(list);

        var stage = super.anchorPane.getScene();

        cbHighlight.setItems(abcList);

    }
    private void loadABCOptions(Node node){
        var list = new ArrayList<Mode>();

        if(node.getUserData().toString().equals("1") || node.getUserData().toString().equals("3")
        || node.getUserData().toString().equals("5") || node.getUserData().toString().equals("15"))
        {
            list.add(new Mode("n", "None"));
            list.add(new Mode("e", "Even numbers"));
            list.add(new Mode("o", "Odd numbers"));
            list.add(new Mode("6", "Every 6 numbers"));
            list.add(new Mode("4Or9", "Contains #4 or 9"));
        }
        if(node.getUserData().toString().equals("A") || node.getUserData().toString().equals("Z") )
        {
            list.add(new Mode("n", "None"));
            list.add(new Mode("v", "Vowel"));
            list.add(new Mode("c", "Consonant"));
        }


        var abcList = FXCollections.observableArrayList(list);

        cbHighlight.setItems(abcList);

    }


    //Present the alphabets and its reverse
    public void alphabets(boolean reverse) {

        String sURL = "http://localhost:9615/alphabets/abc";
        var abc = JSONGet.submitGet(sURL, String[].class);

        if (reverse){

            Arrays.sort(abc, Collections.reverseOrder());

        }
        System.out.println(Arrays.toString(abc));

        gridABC.getChildren().clear();

        int column = 0, row = 0;

        for (var x: abc) {

            Button btn = new Button(x);
            btn.getStyleClass().add("abc");
            gridABC.add(btn,column++,row);

            if (column > 3)
            {
                row ++;
                column = 0;
            }

        }
    }


    //Present numbers and its reverse
    public void numbers(boolean reverse)
    {


        String sURL = "http://localhost:9615/numbers/123";
        var $123 = JSONGet.submitGet(sURL, Integer[].class);

        System.out.println(Arrays.toString($123));

        if (reverse)
        {
            Arrays.sort($123, Collections.reverseOrder());
        }

        gridABC.getChildren().clear();

        System.out.println(Arrays.toString($123));

        int column = 0, row = 0;

        for (var x: $123) {

            Button btn = new Button(x + "");
            btn.getStyleClass().add("numbers");
            gridABC.add(btn,column++,row);

            if (column > 7)
            {
                row ++;
                column = 0;
            }

        }
    }

    private int[] reverse_it(int[] a, int n) {

        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j --;
        }

        return b;
    }

    public void numbers5(boolean reverse) {


        String sURL = "http://localhost:9615/numbers/123";
        var $5 = JSONGet.submitGet(sURL, Integer[].class);

        System.out.println(Arrays.toString($5));

        if (reverse) {
            Arrays.sort($5, Collections.reverseOrder());
        }

        gridABC.getChildren().clear();

        System.out.println(Arrays.toString($5));

        int column = 0, row = 0;

        for (var x : $5) {

            Button btn = new Button(x*5 + "");
            btn.getStyleClass().add("numbers");
            gridABC.add(btn, column++, row);

            if (column > 7) {
                row++;
                column = 0;
            }

        }
    }
}
