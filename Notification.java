/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notification;

import java.time.LocalDateTime;

/**
 *
 * @author MARIEM
 */
public sealed class Notification permits EmailNotification,SMSNotification{
    public int id;
    public LocalDateTime date;
    public String contenue;

    public Notification(int id, LocalDateTime date, String contenue) {
        this.id = id;
        this.date = date;
        this.contenue = contenue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    @Override
    public String toString() {
        return "Notification{" + "id=" + id + ", date=" + date + ", contenue=" + contenue + '}';
    }
    
}
