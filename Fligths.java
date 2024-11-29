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
import java.util.InputMismatchException;
import java.util.Scanner;
public class Fligths implements VerifLogin{
     
    public static void main(String[] args)  {
         Scanner sc = new Scanner(System.in);
        
        try {
            // Create an Admin object with some sample data
            /*Admin admin = new Admin(1, "Alice", "123 Main St", "alice@example.com", 5551234);

            // Set up an account for the admin
            System.out.println("Setting up an account...");
            admin.setAccount();

            // Prompt user to re-enter credentials for validation
            System.out.println("*******************************");
            
            

            if (admin.VerifLogin(1, "4")) {
                System.out.println("Access granted: ID and password are valid.");
            } else {
                System.out.println("Access denied: ID and/or password are incorrect.");
            }*/
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter valid data.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close(); // Ensure the scanner is closed
        }
    }

    

    @Override
    public boolean VerifLogin(int i, String s, Role r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
        
    }

        
        
   
