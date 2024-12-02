/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservation;

import AirCraft.Seat;
import AirCraft.SeatAvailability;
import AirCraft.SeatType;
import com.mycompany.flights.Flight;

/**
 *
 * @author moham
 * 
 * the flight seat status must be changed to inavailable when we assign to it a passenger
 * 
 */
//A flight seat is a seat that belongs to a flight -> its a seat that has a price , reservationNumber and a flight that it belongs to 
public class FlightSeat extends Seat{
    private float price;
    private String resevationNumber;
    private Flight flight;
    
    public FlightSeat(float price, String reservationNumber,int seatNumber, SeatType seatType, SeatAvailability seatAvailability){
        super(seatNumber, seatType, seatAvailability);
        this.price = price;
        this.resevationNumber = reservationNumber;
        
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public float getPrice() {
        return price;
    }

    public String getResevationNumber() {
        return resevationNumber;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setResevationNumber(String resevationNumber) {
        this.resevationNumber = resevationNumber;
    }

    @Override
    public String toString() {
        return "FlightSeat{" + "price=" + price + ", resevationNumber=" + resevationNumber + ", flight=" + flight + '}';
    }
    
    
            
}
