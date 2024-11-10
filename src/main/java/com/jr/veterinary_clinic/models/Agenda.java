package com.jr.veterinary_clinic.models;

import java.util.Date;

public class Agenda {

    private Date appointmentDate;
    private Staff veterinary;
    private Animal animal;

    public Agenda() {}

    public Agenda(Date appointment_date, Staff veterinary, Animal animal) {
        this.setAppointment_date(appointment_date);
        this.setVeterinary(veterinary);
        this.setAnimal(animal);
    }

    public Date getAppointment_date() {
        return appointmentDate;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointmentDate = appointment_date;
    }

    public Staff getVeterinary() {
        return veterinary;
    }

    public void setVeterinary(Staff veterinary) {
        this.veterinary = veterinary;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "appointment_date=" + appointmentDate +
                ", veterinary=" + veterinary +
                ", animal=" + animal +
                '}';
    }

}
