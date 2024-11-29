/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import Person.Account;
import Person.Admin;
import Person.Crew;
import Person.Pilot;
import Person.Role;
import static Person.Role.Admin;
import Person.Status;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {

    @FXML
    private TextField textid;
    @FXML
    private PasswordField textpassword;
    @FXML
    private Label Id;
    @FXML
    private Label Password;
    @FXML
    private Label msg;
    @FXML
    private VBox id1;
    @FXML
    private Button previous;

    private Role role; 
    private final LinkedList<Admin> list1 = new LinkedList<>();
    private final LinkedList<Crew> list2 = new LinkedList<>();
    private final LinkedList<Pilot> list3 = new LinkedList<>();

    public void setRole(Role role) {
        this.role = role;
        if (Id != null) {
            Id.setText(role + " Id :");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list1.add(new Admin(1, "123", "ghj", "bb", 1234, new Account(1, "123", Status.ACTIVE, Role.Admin)));
        list2.add(new Crew(2, "123", "ghj", "bb", 1422, new Account(2, "123", Status.ACTIVE, Role.Crew)));
        list3.add(new Pilot(3, "123", "ghj", "bb", 1231, new Account(3, "123", Status.ACTIVE, Role.Pilot)));
    }
    @FXML
    private void clickedok(ActionEvent event) {
        if (textid.getText().isEmpty() || textpassword.getText().isEmpty()) {
            msg.setText("Please fill both fields");
            return;
        }
        try {
            int id = Integer.parseInt(textid.getText());
            String password = textpassword.getText();
            boolean ok = false;

            if (role == Role.Admin) {
                ok = list1.stream().anyMatch(admin -> admin.VerifLogin(id, password));
                if (ok) {
                id1.getScene().getWindow().hide();
                Stage st = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("ViewAdminMenu.fxml"));
                st.setScene(new Scene(root));
                st.setTitle("admin menu");
                st.show();
            } else {
                msg.setText("ID or password not valid");
            }
            } else if (role == Role.Crew) {
                ok = list2.stream().anyMatch(crew -> crew.VerifLogin(id, password));
                if (ok) {
                    id1.getScene().getWindow().hide();
                    Stage st = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("CrewMenuView.fxml"));
                    st.setScene(new Scene(root));
                    st.setTitle("Crew Menu");
                    st.show();
            } else {
                msg.setText("ID or password not valid");
            }
            } else if (role == Role.Pilot) {
                ok = list3.stream().anyMatch(pilot -> pilot.VerifLogin(id, password));
                if (ok) {
                id1.getScene().getWindow().hide();
                Stage st = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("PilotMenuView.fxml"));
                st.setScene(new Scene(root));
                st.setTitle("menu pilote");
                st.show();
            } else {
                msg.setText("ID or password not valid");
            }
            }
        } catch (NumberFormatException e) {
            msg.setText("ID must be a valid number");
        } catch (IOException e) {
            Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, e);
            msg.setText("Error loading the next page");
        }
    }
    @FXML
    private void clickreturn(ActionEvent event) {
         try {
            Stage currentStage = (Stage) id1.getScene().getWindow(); 
            currentStage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Home");
            stage.setScene(new Scene(root));
            stage.show();
    } catch (IOException e) {
        Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, e);
        msg.setText("Error loading the previous page");
    }
    }
    @FXML
    private void clickedreset(ActionEvent event) {
        textid.clear();
        textpassword.clear();
        msg.setText("");
    }
}
