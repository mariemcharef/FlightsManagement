import Person.Account;
import Person.Admin;
import Person.Crew;
import Person.Pilot;
import Person.Role;
import Person.Status;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ViewAddAccountController {

    @FXML
    private TextField textName;
    @FXML
    private TextField textAddress;
    @FXML
    private TextField textMail;
    @FXML
    private TextField textPhone;
    @FXML
    private SplitMenuButton idrole;
    @FXML
    private SplitMenuButton idstatus;
    @FXML
    private VBox id7;

    private final LinkedList<Admin> list1 = new LinkedList<>();
    private final LinkedList<Crew> list2 = new LinkedList<>();
    private final LinkedList<Pilot> list3 = new LinkedList<>();
    @FXML
    private Label name;
    @FXML
    private Label address;
    @FXML
    private Label mail;
    @FXML
    private Label number;

    @FXML
    private void admin(ActionEvent event) {
        idrole.setText("Admin");
    }

    @FXML
    private void pilote(ActionEvent event) {
        idrole.setText("Pilot");
    }

    @FXML
    private void crew(ActionEvent event) {
        idrole.setText("Crew");
    }

    @FXML
    private void acive(ActionEvent event) {
        idstatus.setText("Active");
    }

    @FXML
    private void inactive(ActionEvent event) {
        idstatus.setText("Inactive");
    }

    @FXML
    private void cancel(ActionEvent event) {
        try {
            Stage currentStage = (Stage) id7.getScene().getWindow();
            currentStage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewUserManagement.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("User Management");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            Logger.getLogger(ViewAddAccountController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void ok(ActionEvent event) {
        if (validateInputs()) {
            Random random = new Random();
            int id = random.nextInt(10000);
            Account account = new Account(id, "123", getStatus(), getRole());

            switch (getRole()) {
                case Admin -> {
                    Admin admin = new Admin(id, textName.getText(), textAddress.getText(), textMail.getText(), Integer.valueOf(textPhone.getText()), account);
                    list1.add(admin);
                    showAlert(AlertType.INFORMATION, "Success", "Admin added successfully !\nID: " + id + "\nPassword: " + account.getPassword());
                }
                case Crew -> {
                    Crew crew = new Crew(id, textName.getText(), textAddress.getText(), textMail.getText(), Integer.valueOf(textPhone.getText()), account);
                    list2.add(crew);
                    showAlert(AlertType.INFORMATION, "Success", "Crew added successfully !\nID: " + id + "\nPassword: " + account.getPassword());
                }
                case Pilot -> {
                    Pilot pilote = new Pilot(id, textName.getText(), textAddress.getText(), textMail.getText(), Integer.valueOf(textPhone.getText()), account);
                    list3.add(pilote);
                    showAlert(AlertType.INFORMATION, "Success", "Pilot added successfully  !\nID: " + id + "\nPassword: " + account.getPassword());
                }
                default -> showAlert(AlertType.ERROR, "Error", "Role not recognised !");
            }
        }
    }

    private boolean validateInputs() {
        if (textName.getText().isEmpty() || textAddress.getText().isEmpty() || textMail.getText().isEmpty() || textPhone.getText().isEmpty()) {
            showAlert(AlertType.WARNING, "Validation", "Please complete all fields.");
            return false;
        }
        if (idrole.getText().equals("Role") || idstatus.getText().equals("Status")) {
            showAlert(AlertType.WARNING, "Validation", "Please select a role and status.");
            return false;
        }
        return true;
    }

    private Role getRole() {
        return switch (idrole.getText()) {
            case "Admin" -> Role.Admin;
            case "Crew" -> Role.Crew;
            case "Pilot" -> Role.Pilot;
            default -> null;
        };
    }

    private Status getStatus() {
        return idstatus.getText().equals("Active") ? Status.ACTIVE : Status.INACTIVE;
    }

    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void textMail(MouseEvent event) {
    }

    @FXML
    private void handleTextMailAction(ActionEvent event) {
    }

    @FXML
    private void textNumber(MouseEvent event) {
    }

    @FXML
    private void role(ActionEvent event) {
    }

    @FXML
    private void status(ActionEvent event) {
    }
}
