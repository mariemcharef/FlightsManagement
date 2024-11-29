

import com.mycompany.fligths.FlightStatus;
import com.mycompany.fligths.Airport;
import com.mycompany.fligths.Flight;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private TextField flightNumberField;
    @FXML
    private TextField departureField, arrivalField, statusField, statusFilterField;

    private final ObservableList<Flight> flightList = FXCollections.observableArrayList();

    public void initialize() {
        numberColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNumber()));
        departureColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDeparture_airport().name()));
        arrivalColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getArrival_airport().name()));
        statusColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getStatus().getDisplayName()));

        flightTable.setItems(flightList);
    }

    @FXML
    public void handleAddFlight() {
        try {
            int number = Integer.parseInt(flightNumberField.getText());
            String departure = departureField.getText();
            String arrival = arrivalField.getText();
            String statusStr = statusField.getText();

            FlightStatus status = FlightStatus.valueOf(statusStr.toUpperCase());

            Airport departureAirport = new Airport(departure, "Location","123"); 
            Airport arrivalAirport = new Airport(arrival, "Location","321");
            Flight newFlight = new Flight(number, departureAirport, arrivalAirport,status);
            flightList.add(newFlight);
            flightNumberField.clear();
            departureField.clear();
            arrivalField.clear();
            statusField.clear();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Flight Number must be a number.");
        } catch (IllegalArgumentException e) {
            showAlert("Invalid Status", "Invalid status provided. Please use one of the following: Scheduled, Delayed, In Flight, Canceled.");
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
