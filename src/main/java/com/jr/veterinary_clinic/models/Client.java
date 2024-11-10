package com.jr.veterinary_clinic.models;

import com.jr.veterinary_clinic.services.utils.RegexUtil;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private int id;
    @NotBlank
    private String lastName;
    private String firstName;
    private String address1;
    private String address2;
    private String postcode;
    private String city;
    private String phone;
    private String insurance;
    private String mail;
    private String comment;
    private boolean active;
    private List<Animal> animals = new ArrayList<Animal>();

    public Client() {
    }

    public Client(String lastName,
                  String firstName,
                  String address1,
                  String address2,
                  String postcode,
                  String city,
                  String phone,
                  String insurance,
                  String mail,
                  String comment,
                  boolean active,
                  List<Animal> animals) {
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setAddress1(address1);
        this.setAddress2(address2);
        this.setPostcode(postcode);
        this.setCity(city);
        this.setPhone(phone);
        this.setInsurance(insurance);
        this.setMail(mail);
        this.setComment(comment);
        this.setActive(active);
        this.setAnimals(animals);
    }

    public Client(int id,
                  String lastName,
                  String firstName,
                  String address1,
                  String address2,
                  String postcode,
                  String city,
                  String phone,
                  String insurance,
                  String mail,
                  String comment,
                  boolean active,
                  List<Animal> animals) {
        this.setId(id);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setAddress1(address1);
        this.setAddress2(address2);
        this.setPostcode(postcode);
        this.setCity(city);
        this.setPhone(phone);
        this.setInsurance(insurance);
        this.setMail(mail);
        this.setComment(comment);
        this.setActive(active);
        this.setAnimals(animals);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getMail() {
        return mail;
    }

    // TODO T.U
    public void setMail(String mail) {
        if (!RegexUtil.isValidEmail(mail)) {
            throw new IllegalArgumentException("L'email " + mail + " est invalide.");
        } else {
            this.mail = mail;
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", insurance='" + insurance + '\'' +
                ", mail='" + mail + '\'' +
                ", comment='" + comment + '\'' +
                ", active=" + active +
                ", animals=" + animals +
                '}';
    }

}