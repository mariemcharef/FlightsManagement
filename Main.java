/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Reservation;

import AirCraft.AirCraft;
import AirCraft.DuplicateElementException;
import AirCraft.Seat;
import AirCraft.SeatAvailability;
import AirCraft.SeatType;
import AirCraft.Status;
import com.mycompany.flights.Airport;
import com.mycompany.flights.Flight;
import java.util.Date;

/**
 *
 * @author moham
 */
public class Main {

    public static void main(String[] args) {
        Airport airport_departure = new Airport("Tunisair", "Tunis", "ID1");
        Airport airport_arrival = new Airport("Marocair", "Marocco", "ID2");

        Flight flight1 = new Flight(1, airport_departure, airport_arrival, com.mycompany.flights.FlightStatus.INFLIGHT);
        Flight flight2 = new Flight(2, airport_departure, airport_arrival, com.mycompany.flights.FlightStatus.DELAYED);

        AirCraft airCraft1 = new AirCraft("Helicopter", "Ss24", new Date(2000, 12, 05), Status.WORKING);
        
        Seat seat1 = new Seat(1, SeatType.BUSINESS, SeatAvailability.AVAILABLE);
        Seat seat2 = new Seat(2, SeatType.ECONOMY, SeatAvailability.AVAILABLE);

        try {
            seat1.assignAirCraft(airCraft1);   // Automatically seat1 will be assinged to aircraft1 and the list of seats of aircraft1 will contain seat1
        } catch (DuplicateElementException e) {
            System.out.println(e.getMessage());
        }
        try {
            seat2.assignAirCraft(airCraft1);
        } catch (DuplicateElementException e) {
            System.out.println(e.getMessage());
        }
        FlightSeat flightSeat1 =(FlightSeat) seat1;
        flightSeat1.setPrice(1000);
        flightSeat1.setResevationNumber("11d");
        flightSeat1.setFlight(flight1);
        
        FlightSeat flightSeat2 = (FlightSeat) seat2;
        flightSeat2.setPrice(1000);
        flightSeat2.setResevationNumber("11d");
        flightSeat2.setFlight(flight1);
        
        
        Passenger passenger1 = new Passenger("Mohamed", "Bouafif", new Date(2001, 12, 05),"NB55JD");
        Passenger passenger2= new Passenger("Mariem", "Charef", new Date(2002, 12, 05),"CCNF445");
        try{
            passenger1.assignFlightSeatToPassenger(flightSeat1);
        } catch(AvailabilityException e){
            System.out.println(e.getMessage());
        }
        try{
            passenger1.assignFlightSeatToPassenger(flightSeat2);
        } catch(AvailabilityException e){
            System.out.println(e.getMessage());
        }
        
        FlightReservation flightReservation = new FlightReservation("1",flight1);
        System.out.println("The reservations:\n" + flightReservation);
        

        
    }

}
