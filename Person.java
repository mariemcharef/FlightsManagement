
package Person;

import java.util.Scanner;

public sealed class Person permits Admin ,Crew ,Pilot{
    public int id;
    public String nom;
    public String address;
    public String mail;
    public int phoneNumber;
    public Account account;

    public Person(int id, String nom, String address, String mail, int phoneNumber,Account account) {
        this.id = id;
        this.nom = nom;
        this.address = address;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.account=account;
    }
    public Account getCompte() {
        return account;
    }
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAddress() {
        return address;
    }

    public String getMail() {
        return mail;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhoneNum(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", nom=" + nom + ", address=" + address + ", mail=" + mail + ", phoneNum=" + phoneNumber + '}';
    }
    
    
}
