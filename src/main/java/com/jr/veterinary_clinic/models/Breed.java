package com.jr.veterinary_clinic.models;

public class Breed {

    private int id;
    private String breed;
    private String species;

    public Breed() {}

    public Breed(int id, String breed, String species) {
        this.setId(id);
        this.setBreed(breed);
        this.setSpecies(species);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", species='" + species + '\'' +
                '}';
    }

}
