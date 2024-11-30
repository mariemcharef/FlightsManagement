/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AirCraft;

import java.util.EnumSet;

/**
 *
 * @author moham
 * 
 * 
 * Each seat has: 
 *  seat type = {business , economy } 
 *  seatAvailabliity = {available, inavalable}
 *  and correspond to a certain aircraft
 * 
 * 
 */

public class Seat {
    private int  seatNumber;
    private SeatType seatType;
    private SeatAvailability seatAvailability;
    private AirCraft aircraft;

    public SeatAvailability getSeatAvailability() {
        return seatAvailability;
    }

    public AirCraft getAircraft() {
        return aircraft;
    }
    
   public Seat(int seatNumber, SeatType seatType, SeatAvailability seatAvailability) {
    if (seatNumber < 0) {
        throw new IllegalArgumentException("Seat Number must be positive");
    }
    if (seatType == null) {
        throw new IllegalArgumentException("Seat Type must be BUSINESS or ECONOMY");
    }
    if (seatAvailability == null) {
        throw new IllegalArgumentException("Seat Availability must be AVAILABLE or INAVAILABLE");
    }

    this.seatNumber = seatNumber;
    this.seatType = seatType;
    this.seatAvailability = seatAvailability;
}

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    /*
    *  Asign a seat to an aircraft only if that seat is not in the seats' aircraft seat
    *  and simultinously assign the aircraft for the seat
    */
    public void assignAirCraft(AirCraft airCraft)throws DuplicateElementException{
        if(airCraft.getSeats().contains(this))
            throw new DuplicateElementException("Aircraft already contains that seat");
        airCraft.addSeat(this);
        this.aircraft = airCraft;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "Seat{" + "seatNumber=" + seatNumber + ", seatType=" + seatType + ", seatAvailability=" + seatAvailability + ", aircraft=" + aircraft + '}';
    }
    
    
}
