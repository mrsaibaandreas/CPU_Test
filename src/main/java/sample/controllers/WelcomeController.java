package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class WelcomeController {

    @FXML private javafx.scene.control.Button button;

    @FXML
    public void handleClick(ActionEvent event) throws IOException {

        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/running_program.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();

    }

}
