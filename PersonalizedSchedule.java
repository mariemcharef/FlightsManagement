/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fligths;

/**
 *
 * @author MARIEM
 */
public final class PersonalizedSchedule extends Schedule{
    int annee;
    public PersonalizedSchedule(int day,String time,int annee ){
        super(day,time);
        this.annee=annee;
    }
}
