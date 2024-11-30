/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fligths;



/**
 *
 * @author MARIEM
 */
import Person.Account;
import Person.Admin;
import Person.Role;
import Person.Person;
import Person.Status;
import Person.VerifLogin;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Fligths implements VerifLogin{
     
    public static void main(String[] args)  {
         Scanner sc = new Scanner(System.in);
        
        try {
           List<Flight> flights =new LinkedList<>();
           flights.add(new Flight(102, new Airport("1111", "2222", "123"),new Airport("4111", "2111", "2133"),3.5f,LocalDateTime.parse("2024-12-02 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),FlightStatus.SCHEDULED));
           flights.add(new Flight(103, new Airport("1111", "2222", "123"),new Airport("1221", "222", "321"),3.5f,LocalDateTime.parse("2024-12-08 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),FlightStatus.SCHEDULED)); 
           flights.add(new Flight(102, new Airport("1111", "2222", "123"),new Airport("555", "2222", "11121"),3.5f,LocalDateTime.parse("2024-12-03 11:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),FlightStatus.DELAYED));
           //affichage:
           Collections.sort(flights,(j1,j2)->j1.getDeparture_time().compareTo(j2.getDeparture_time()));
   
            System.out.println("flights sorted : ");
            flights.forEach(System.out::println);

           
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter valid data.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close(); 
        }
    }

    @Override
    public boolean VerifLogin(int i, String s, Role r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    }

        
        
   
