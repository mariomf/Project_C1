package com.project.project_C_1.entity;



//import org.springframework.data.annotation.Id;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



public class Form{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idForm;

    private String FirstName;
    private String LastName;
    private String Phone1;
    private String Email;



    private String Direction1;
    private String Direction2;
    private String Country;
    private String State1;
    private String PostalCode;

    private String ShippingDay;
    private String ShippingTime;

    public Form(int idForm, String FirstName, String LastName, String Phone1, String Email, String Direction1, String Direction2,
                String Country, String State1, String PostalCode, String ShippingDay, String ShippingTime){

        this.idForm = idForm;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone1 = Phone1;
        this.Email = Email;
        this.Direction1 = Direction1;
        this.Direction2 = Direction2;
        this.Country = Country;
        this.State1 = State1;
        this.PostalCode = PostalCode;
        this.ShippingDay = ShippingDay;
        this.ShippingTime = ShippingTime;
    }

    public Form(){

    }

    public int getIdForm() {
        return idForm;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone1() { return Phone1; }

    public void setPhone1(String phone1) { Phone1 = phone1; }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDirection1() {
        return Direction1;
    }

    public void setDirection1(String direction1) {
        Direction1 = direction1;
    }

    public String getDirection2() {
        return Direction2;
    }

    public void setDirection2(String direction2) {
        Direction2 = direction2;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getState1() {
        return State1;
    }

    public void setState1(String state1) {
        State1 = state1;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getShippingDay() {
        return ShippingDay;
    }

    public void setShippingDay(String shippingDay) {
        ShippingDay = shippingDay;
    }

    public String getShippingTime() {
        return ShippingTime;
    }

    public void setShippingTime(String shippingTime) {
        ShippingTime = shippingTime;
    }

}
