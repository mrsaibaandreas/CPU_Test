package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.fixed_point.testbench.TestCPUDigitsOfPi;
import sample.fixed_point.testbench.TestCPUFixedPoint;
import sample.fixed_point.testbench.TestCPUThreadedRoots;

import java.io.IOException;

public class RunningProgrammController {
    @FXML
    private Button pi;
    @FXML
    private Button tr;
    @FXML
    private Button tr_roots;
    @FXML
    private Button fx_point;
    @FXML
    private Button floating_point;

    @FXML
    public void PiAction(ActionEvent event) throws IOException {

        Parent NewCustomer = FXMLLoader.load(getClass().getResource("resources/Pi.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();

    }


    @FXML
    public void TrAction(ActionEvent event) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("resources/SimpleThread.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }


    @FXML
    public void Tr_Roots_Action(ActionEvent event) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("resources/Thread.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }


    @FXML
    public void FxAction(ActionEvent event) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("resources/Fixed.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }


    @FXML
    public void Fl_Action(ActionEvent event) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("resources/Floating.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }


}
