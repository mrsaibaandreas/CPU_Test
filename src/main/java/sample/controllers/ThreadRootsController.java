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
import sample.fixed_point.testbench.TestCPUThreadedRoots;


import java.io.IOException;

import static sample.fixed_point.testbench.TestCPUThreadedRoots.output;

public class ThreadRootsController {

    @FXML
    Label result;
    @FXML
    TextField nThreads;
    @FXML
    TextField wLoad;
    @FXML
    Button test;

    public void OnTestActivity(ActionEvent actionEvent) throws IOException{

        System.out.println(wLoad.getText().toString());
        TestCPUThreadedRoots.test(Integer.parseInt(nThreads.getText().toString()),
                Integer.parseInt(wLoad.getText().toString()));

        result.setWrapText(true);
        result.setText(output.toString());
    }



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


}
