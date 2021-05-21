package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.fixed_point.bench.cpu.CPUFixedPoint;
import sample.fixed_point.bench.cpu.CPUFloatingPoint;
import sample.fixed_point.testbench.TestCPUDigitsOfPi;
import sample.fixed_point.testbench.TestCPUFixedPoint;
import sample.fixed_point.testbench.TestCPUThreadedRoots;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RunAllController implements Initializable {

    @FXML
    private Label fixed;

    @FXML
    private Label floating;

    @FXML
    private Label pi;

    @FXML
    private Label threads;

    @FXML
    private Label roots;

    @FXML
    private Label total;

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
        TestCPUDigitsOfPi.test(10000);
      //  TestCPUThreadedRoots.test();
        fixed.setText(""+TestCPUFixedPoint._time);
        pi.setText(""+TestCPUDigitsOfPi.time);
       // roots.setText(""+);
    }
}
