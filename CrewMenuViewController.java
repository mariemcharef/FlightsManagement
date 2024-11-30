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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CrewMenuViewController implements Initializable {

    @FXML
    private VBox id5;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickFlights(ActionEvent event) {
        try{           
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FlightsManagement.fxml"));
        Parent root = loader.load();

        Stage st = new Stage();
        st.setScene(new Scene(root));
        st.setTitle("Flights");
        st.show();
    } catch (IOException ex) {
        Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void clickReservation(ActionEvent event) {
    }

    @FXML
    private void clickPassagers(ActionEvent event) {
    }

    @FXML
    private void clickreturn(ActionEvent event) {
        try {
            Stage currentStage = (Stage) id5.getScene().getWindow(); 
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
    private void accountsettings(ActionEvent event) {
        try{           
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountSettings.fxml"));
        Parent root = loader.load();
        Stage st = new Stage();
        st.setScene(new Scene(root));
        st.setTitle("Settings");
                st.show();
    } catch (IOException ex) {
        Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
