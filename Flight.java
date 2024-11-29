/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fligths;

/**
 *
 * @author MARIEM
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class Flight {
    public int number;
    public Airport departure_airport;
    public Airport arrival_airport;
    public float duration;
    public LocalDateTime departure_time;
    Status status;//programmé,retardé ou en vol
    

    public Flight(int number, Airport departure_airport, Airport arrival_airport, float duration) {
        this.number = number;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.duration = duration;
         
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Airport getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(Airport departure_airport) {
        this.departure_airport = departure_airport;
    }

    public Airport getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(Airport arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(LocalDateTime departure_time) {
        this.departure_time = departure_time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "Flight{" + "number=" + number + ", departure_airport=" + departure_airport + ", arrival_airport=" + arrival_airport + ", duration=" + duration + ", id=" + id + ", departure_time=" + departure_time + ", status=" + status + '}';
    }
   
   
    
    
   
    
}


