package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class RunningProgrammController {


    @FXML
    public void PiAction(ActionEvent event) throws IOException {

        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/Pi.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();

    }


    @FXML
    public void TrAction(ActionEvent event) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/SimpleThread.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }


    @FXML
    public void Tr_Roots_Action(ActionEvent event) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/Thread.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }


    @FXML
    public void FxAction(ActionEvent event) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/Fixed.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }


    @FXML
    public void Fl_Action(ActionEvent event) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/Floating.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    @FXML
    public void runAll(ActionEvent event) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/run_all.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }
}
