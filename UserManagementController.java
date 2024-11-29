import Person.Account;
import Person.Role;
import Person.Status;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserManagementController {

    @FXML
    private Button viewAccountsButton;
    @FXML
    private Button addAccountButton;
    @FXML
    private Button modifyAccountButton;
    @FXML
    private Button deleteAccountButton;
    @FXML
    private Button cancelButton;

    @FXML
    private TextField textName;
    @FXML
    private TextField textAddress;
    @FXML
    private TextField textMail;
    @FXML
    private TextField textPhone;
    @FXML
    private Button returnButton;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private ListView<String> accountsListView;

    @FXML
    private AnchorPane id8;

    private ObservableList<String> accountsList;
    private ObservableList<Account> accounts = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        viewAccountsButton.setOnAction(this::viewAccounts);
        addAccountButton.setOnAction(this::addAccount);
        modifyAccountButton.setOnAction(this::modifyAccount);
        deleteAccountButton.setOnAction(this::deleteAccount);
        cancelButton.setOnAction(this::cancelAction);

        roleComboBox.getItems().addAll("Admin", "Crew", "Pilot");

        accountsList = FXCollections.observableArrayList();
        accountsListView.setItems(accountsList);
    }

    private void viewAccounts(ActionEvent event) {
        accountsList.clear();
        for (Account account : accounts) {
            accountsList.add(account.toString());
        }
    }

    private void addAccount(ActionEvent event) {
        if (validateInputs()) {
            Random random = new Random();
            int id = random.nextInt(10000);

            Account account = new Account(id, "123", getStatus(), getRole1());
            accounts.add(account);

            showAlert(AlertType.INFORMATION, "Success", "Account added successfully!\nID: " + id + "\nPassword: 123");
            viewAccounts(null);
        }
    }

    private void modifyAccount(ActionEvent event) {
        if (accountsListView.getSelectionModel().getSelectedItem() != null) {
            String selectedAccount = accountsListView.getSelectionModel().getSelectedItem();
            int accountId = Integer.parseInt(selectedAccount.split(":")[1].trim());

            Account accountToModify = null;
            for (Account account : accounts) {
                if (account.getId() == accountId) {
                    accountToModify = account;
                    break;
                }
            }

            if (accountToModify != null) {
                accountToModify.setRole(getRole1());
                showAlert(AlertType.INFORMATION, "Success", "Account modified successfully!");
                viewAccounts(null);
            } else {
                showAlert(AlertType.ERROR, "Error", "Account not found.");
            }
        } else {
            showAlert(AlertType.WARNING, "Selection", "Please select an account to modify.");
        }
    }

    private void deleteAccount(ActionEvent event) {
        if (accountsListView.getSelectionModel().getSelectedItem() != null) {
            String selectedAccount = accountsListView.getSelectionModel().getSelectedItem();
            int accountId = Integer.parseInt(selectedAccount.split(":")[1].trim());

            accounts.removeIf(account -> account.getId() == accountId);

            showAlert(AlertType.INFORMATION, "Success", "Account deleted successfully!");
            viewAccounts(null);
        } else {
            showAlert(AlertType.WARNING, "Selection", "Please select an account to delete.");
        }
    }

    private void cancelAction(ActionEvent event) {
        showAlert(AlertType.INFORMATION, "Cancelled", "Action cancelled.");
    }

    private boolean validateInputs() {
        if (textName.getText().isEmpty() || textAddress.getText().isEmpty() || textMail.getText().isEmpty() || textPhone.getText().isEmpty()) {
            showAlert(AlertType.WARNING, "Error", "All fields must be filled.");
            return false;
        }
        return true;
    }

    private Role getRole1() {
        String role = roleComboBox.getSelectionModel().getSelectedItem();
        if ("Admin".equals(role)) return Role.Admin;
        if ("Crew".equals(role)) return Role.Crew;
        if ("Pilot".equals(role)) return Role.Pilot;
        return null;
    }

    private Status getStatus() {
        return Status.ACTIVE;
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleReturnButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) id8.getScene().getWindow();
            currentStage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAdminMenu.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Admin Menu");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            Logger.getLogger(UserManagementController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
