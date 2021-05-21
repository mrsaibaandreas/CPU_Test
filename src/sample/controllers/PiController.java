package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.fixed_point.testbench.TestCPUDigitsOfPi;

import java.io.IOException;


public class PiController  {

    @FXML
    private TextField input;
    @FXML
    private Label piLabel;
    @FXML
    public void backButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("resources/running_program.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }
    @FXML
    public void execute(ActionEvent event)
    {
        TestCPUDigitsOfPi.test(Integer.parseInt(input.getText()));
        piLabel.setText("The total time is: " + TestCPUDigitsOfPi.time+ "\n The PiNumber looks like\n"+ TestCPUDigitsOfPi.result);

    }


}
