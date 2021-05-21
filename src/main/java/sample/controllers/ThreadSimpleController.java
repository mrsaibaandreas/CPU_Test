package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.comparison.AlgorithmComparison;
import sample.comparison.Thread_performance;

import java.io.IOException;

public class ThreadSimpleController  {
    @FXML
    private Button back;

    @FXML
    Label out;
    @FXML
    Button start;

    @FXML
    TextField iterations, threads;

    @FXML
    public void backButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/running_program.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }


    public void startTest(ActionEvent actionEvent) {

        Thread_performance.test(iterations.getText(), threads.getText());
        for (String string :Thread_performance.s)
            out.setText(string + "\n");
    }
}
