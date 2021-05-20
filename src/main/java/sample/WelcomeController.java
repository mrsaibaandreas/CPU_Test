package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;

public class WelcomeController {

    @FXML private javafx.scene.control.Button button;


    @FXML
    public void handleClick(ActionEvent event) throws IOException {

        Stage intro = (Stage) button.getScene().getWindow();
        intro.close();

        try{
            Stage run = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("running_program.fxml").openStream());
            run.setScene(new Scene(root));
            run.show();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
