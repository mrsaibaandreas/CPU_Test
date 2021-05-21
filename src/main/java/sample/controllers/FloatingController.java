package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.ACTIVE;
import sample.fixed_point.bench.cpu.CPUFloatingPoint;
import sample.fixed_point.testbench.TestCPUFloatingPoint;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FloatingController  {


    @FXML
     TableView table;
    @FXML
    private TableView d;

    @FXML
    private TableColumn operator;

    @FXML
    private TableColumn time;

    @FXML
    private TableColumn operator_d;

    @FXML
    private TableColumn time_d;





    @FXML
    public void backButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent NewCustomer = FXMLLoader.load(getClass().getResource("/running_program.fxml"));
        Scene NewCustomerScene = new Scene(NewCustomer);

        //Here we get the stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewCustomerScene);
        window.show();
    }

    @FXML
    public void compute(ActionEvent event) {

        TestCPUFloatingPoint.test('f');

        table.getColumns().clear();
        operator.setCellValueFactory(new PropertyValueFactory<>("operator"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        table.setItems(CPUFloatingPoint.data_float);
        System.out.println(CPUFloatingPoint.data_double);

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(time, operator);
        CPUFloatingPoint.data_float.removeAll();
        CPUFloatingPoint.data_float = null;
        CPUFloatingPoint.data_float = FXCollections.observableArrayList(
                new Model("Demo","Demo")
        );



    }
    @FXML
    public void compute_double(ActionEvent event)
    {
        TestCPUFloatingPoint.test('d');
        d   .getColumns().clear();
        operator_d.setCellValueFactory(new PropertyValueFactory<>("operator"));
        time_d.setCellValueFactory(new PropertyValueFactory<>("time"));
        d.setItems(CPUFloatingPoint.data_float);

        d.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        d.getColumns().addAll(time_d, operator_d);
        CPUFloatingPoint.data_float.removeAll();
        CPUFloatingPoint.data_float = null;
        CPUFloatingPoint.data_float = FXCollections.observableArrayList(
                new Model("Demo","Demo")
        );


    }
}
