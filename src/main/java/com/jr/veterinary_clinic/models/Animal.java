package com.jr.veterinary_clinic.models;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    private int id;
    private String name;
    private String sex;
    private String color;
    private String tattoo;
    private String antecedent;
    private boolean active;
    private Breed breed;
    private Client owner;
    private List<Agenda> appointmentsList = new ArrayList<Agenda>();

    public Animal() {}

    public Animal(String name, String sex, String color, String tattoo, String antecedent, boolean active, Breed breed, Client owner, List<Agenda> appointmentsList) {
        this.setName(name);
        this.setSex(sex);
        this.setColor(color);
        this.setTattoo(tattoo);
        this.setAntecedent(antecedent);
        this.setActive(active);
        this.setBreed(breed);
        this.setOwner(owner);
        this.setAppointmentsList(appointmentsList);
    }

    public Animal(int id, String name, String sex, String color, String tattoo, String antecedent, boolean active, Breed breed, Client owner, List<Agenda> appointmentsList) {
        this.setId(id);
        this.setName(name);
        this.setSex(sex);
        this.setColor(color);
        this.setTattoo(tattoo);
        this.setAntecedent(antecedent);
        this.setActive(active);
        this.setBreed(breed);
        this.setOwner(owner);
        this.setAppointmentsList(appointmentsList);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTattoo() {
        return tattoo;
    }

    public void setTattoo(String tattoo) {
        this.tattoo = tattoo;
    }

    public String getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(String antecedent) {
        this.antecedent = antecedent;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public List<Agenda> getAppointmentsList() {
        return appointmentsList;
    }

    public void setAppointmentsList(List<Agenda> appointmentsList) {
        this.appointmentsList = appointmentsList;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", color='" + color + '\'' +
                ", tattoo='" + tattoo + '\'' +
                ", antecedent='" + antecedent + '\'' +
                ", active=" + active +
                ", breed=" + breed +
                ", owner=" + owner +
                ", appointmentsList=" + appointmentsList +
                '}';
    }

}
