package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class FloatingController {
    
    @FXML
    private TableView f;
    @FXML
    private TableView d;
    
    @FXML
    public void LoadTable(ActionEvent event){
        
            
            
                f.getColumns().clear();
                f.getColumns().clear();
                name.setCellValueFactory(new PropertyValueFactory<>("name"));
                description.setCellValueFactory(new PropertyValueFactory<>("description"));
                supplier.setCellValueFactory(new PropertyValueFactory<>("user"));
                stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
                price.setCellValueFactory(new PropertyValueFactory<>("price"));
            
            
        }
    }
    



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
