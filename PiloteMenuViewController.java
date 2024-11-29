/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MARIEM
 */
public class PiloteMenuViewController implements Initializable {

    @FXML
    private VBox id4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void checkArrivals(ActionEvent event) {
    }

    @FXML
    private void checkPast(ActionEvent event) {
    }

    @FXML
    private void checkCanceled(ActionEvent event) {
    }

    @FXML
    private void checkModify(ActionEvent event) {
    }

    @FXML
    private void checkreturn(ActionEvent event) {
        try {
            Stage currentStage = (Stage) id4.getScene().getWindow(); 
            currentStage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Home");
            stage.setScene(new Scene(root));
            stage.show();
    } catch (IOException e) {
        Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, e);
        
    }
    }

    @FXML
    private void accountsettings(MouseEvent event) {
        
    }
    
}
