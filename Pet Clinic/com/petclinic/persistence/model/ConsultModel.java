package com.petclinic.persistence.model;

public class ConsultModel extends Model {
    private VetModel vet = new VetModel();
    private PetModel pet = new PetModel();
    private String date;
    private String description;

    public VetModel getVet() {
        return vet;
    }

    public void setVet(VetModel vet) {
        this.vet = vet;
    }

    public PetModel getPet() {
        return pet;
    }

    public void setPet(PetModel pet) {
        this.pet = pet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
