import Person.Account;
import Person.Admin;
import Person.Crew;
import Person.Person;
import Person.Pilot;
import Person.Role;
import Person.Status;
import com.mycompany.flights.Flight;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application {
    public static List<Person> persons = new ArrayList<>();
    public static List<Flight> Flights = new ArrayList<>();
    public static List<Flight> accounts = new ArrayList<>();
    public static List<Flight> Aircraft = new ArrayList<>();
    public static LinkedList<Admin> list1 = new LinkedList<>();
    public static LinkedList<Crew> list2 = new LinkedList<>();
    public static LinkedList<Pilot> list3 = new LinkedList<>();

    
    static {
        list1.add(new Admin(1, "123", "Address1", "Admin@gmail.com", 1234, new Account(1, "123", Status.ACTIVE, Role.Admin)));
        list2.add(new Crew(2, "123", "Address2", "Crew@gmail.com", 1422, new Account(2, "123", Status.ACTIVE, Role.Crew)));
        list3.add(new Pilot(3, "123", "Address3", "Pilot@gmail.com", 1231, new Account(3, "123", Status.ACTIVE, Role.Pilot)));
        persons.add(new Admin(1, "123", "Address1", "Admin@gmail.com", 1234, new Account(1, "123", Status.ACTIVE, Role.Admin)));
        persons.add(new Crew(2, "123", "Address2", "Crew@gmail.com", 1422, new Account(2, "123", Status.ACTIVE, Role.Crew)));
        persons.add(new Pilot(3, "123", "Address3", "Pilot@gmail.com", 1231, new Account(3, "123", Status.ACTIVE, Role.Pilot)));
        
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Home");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
