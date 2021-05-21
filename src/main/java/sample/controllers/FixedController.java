package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.fixed_point.testbench.TestCPUFixedPoint;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FixedController implements Initializable {
    @FXML
    private Label fixedLabel;


    @FXML
    private Button back;
    @FXML
    public void backButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/running_program.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TestCPUFixedPoint.test();
        fixedLabel.setText("The duration was of the test was:\n " + Double.valueOf(TestCPUFixedPoint._time) + "  Milli");
    }
}
