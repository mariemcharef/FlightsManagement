import com.mycompany.fligths.FlightStatus;
import com.mycompany.fligths.Airport;
import com.mycompany.fligths.Flight;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FlightsManagementController {

    @FXML
    private TableView<Flight> flightTable;
    @FXML
    private TableColumn<Flight, Integer> numberColumn;
    @FXML
    private TableColumn<Flight, String> departureColumn;
    @FXML
    private TableColumn<Flight, String> arrivalColumn;
    @FXML
    private TableColumn<Flight, String> statusColumn;
     @FXML
    private TableColumn<Flight, String> timeColumn; 
    @FXML
    private TableColumn<Flight, String> durationColumn;
    @FXML
    private TextField flightNumberField, departureField, arrivalField, statusField, statusFilterField,durationField,departureTimeField;
    
    private final ObservableList<Flight> flightList = FXCollections.observableArrayList();
    @FXML
    private VBox id11;
    public void initialize() {
        numberColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNumber()));
        departureColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDeparture_airport().name()));
        arrivalColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getArrival_airport().name()));
        statusColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getStatus().getDisplayName()));
        timeColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDeparture_time().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
        durationColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(String.format("%.2f hours", data.getValue().getDuration())));
        flightTable.setItems(flightList);
    }
    @FXML
    public void handleAddFlight() {
        try {
             int number = Integer.parseInt(flightNumberField.getText());
            String departure = departureField.getText();
            String arrival = arrivalField.getText();
            String statusStr = statusField.getText();
            String departureTimeStr = departureTimeField.getText();
            float duration = Float.parseFloat(durationField.getText());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime departureTime = LocalDateTime.parse(departureTimeStr, formatter);

            FlightStatus status = FlightStatus.valueOf(statusStr.toUpperCase());

            Airport departureAirport = new Airport(departure, "Location", "123");
            Airport arrivalAirport = new Airport(arrival, "Location", "321");

            Flight newFlight = new Flight(number, departureAirport, arrivalAirport, duration, departureTime, status);
            flightList.add(newFlight);

            clearInputFields();
    } catch (NumberFormatException e) {
        showAlert("Invalid Input", "Please ensure Flight Number and Duration are numbers.");
    } catch (IllegalArgumentException e) {
        showAlert("Invalid Status", "Invalid status provided. Use Scheduled, Delayed, In Flight, etc.");
    } catch (Exception e) {
        showAlert("Invalid Input", "Please check the departure time format: yyyy-MM-dd HH:mm.");
    }
    }
    @FXML
    public void handleFilterByStatus() {
        String filterStatus = statusFilterField.getText().toUpperCase();
        ObservableList<Flight> filteredFlights = flightList.stream()
                .filter(flight -> flight.getStatus().toString().equalsIgnoreCase(filterStatus))
                .collect(FXCollections::observableArrayList, ObservableList::add, ObservableList::addAll);

        flightTable.setItems(filteredFlights);
    }
    private void clearInputFields() {
        flightNumberField.clear();
        departureField.clear();
        arrivalField.clear();
        statusField.clear();
        departureTimeField.clear();
        durationField.clear();
    }
    @FXML
    public void handleResetTable() {
        flightTable.setItems(flightList);
        statusFilterField.clear();
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
